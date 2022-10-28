package com.jeju.review.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jeju.member.domain.Member;
import com.jeju.pension.domain.Pension;
import com.jeju.review.domain.Review;
import com.jeju.review.service.ReviewService;

@Controller
public class ReviewController {

	@Autowired
	private ReviewService rService;
	
	// 마이페이지 후기 조회
	@GetMapping("/mypage/review")
	public ModelAndView ReivewView(
			ModelAndView mv
			,HttpSession session
			,@RequestParam(value="page", required=false) Integer page) {
//		Member member = (Member)session.getAttribute("loginUser");
//		String memberId = member.getMemberId();
		String memberId = "MEMBERID1";
//		System.out.println(memberId);
		int currentPage = (page != null) ? page : 1;
		int totalCount = rService.getTotalCount(memberId);
		int boardLimit = 6;
		int naviLimit = 5;
		int maxPage;
		int startNavi;
		int endNavi;
		maxPage = (int)((double)totalCount/boardLimit + 0.9);
		startNavi = ((int)((double)currentPage/naviLimit+0.9)-1)*naviLimit+1;
		endNavi = startNavi + naviLimit - 1;
		if(maxPage < endNavi) {
			endNavi = maxPage;
		}
		List<Review> rList = rService.printReviewAll(memberId,currentPage,boardLimit);
		mv.addObject("urlVal", "review");
		mv.addObject("currentPage", currentPage);
		mv.addObject("maxPage", maxPage);
		mv.addObject("startNavi", startNavi);
		mv.addObject("endNavi", endNavi);
		mv.addObject("rList", rList);
		mv.addObject("totalCount", totalCount);
		mv.setViewName("mypage/reviewView");
		return mv;
	}
		
}
