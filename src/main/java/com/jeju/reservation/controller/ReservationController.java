package com.jeju.reservation.controller;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;

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
			,Model model) throws ParseException {
		//숙소이름 가져오는 작업
		DecimalFormat decFormat = new DecimalFormat("###,###");
		String changePrice = decFormat.format(Integer.parseInt(price));
		String format1 = (startDate.replace("-", "")).substring(4,6);	//현재 20220101에서 앞에 월만 짜름
		String format2 = (startDate.replace("-", "")).substring(6);	//현재 20220101에서 뒤에 일자만 자름
		String format3 = (endDate.replace("-", "")).substring(4,6);	//현재 20220101에서 앞에 월만 짜름
		String format4 = (endDate.replace("-", "")).substring(6);	//현재 20220101에서 뒤에 일자만 자름
		//펜션 정보 가져옴
		Pension pension = aService.selectOneByPension(pensionNo);
		//룸 정보 가져옴
		Room room = aService.selectOneByRoom(roomNo);
		System.out.println(room.getRoomName());
		model.addAttribute("price", price);
		model.addAttribute("changePrice", changePrice);
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

	@ResponseBody
	@RequestMapping(value="/reservation/checkSessionId", produces="text/plain;charset=utf-8", method=RequestMethod.POST)
	public String checkSessionId(HttpSession session) {
		String chkSession = "";
		Member member = (Member) session.getAttribute("loginUser");
		chkSession = member.getMemberId();
		if(member.getMemberId() == null) {
			chkSession = "";
		}
		return chkSession;
	}

	@RequestMapping(value = "/reservation/phoneCheck", method = RequestMethod.GET)
	@ResponseBody
	public String sendSMS(@RequestParam("memberPhone") String userPhoneNumber) { // �޴��� ���ں�����
		int randomNumber = (int)((Math.random()* (9999 - 1000 + 1)) + 1000);//���� ����

		aService.certifiedPhoneNumber(userPhoneNumber,randomNumber);
		
		return Integer.toString(randomNumber);
	}
	
	@ResponseBody
	@RequestMapping(value = "/reservation/success", method = RequestMethod.POST)
	public String addReservation(
			@ModelAttribute Reservation reservation
			,HttpSession session) {		
		Member member = (Member) session.getAttribute("loginUser");
		String memberId = member.getMemberId();
		reservation.setMemberId(memberId);
		Pension imageList = aService.selectImage(reservation.getRePensionNo());
		reservation.setReFilePath(imageList.getFilePath());
		reservation.setRePensionName(imageList.getPensionName());
		int result = aService.addReservation(reservation);
		if(result > 0) {
			System.out.println("예약 성공!");
		}
		return "예약 성공!";	
	}
	
	@ResponseBody
	@RequestMapping(value = "/reservation/waiting", method = RequestMethod.POST)
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
//		Reservation reservationNo = aService.selectReservationNo();
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
			for(int i=0; i<wList.size(); i++) {
				wList.get(i).setRePrice(decFormat.format(Integer.parseInt(wList.get(i).getRePrice())));
			}
			
			////////////////예약 완료 리스트///////////////////
			List<Reservation> rList = aService.selectReserveList(memberId);
			for(int i=0; i<rList.size(); i++) {
				rList.get(i).setRePrice(decFormat.format(Integer.parseInt(rList.get(i).getRePrice())));
			}

			
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
			DecimalFormat decFormat = new DecimalFormat("###,###");
			rList.setRePrice(decFormat.format(Integer.parseInt(rList.getRePrice())));		
		mv.addObject("rList", rList);
		mv.setViewName("mypage/reservationCancel");
		return mv;
	}
	
	
	//사용자가 결제대기 상태에서 직접 결제 취소요청 했을 경우
	@ResponseBody
	@RequestMapping(value="/reservation/deleteWaitReserve", method=RequestMethod.POST)
	public String deleteWaitReserve(@RequestParam("reservationNo") Integer reservationNo) {
		int result = aService.deleteWaitReserve(reservationNo);
		if(result > 0) {
			System.out.println("취소 성공!");
		}
		return "취소 성공";
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
	@RequestMapping(value="/reservation/waitAvailability", produces="text/plain;charset=utf-8", method=RequestMethod.POST)
	public String waitAvailability(@RequestParam("memberId") String memberId) {
		int count = aService.selectRstatus(memberId);
		System.out.println("카운트값 : "+count);
		return String.valueOf(count);		
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
