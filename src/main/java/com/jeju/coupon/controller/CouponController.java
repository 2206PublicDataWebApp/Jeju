package com.jeju.coupon.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jeju.coupon.domain.Coupon;
import com.jeju.coupon.domain.MyCoupon;
import com.jeju.coupon.service.CouponService;
import com.jeju.member.domain.Member;

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
		if(!cList.isEmpty()) {
			mv.addObject("cList", cList);
		}
		mv.setViewName("/coupon/couponEventView");		
		return mv;
	}
	
	@ResponseBody
	@PostMapping(value="/coupon/downCoupon", produces="text/plain;charset=utf-8")
	public String downloadCoupon(
			@RequestParam("couponCode") String couponCode
			,HttpSession session) {
		String chk = "";
		MyCoupon myCoupon = new MyCoupon();
		Coupon coupon = cService.selectOneByCoupon(couponCode);
		if(coupon.getCount() == 0) {
			chk = "쿠폰받기 실패!";
		}else {
			Member member = (Member)session.getAttribute("loginUser");
			String memberId = member.getMemberId();
			MyCoupon couponConfirm = new MyCoupon(memberId, couponCode);
			int count = cService.confirmCoupon(couponConfirm);
			if(count > 0) {
				chk = "이미 쿠폰을 받으셨습니다.";
			}else {
				myCoupon.setMemberId(memberId);
				myCoupon.setCouponCode(couponCode);
				myCoupon.setSalePrice(coupon.getSalePrice());
				myCoupon.setcStatus(coupon.getcStatus());
				myCoupon.setCouponStartDate(coupon.getCouponStartDate());
				myCoupon.setCouponEndDate(coupon.getCouponEndDate());
				int result = cService.addMyCoupon(myCoupon);
				if(result > 0) {
					int decrease = cService.decreaseCount(couponCode);
					int increase = cService.increaseCount(memberId);
					chk = "쿠폰받기 성공!";
				}else {
					chk = "쿠폰받기 실패!";
				}
			}
			
		}		
		return chk;		
	}
	
	@ResponseBody
	@RequestMapping(value="/coupon/decreaseCoupon", produces="text/plain;charset=utf-8", method=RequestMethod.POST)
	public String decreaseCoupon(
			@RequestParam("couponCode") String couponCode
			,HttpSession session) {
		String chk = "";
		Member member = (Member) session.getAttribute("loginUser");
		String memberId = member.getMemberId();
		MyCoupon mycoupon = new MyCoupon(memberId, couponCode);
//		int result = cService.deleteMyCoupon(couponCode);
//		int result2 = cService.decreaseMemberCoupon(memberId);
		int result = cService.updateUseCount(mycoupon);
		if(result > 0) {
			System.out.println("감소 성공");
			chk = "성공";
		}else {
			chk = "실패";
		}
		return chk;
	}
	
	
}
