package com.jeju.pension.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.jeju.category.domain.Category;
import com.jeju.category.domain.Category2;
import com.jeju.pension.domain.Pension;
import com.jeju.pension.service.PensionService;
import com.jeju.room.domain.Room;
import com.jeju.room.domain.RoomAttach;

@Controller
public class PensionController {


	@Autowired
	private PensionService pService;
	
	// 숙소 등록 페이지로 이동
	@RequestMapping(value="/pension/registForm", method=RequestMethod.GET)
	public String registPension() {
		return "pension/registView";
	}
	
	// 숙소 등록
		@RequestMapping(value="/pension/regist", method=RequestMethod.POST)
		public ModelAndView registPension(
				ModelAndView mv
				,@ModelAttribute Pension pension
				,@ModelAttribute Room room
				,@ModelAttribute Category category
				,@ModelAttribute RoomAttach roomAttach
				,@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
				,@RequestParam(value="uploadRoomFile", required=false) MultipartFile uploadRoomFile
				,HttpServletRequest request) {
					try {
						String pensionFileName = uploadFile.getOriginalFilename();
						if(!pensionFileName.equals("")) {
							String root = request.getSession().getServletContext().getRealPath("resources");
							String savePath = root + "\\files/pension";
							SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
							String pensionFileRename
							= sdf.format(new Date(System.currentTimeMillis()))+"."
									+pensionFileName.substring(pensionFileName.lastIndexOf(".")+1);
							File file = new File(savePath);
							if(!file.exists()) {
								file.mkdir();
							}
							uploadFile.transferTo(new File(savePath+"\\"+pensionFileRename));
							String filePath = savePath+"\\"+pensionFileRename;
							pension.setPensionFileName(pensionFileName);
							pension.setPensionFileRename(pensionFileRename);
							pension.setFilePath("/resources/files/pension/"+pensionFileRename);
							}
						}catch (Exception e) {
						}
			try {
				String roomFileName = uploadRoomFile.getOriginalFilename();
				if(!roomFileName.equals("")) {
					String root = request.getSession().getServletContext().getRealPath("resources");
					String savePath = root + "\\files/room";
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
					String roomFileRename
					= sdf.format(new Date(System.currentTimeMillis()))+"."
							+roomFileName.substring(roomFileName.lastIndexOf(".")+1);
					File file = new File(savePath);
					if(!file.exists()) {
						file.mkdir();
					}
					uploadFile.transferTo(new File(savePath+"\\"+roomFileRename));
					String filePath = savePath+"\\"+roomFileRename;
					roomAttach.setRoomFileName(roomFileName);
					roomAttach.setRoomFileRename(roomFileRename);
					roomAttach.setRoomPath("/resources/files/room/"+roomFileRename);
					}
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
			}
			pService.registerPension(pension); 
			int pensionNo = pService.selectePensionNo(pension);
			room.setRefPensionNo(pensionNo);
			pService.registerRoom(room);
			int roomNo = pService.selecteRoomNo(room);
			roomAttach.setRoomNo(roomNo);
			pService.registerRoomAttach(roomAttach);
			category.setRefPensionNumber(pensionNo);
			pService.registerCategory(category);
			mv.setViewName("redirect:/home");
			return mv;
		}
		// 숙소 이름 중복 체크
		@ResponseBody
		@RequestMapping(
				value="/pension/checkPensionName"
				, method=RequestMethod.GET)
		public int checkPensionName(@RequestParam("pensionName") String pensionName) {
			int result = pService.checkPensionName(pensionName);
			return result;
		}
		// 숙소 상세페이지
		@RequestMapping(value="/pension/detailView", method=RequestMethod.GET)
		public ModelAndView pensionDetailView(
				ModelAndView mv
				,@RequestParam("pensionNo") Integer pensionNo) {
			Pension pension = pService.selecteOnePension(pensionNo);
			List<Category> category = pService.selectCategoryCheck(pensionNo);
			System.out.println(category);
//			Category category = pService.selectPensionCategory(pensionNo);
			List<Room> rList = pService.selecteRoom(pensionNo);
//			List<Integer> roomNo = pService.selecteRoomAttachNo(pensionNo);
//			System.out.println(roomNo);
			mv.addObject("rList", rList);
			mv.addObject("pension", pension);
			mv.setViewName("/pension/detailView");
			return mv;
		}

	
//	@RequestMapping(value="/pension/list", method=RequestMethod.GET)
//	public String showList() {
//		return "pension1/list";
//	}
	
	@RequestMapping(value="/pension/list", method=RequestMethod.GET)
	public ModelAndView pensionListView(
			ModelAndView mv		
			) {
		List<Pension> pList = pService.selectAllPension();
			if(!pList.isEmpty()) {
				mv.addObject("pList", pList);	
			}
			
			
				
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
