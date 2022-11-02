package com.jeju.jjim.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jeju.jjim.domain.Jjim;
import com.jeju.jjim.service.JjimService;
import com.jeju.member.domain.Member;
import com.jeju.notice.domain.Notice;
import com.jeju.pension.domain.Pension;

@Controller
public class JjimController {
	
	@Autowired
	private JjimService jService;
	
			
	// 찜 여부 확인, 등록, 삭제, PENSION_TBL의 JJIM_COUNT 업데이트
	@GetMapping("/jjim/jjim")
	public ModelAndView JjimManagement(
			ModelAndView mv
			,@RequestParam("pensionNo") Integer pensionNo
			,@ModelAttribute Jjim jjim) {
		int jjimCheck = jService.jjimCount(jjim);
		if(jjimCheck == 0) {
			jService.registerJjim(jjim);
			jService.modifyJjimCount(pensionNo);
		}else if(jjimCheck == 1) {
			jService.removeJjim(jjim);
			jService.removeJjimCount(pensionNo);
		}
		mv.setViewName("redirect:/pension/detailView?pensionNo="+pensionNo);
		return mv;
	}
	// 마이페이지 찜 내역 조회
	@GetMapping("/mypage/jjimView")
	public ModelAndView MypageJjim(
			ModelAndView mv
			,HttpSession session
			,@RequestParam(value="page", required=false) Integer page) {
		Member member = (Member)session.getAttribute("loginUser");
		String memberId = member.getMemberId();
		int currentPage = (page != null) ? page : 1;
		int totalCount = jService.getTotalCount(memberId);
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
		List<Pension> pList = jService.printJjimPension(memberId,currentPage,boardLimit);
		mv.addObject("urlVal", "jjimView");
		mv.addObject("currentPage", currentPage);
		mv.addObject("maxPage", maxPage);
		mv.addObject("startNavi", startNavi);
		mv.addObject("endNavi", endNavi);
		mv.addObject("pList", pList);
		mv.setViewName("mypage/jjimView");
		return mv;
	}
}
