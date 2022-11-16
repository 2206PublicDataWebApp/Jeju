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
	public ModelAndView showCouponView(
			ModelAndView mv
			,HttpSession session) {	
		Member member = (Member) session.getAttribute("loginUser");
		String memberId = member.getMemberId();
		List<MyCoupon> mList = cService.selectMyCouponList(memberId);
		mv.addObject("mList", mList);
		mv.setViewName("/coupon/myCouponView");
		return mv;
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
				myCoupon.setCouponImage(coupon.getCouponImage());
				myCoupon.setCouponTitle(coupon.getCouponTitle());
				myCoupon.setCouponComments(coupon.getCouponComments());
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
			int result = cService.updateUseCount(mycoupon);
			if(result > 0) {
				chk = "성공";
			}else {
				chk = "실패";
			}	
		return chk;
	}
	
	@ResponseBody
	@RequestMapping(value="/coupon/couponCancel", produces="text/plain;charset=utf-8", method=RequestMethod.GET)
	public String couponCancel(
			HttpSession session
			,@RequestParam("couponCode") String couponCode) {
		String chk = "";
		Member member = (Member) session.getAttribute("loginUser");
		String memberId = member.getMemberId();
		MyCoupon myCoupon = new MyCoupon(memberId, couponCode);
		int result = cService.increaseUseCount(myCoupon);
		if(result > 0) {
			chk = "성공";
		}
		return chk;
	}
	
	@ResponseBody
	@RequestMapping(value="/coupon/updateStatus", produces="text/plain;charset=utf-8", method=RequestMethod.POST)
	public String countCheck(
			HttpSession session
			,@RequestParam("couponCode") String couponCode) {
		Member member = (Member) session.getAttribute("loginUser");
		String chk = "";
		if(member != null) {			
			String memberId = member.getMemberId();
			MyCoupon myCoupon = new MyCoupon(memberId, couponCode);
			int result = cService.updateStatus(myCoupon);
			if(result > 0) {
				chk = "성공";
			}else {
				chk = "실패";
			}			
		}else {
			chk = "실패";
		}
		return chk;
	}
	
	@ResponseBody
	@RequestMapping(value="/coupon/updateCouponStatus", produces="text/plain;charset=utf-8", method=RequestMethod.POST)
	public String couponStatusUpdate(
			HttpSession session
			,@RequestParam("couponCode") String couponCode) {
		Member member = (Member) session.getAttribute("loginUser");
		String chk = "";
		if(member != null) {			
			String memberId = member.getMemberId();
			MyCoupon myCoupon = new MyCoupon(memberId, couponCode);
			int result = cService.updateCouponStatus(myCoupon);
			if(result > 0) {
				chk = "성공";
			}else {
				chk = "실패";
			}			
		}else {
			chk = "실패";
		}
		return chk;
	}

	
}
