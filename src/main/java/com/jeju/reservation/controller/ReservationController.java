package com.jeju.reservation.controller;

import java.text.DecimalFormat;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		model.addAttribute("startDate1", format1);
		model.addAttribute("startDate2", format2);
		model.addAttribute("endDate1", format3);
		model.addAttribute("endDate2", format4);
		mv.addObject("p", pension);
		mv.addObject("r", room);
		mv.setViewName("/reservation/list");		
		return mv;
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
			@RequestParam("roomNo") Integer roomNo,
			@RequestParam("rePensionNo") Integer rePensionNo,
			@RequestParam("rePrice") Integer rePrice
			,HttpSession session) {		
		Member member = (Member) session.getAttribute("loginUser");
		String memberId = member.getMemberId();
		Reservation reservation = new Reservation();
		reservation.setMemberId(memberId);
		reservation.setRoomNo(roomNo);
		reservation.setRePensionNo(rePensionNo);
		reservation.getRePrice();
		int result = aService.addReservation(reservation);
		if(result > 0) {
			System.out.println("예약 성공!");
		}
		return "예약 성공!";	
	}
	
	@RequestMapping(value="/reservation/myPage", method=RequestMethod.GET)
	public String reservationMyPage() {		
		return "mypage/reservation";	
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
