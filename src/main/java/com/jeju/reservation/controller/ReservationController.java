package com.jeju.reservation.controller;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jeju.coupon.domain.Coupon;
import com.jeju.coupon.domain.MyCoupon;
import com.jeju.member.domain.Member;
import com.jeju.pension.domain.Pension;
import com.jeju.reservation.domain.Reservation;
import com.jeju.reservation.service.ReservationService;
import com.jeju.room.domain.Room;

@Controller
public class ReservationController {
	@Autowired
	private ReservationService aService;

	@RequestMapping(value="/reservation/list", method=RequestMethod.GET)
	public ModelAndView showList(
			ModelAndView mv
			,@RequestParam("refPensionNo") Integer pensionNo
			,@RequestParam("roomNo") Integer roomNo
			,@RequestParam("startDate") String startDate
			,@RequestParam("endDate") String endDate
			,@RequestParam("price") String price
			,Model model
			,HttpSession session) throws ParseException {
		//숙소이름 가져오는 작업
		DecimalFormat decFormat = new DecimalFormat("###,###");
		String format1 = (startDate.replace("-", "")).substring(4,6);	//현재 20220101에서 앞에 월만 짜름
		String format2 = (startDate.replace("-", "")).substring(6);	//현재 20220101에서 뒤에 일자만 자름
		String format3 = (endDate.replace("-", "")).substring(4,6);	//현재 20220101에서 앞에 월만 짜름
		String format4 = (endDate.replace("-", "")).substring(6);	//현재 20220101에서 뒤에 일자만 자름
		Member member = (Member) session.getAttribute("loginUser");
		if(member != null) {
			String memberId = member.getMemberId();
			Member mOne = aService.selectOneByMember(memberId);
			List<Coupon> cList = new ArrayList<Coupon>();
			//쿠폰 정보 가져옴
			List<MyCoupon> myList = aService.selectAllMyCoupon(memberId);
			for(int i=0; i<myList.size(); i++) {
				Coupon coupon = aService.selectAllCouponList(myList.get(i).getCouponCode());		
				cList.add(i, coupon);
			}
			mv.addObject("cList", cList);
			mv.addObject("mOne", mOne);
		}
		
		//펜션 정보 가져옴
		Pension pension = aService.selectOneByPension(pensionNo);
		//룸 정보 가져옴
		Room room = aService.selectOneByRoom(roomNo);
		model.addAttribute("price", price);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);		
		model.addAttribute("startDate1", format1);
		model.addAttribute("startDate2", format2);
		model.addAttribute("endDate1", format3);
		model.addAttribute("endDate2", format4);
		mv.addObject("p", pension);
		mv.addObject("r", room);
		mv.setViewName("/reservation/list");		
		return mv;
	}
	
	@RequestMapping(value="/reservation/nonMemberList", method=RequestMethod.GET)
	public String nonMemberList() {
		return "/mypage/noMember";
	}
	
	@RequestMapping(value="/reservation/reservationDetail", method=RequestMethod.GET)
	public ModelAndView reservationDetail(
			ModelAndView mv,
			@RequestParam("reservationNo") Integer reservationNo
			) {
		Reservation reserveInfo = aService.selectReservationInfo(reservationNo);
		mv.addObject("reserveInfo", reserveInfo);
		mv.setViewName("/mypage/reservationDetail");
		return mv;
	}
	
	@RequestMapping(value="/reservation/searchNonMember", method=RequestMethod.POST)
	public ModelAndView searchNonMember(
			ModelAndView mv,
			@ModelAttribute Reservation reservation) {
		Reservation reserveInfo = aService.selectNonMemberInfo(reservation);
		mv.addObject("reserveInfo", reserveInfo);
		mv.setViewName("/mypage/nonReservation");
		return mv;
	}

	@ResponseBody
	@RequestMapping(value="/reservation/checkSessionId", produces="text/plain;charset=utf-8", method=RequestMethod.POST)
	public String checkSessionId(HttpSession session) {
		String chkSession = "";
		Member member = (Member) session.getAttribute("loginUser");	
		if(member == null) {
			chkSession = "";
		}else {
			chkSession = member.getMemberId();
		}
		return chkSession;
	}

	@RequestMapping(value = "/reservation/phoneCheck", method = RequestMethod.GET)
	@ResponseBody
	public String sendSMS(@RequestParam("memberPhone") String userPhoneNumber) {
		int randomNumber = (int)((Math.random()* (9999 - 1000 + 1)) + 1000);

		aService.certifiedPhoneNumber(userPhoneNumber,randomNumber);
		
		return Integer.toString(randomNumber);
	}
	
	@ResponseBody
	@RequestMapping(value = "/reservation/success", method = RequestMethod.POST)
	public String addReservation(
			@ModelAttribute Reservation reservation,
			@RequestParam(name="phone", required = false) String phoneNumber
			,HttpSession session) {	
		String memberId = "";
		Member member = (Member) session.getAttribute("loginUser");
		if(member != null) {
			String resultNum = "회원";
			memberId = member.getMemberId();
			reservation.setMemberId(memberId);
			reservation.setReservationCode(resultNum);
		}else {
			memberId = "비회원";
			reservation.setMemberId(memberId);
			
			Random random = new Random();		//랜덤 함수 선언
			int createNum = 0;  			//1자리 난수
			String ranNum = ""; 			//1자리 난수 형변환 변수
	        int letter    = 6;			//난수 자릿수:6
			String resultNum = "";  		//결과 난수			
			for (int i=0; i<letter; i++) { 	            		
				createNum = random.nextInt(9);		//0부터 9까지 올 수 있는 1자리 난수 생성
				ranNum =  Integer.toString(createNum);  //1자리 난수를 String으로 형변환
				resultNum += ranNum;			//생성된 난수(문자열)을 원하는 수(letter)만큼 더하며 나열
			}	
	        reservation.setReservationCode(resultNum);		            
		}
		
		Pension imageList = aService.selectImage(reservation.getRePensionNo());
		reservation.setReFilePath(imageList.getFilePath());
		reservation.setRePensionName(imageList.getPensionName());
		int result = aService.addReservation(reservation);		
		if(result > 0) {
			if(reservation.getMemberId().equals("비회원")) {
				aService.sendReservationCode(phoneNumber, reservation.getReservationCode());
			}
		}
		return memberId;	
	}
	
	@ResponseBody
	@RequestMapping(value = "/reservation/waiting", produces="text/plain;charset=utf-8", method = RequestMethod.POST)
	public String reservationWaiting(
			@ModelAttribute Reservation reservation
			,HttpSession session) {
		Member member = (Member) session.getAttribute("loginUser");
		String memberId = member.getMemberId();
		reservation.setMemberId(memberId);
		Pension imageList = aService.selectImage(reservation.getRePensionNo());
		reservation.setReFilePath(imageList.getFilePath());
		reservation.setRePensionName(imageList.getPensionName());
		int result = aService.addReservationWait(reservation);
		return "결제대기 추가 성공!";	
	}
	
	@RequestMapping(value="/reservation/myPage", method=RequestMethod.GET)
	public ModelAndView reservationMyPage(
			ModelAndView mv
			,HttpSession session) {
			DecimalFormat decFormat = new DecimalFormat("###,###");
			Member member = (Member) session.getAttribute("loginUser");
			String memberId = member.getMemberId();					
			/////////////////결제 대기 리스트//////////////////
			List<Reservation> wList = aService.selectWaitList(memberId);
			
//			////////////////예약 완료 리스트///////////////////
			List<Reservation> rList = aService.selectReserveList(memberId);
			List<Reservation> sList = aService.expirationReserveList(memberId);

			mv.addObject("sList", sList);
			mv.addObject("rList", rList);
			mv.addObject("wList", wList);
			mv.setViewName("/mypage/reservation");
		return mv;	
	}
	
	@RequestMapping(value="/reservation/cancel", method=RequestMethod.GET)
	public ModelAndView cancelReserve(
			ModelAndView mv,
			@RequestParam("reservationNo") Integer reservationNo
			) { 
		Reservation rList = aService.selectOneByWaitList(reservationNo);		
		mv.addObject("rList", rList);
		mv.setViewName("mypage/reservationCancel");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value="/reservation/reservationCancel", produces="text/plain;charset=utf-8", method=RequestMethod.POST)
	public String reservationCancel(
			@RequestParam("reservationNo") Integer reservationNo, HttpSession session) {
		Member member = (Member) session.getAttribute("loginUser");
		String memberId = member.getMemberId();
		Reservation reservation = aService.selectCouponCode(reservationNo);
		if(reservation.getCouponCode() != null && !reservation.getCouponCode().equals("")) {
			int result = aService.upCouponCount(reservation);
		}		
		String chk = "";
		int result = aService.deleteReservation(reservationNo);
		if(result > 0) {
			chk = "삭제완료";
		}
		return chk;		
	}
	
	
	//사용자가 결제대기 상태에서 직접 결제 취소요청 했을 경우
	@ResponseBody
	@RequestMapping(value="/reservation/deleteWaitReserve", method=RequestMethod.POST)
	public String deleteWaitReserve(@RequestParam("reservationNo") Integer reservationNo
			,HttpSession session) {
		Member member = (Member) session.getAttribute("loginUser");
		String memberId = member.getMemberId();
		Reservation reservation = aService.selectCouponCode(reservationNo);
		if(reservation.getCouponCode() != null && !reservation.getCouponCode().equals("")) {
			int result = aService.updateStatus(reservation);
		}
		int result = aService.deleteWaitReserve(reservationNo);
		return memberId;
	}
	
	//사용자가 결제대기 상태에서 30분넘어도 결제를 하지 않았을때 자동삭제
	@ResponseBody
	@RequestMapping(value="/reservation/removeWait", produces="text/plain;charset=utf-8", method=RequestMethod.POST)
	public String removeWaitReserve(@RequestParam("reservationName") String reservationName) {
		String chk = "";
		int result = aService.removeWaitReserve(reservationName);
		if(result > 0) {
			chk = "삭제 성공!";
		}else {
			chk = "삭제 실패!";
		}
		return chk;	
	}
	
	@ResponseBody
	@RequestMapping(value="/reservation/deleteReserve", produces="text/plain;charset=utf-8", method=RequestMethod.POST)
	public String deleteReserve(@ModelAttribute Reservation reservation) {
		String chk = "";
		int result = aService.deleteReserve(reservation);
		if(result > 0) {
			chk = "삭제성공";
		}
		return chk;
	}
	
	@ResponseBody
	@RequestMapping(value="/reservation/waitAvailability", produces="text/plain;charset=utf-8", method=RequestMethod.POST)
	public String waitAvailability(@RequestParam("memberId") String memberId) {
		int count = aService.selectRstatus(memberId);
		return String.valueOf(count);		
	}
	
	@ResponseBody
	@RequestMapping(value="/applyCoupon", produces="text/plain;charset=utf-8", method=RequestMethod.POST)
	public String applyCoupon(
			@RequestParam("salePrice") String salePrice,
			@RequestParam("rePrice") String rePrice) {
		String result = "";
		DecimalFormat decFormat = new DecimalFormat("###,###");
		int repriceNum = Integer.parseInt(rePrice.replaceAll("[^0-9]",""));
		int salePriceNum = Integer.parseInt(salePrice.replaceAll("[^0-9]",""));
		if(salePrice.contains("%")) {	
			int no =  repriceNum / 10; 	
			char firstNum = salePrice.charAt(0);			
			no = ((no * Character.getNumericValue(firstNum)));
			result = String.valueOf(decFormat.format(repriceNum - no));
		}else {
			result = String.valueOf(decFormat.format(repriceNum - Integer.parseInt(salePrice)));
		}	
		return result;
	}

	@ResponseBody
	@RequestMapping(value="/reservation/idNullCheck", produces="text/plain;charset=utf-8", method = RequestMethod.POST)
	public String idCheck(
			@RequestParam("nameChk") String nameChk) {
		return nameChk;		
	}
	
	@ResponseBody
	@RequestMapping(value="/reservation/agreeCheck1", produces="text/plain;charset=utf-8", method = RequestMethod.POST)
	public String idCheck1(
			@RequestParam("agree1") Boolean agree1) {
		return null;	
	}
	
	@ResponseBody
	@RequestMapping(value="/reservation/agreeCheck2", produces="text/plain;charset=utf-8", method = RequestMethod.POST)
	public String idCheck2(
			@RequestParam("agree2") Boolean agree2) {
		return null;	
	}
	
	@ResponseBody
	@RequestMapping(value="/reservation/agreeCheck3", produces="text/plain;charset=utf-8", method = RequestMethod.POST)
	public String idCheck3(
			@RequestParam("agree3") Boolean agree3) {
		return null;	
	}
	
}
