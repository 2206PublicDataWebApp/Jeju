package com.jeju.coupon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jeju.coupon.service.CouponService;

@Controller
public class CouponController {
	@Autowired
	private CouponService cService;
	
	
	@RequestMapping(value="/coupon/couponList", method=RequestMethod.GET)
	public String showCouponView() {		
		return "coupon/couponView";
	}
	
	@RequestMapping(value="/coupon/couponEventList", method=RequestMethod.GET)
	public String showCouponEventView() {		
		return "coupon/couponEventView";
	}
}
