package com.jeju.pension.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.jeju.category.domain.Category2;
import com.jeju.pension.domain.Pension;
import com.jeju.pension.service.PensionService;
import com.jeju.review.domain.Review;

@Controller
public class PensionController {
	@Autowired
	private PensionService pService;
	
//	@RequestMapping(value="/pension/list", method=RequestMethod.GET)
//	public String showList() {
//		return "pension1/list";
//	}
	
	@RequestMapping(value="/pension/list", method=RequestMethod.GET)
	public ModelAndView pensionListView(
			ModelAndView mv		
			) {
		//펜션테이블의 모든 정보 가져오는 작업
		List<Pension> pList = pService.selectAllPension();
			if(!pList.isEmpty()) {
				mv.addObject("pList", pList);	
			}
			
			
				
//인기순위 구현 보류	
//			List<Pension> rList = new ArrayList<Pension>();
// 			List<Pension> rankList = pService.selectReviewRank();
//			System.out.println(rankList);
//			for(int i=0; i<5; i++) {
//				rList = pService.selectPensionRank(rankList.get(i));
//				rList.add(i, (Pension) rList);
//			}		
//			mv.addObject("rList", rList);
			mv.setViewName("pension1/list");
			return mv;
	}	
	
	
	
	
	
	@ResponseBody
	@RequestMapping(value="/pension/category", produces="application/json;charset=utf-8", method=RequestMethod.POST)
	public String categoryFiltering(
			@ModelAttribute Category2 category
			,@ModelAttribute Pension pension) {
		ArrayList<Pension> cList = new ArrayList<>();
		List<Category2> gList = pService.selectCategory(category);
		for(int i=0; i < gList.size(); i++) {
			pension = pService.selectCategoryFilter(gList.get(i).getPensionNo());
			cList.add(i, pension);			
		}
		Gson gson = new Gson();
		return gson.toJson(cList);
		
	}
				
		
		
		
	
	
}
