package com.jeju.notice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jeju.notice.domain.Notice;
import com.jeju.notice.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService nService;
	
	// 공지사항 
	@RequestMapping(value="/notice/list", method=RequestMethod.GET)
	public ModelAndView noticeListView(
			ModelAndView mv
			, @RequestParam(value="page", required=false) Integer page) {
		int currentPage = (page != null) ? page : 1;
		int totalCount = nService.getTotalCount();
		int boardLimit = 5;
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
		List<Notice> nList = nService.printAllNotice(currentPage,boardLimit);
		mv.addObject("urlVal", "list");
		mv.addObject("currentPage", currentPage);
		mv.addObject("maxPage", maxPage);
		mv.addObject("startNavi", startNavi);
		mv.addObject("endNavi", endNavi);
		mv.addObject("nList", nList);
		mv.setViewName("notice/listView");
		return mv;
	}
	// 공지사항 상세 페이지로 이동
	@RequestMapping(value="/notice/detail", method=RequestMethod.GET)
	public ModelAndView noticeDetailView(
			ModelAndView mv
			, @RequestParam("noticeNo") Integer noticeNo
			, @RequestParam("page") int page) {
		Notice notice = nService.selectOneNo(noticeNo);
		mv.addObject("page", page);
		mv.addObject("notice", notice);
		mv.setViewName("notice/detailView");
		return mv;
	}
	// 공지사항 등록 페이지로 이동
	@RequestMapping(value="/notice/writeForm", method=RequestMethod.GET)
	public String noticeWirteForm() {
		return "notice/writeView";
	}
	// 공지사항 등록
	@RequestMapping(value="/notice/regist", method=RequestMethod.POST)
	public ModelAndView noticeRegist(
			ModelAndView mv
			,@ModelAttribute Notice notice) {
		nService.registerNotice(notice);
		mv.setViewName("redirect:/notice/list");
		return mv;
	}
	// 공지사항 수정 페이지로 이동
	@RequestMapping(value="/notice/modifyForm", method=RequestMethod.GET)
	public ModelAndView noticeModifyForm(
			ModelAndView mv
			, @RequestParam("noticeNo") Integer noticeNo) {
		Notice notice = nService.selectOneNo(noticeNo);
		mv.addObject("notice", notice);
		mv.setViewName("notice/modifyView");
		return mv;
	}
	// 공지사항 수정
	@RequestMapping(value="/notice/modify", method=RequestMethod.POST)
	public ModelAndView noticeModify(
			ModelAndView mv
			,@RequestParam("noticeNo") Integer noticeNo
			,@ModelAttribute Notice notice) {
		int result = nService.modifyNotice(notice);
		mv.setViewName("redirect:/notice/detail?noticeNo="+noticeNo);
		return mv;
	}
	// 공지사항 삭제
	@RequestMapping(value="/notice/remove", method=RequestMethod.GET)
	public ModelAndView noticeRemove(
			ModelAndView mv
			, @RequestParam("page") int page
			, @RequestParam("noticeNo") int noticeNo) {
		nService.removeNotice(noticeNo);
		mv.setViewName("redirect:/notice/list?page="+page);
		return mv;
	}
}