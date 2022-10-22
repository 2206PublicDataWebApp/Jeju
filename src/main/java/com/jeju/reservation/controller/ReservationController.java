package com.jeju.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jeju.reservation.service.ReservationService;

@Controller
public class ReservationController {
	@Autowired
	private ReservationService aService;

	@RequestMapping(value="/reservation/list", method=RequestMethod.GET)
	public String showList() {
		return "reservation/list";
	}
	

}
