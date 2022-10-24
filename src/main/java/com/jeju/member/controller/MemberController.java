package com.jeju.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jeju.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService mService;
	
	// 마이페이지로 이동
	@RequestMapping(value="/mypage/myPage", method=RequestMethod.GET)
	public String myPageView() {
		return "/mypage/myPageView";
	}
	// 마이페이지 숙소 관리
	@RequestMapping(value="/mypage/pensionManagement", method=RequestMethod.GET)
	public ModelAndView pensionManagement(ModelAndView mv) {
		mv.setViewName("mypage/pensionManagementView");
		return mv;
	}
	// 마이페이지 후기 조회
	@RequestMapping(value="/mypage/review", method=RequestMethod.GET)
	public ModelAndView reivewView(ModelAndView mv) {
		mv.setViewName("mypage/reviewView");
		return mv;
	}
	// 마이페이지 찜 내역 조회
	@RequestMapping(value="/mypage/jjim", method=RequestMethod.GET)
	public ModelAndView jjimView(ModelAndView mv) {
		mv.setViewName("mypage/jjimView");
		return mv;
	}
}
