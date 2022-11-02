package com.jeju.coupon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jeju.coupon.domain.Coupon;
import com.jeju.coupon.service.CouponService;

@Controller
public class CouponController {
	@Autowired
	private CouponService cService;
	
	
	@GetMapping("/coupon/couponList")
	public String showCouponView() {		
		return "coupon/couponView";
	}
	
	//이벤트 진행중인 쿠폰 전체 조회
	@GetMapping("/coupon/couponEventList")
	public ModelAndView showCouponEventView(
			ModelAndView mv) {
		List<Coupon> cList = cService.selectAllCoupon();
		System.out.println(cList);
		if(!cList.isEmpty()) {
			mv.addObject("cList", cList);
		}
		mv.setViewName("/coupon/couponEventView");		
		return mv;
	}
	
	@RequestMapping(value="/coupon/downCoupon", method=RequestMethod.POST)
	public String downloadCoupon() {
		
		return null;		
	}
}
