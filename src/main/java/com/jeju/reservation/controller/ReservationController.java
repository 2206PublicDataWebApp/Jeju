package com.jeju.reservation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jeju.reservation.domain.Reservation;
import com.jeju.reservation.service.ReservationService;

@Controller
public class ReservationController {
	@Autowired
	private ReservationService aService;

	@RequestMapping(value="/reservation/list", method=RequestMethod.GET)
	public String showList() {
		return "reservation/list";
	}
	
	//휴대폰인증 컨트롤러
	@RequestMapping(value = "/reservation/phoneCheck", method = RequestMethod.GET)
	@ResponseBody
	public String sendSMS(@RequestParam("memberPhone") String userPhoneNumber) { // 휴대폰 문자보내기
		int randomNumber = (int)((Math.random()* (9999 - 1000 + 1)) + 1000);//난수 생성

		aService.certifiedPhoneNumber(userPhoneNumber,randomNumber);
		
		return Integer.toString(randomNumber);
	}
	
	//예약하기
	@RequestMapping(value = "/reservation/add", method = RequestMethod.POST)
	public ModelAndView addReservation(
			ModelAndView mv,
			@ModelAttribute Reservation reservation
			,HttpSession session) {		
		int result = aService.addReservation(reservation);
		return mv;	
	}
}
