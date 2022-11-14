package com.jeju.pension.controller;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jeju.category.domain.Category;
import com.jeju.category.domain.Category2;
import com.jeju.member.domain.Member;
import com.jeju.pension.domain.Pension;
import com.jeju.pension.service.PensionService;
import com.jeju.review.domain.Review;
import com.jeju.room.domain.Room;
import com.jeju.room.domain.RoomAttach;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import edu.emory.mathcs.backport.java.util.Collections;

@Controller
public class PensionController {

	@Autowired
	private PensionService pService;
	
	// 마이페이지 숙소 관리 페이지로 이동
	@RequestMapping(value="/mypage/pensionManagement", method=RequestMethod.GET)
	public ModelAndView pensionManagement(
			ModelAndView mv
			,HttpSession session
			,@RequestParam(value="page", required=false) Integer page) {
		Member member = (Member)session.getAttribute("loginUser");
		String memberId = member.getMemberId();
		int currentPage = (page != null) ? page : 1;
		int totalCount = pService.getTotalCount(memberId);
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
		List<Pension> pList = pService.printMyPension(memberId,currentPage,boardLimit);
		mv.addObject("urlVal", "pensionManagement");
		mv.addObject("currentPage", currentPage);
		mv.addObject("maxPage", maxPage);
		mv.addObject("startNavi", startNavi);
		mv.addObject("endNavi", endNavi);
		mv.addObject("pList", pList);
		mv.setViewName("myPagePension/pensionManagementView");
		return mv;
	}
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
			}
			pService.registerPension(pension); 
			int pensionNo = pService.selectePensionNo(pension);
			room.setRefPensionNo(pensionNo);
			pService.registerRoom(room);
//			String price = room.getPrice();
			int roomNo = pService.selecteRoomNo(room);
			room.setRoomNo(roomNo);
			roomAttach.setRoomNo(roomNo);
			pService.registerRoomAttach(roomAttach);
			category.setRefPensionNumber(pensionNo);
			pService.registerCategory(category);
			DecimalFormat decFormat = new DecimalFormat("###,###원");
			String price = room.getPrice();
			String priceFormat = decFormat.format(Integer.parseInt(price));
			room.setPrice(priceFormat);
			pService.modifyPensionPrice(room);
			mv.setViewName("redirect:/mypage/pensionManagement");
			return mv;
		}
	// 숙소 수정 페이지
	@GetMapping("/pension/modifyForm")
	public ModelAndView modifyForm(ModelAndView mv
			,@RequestParam("pensionNo") Integer pensionNo
			) {
		List<Category> category = pService.selectCategoryCheck(pensionNo);
		Pension pension = pService.selecteOnePension(pensionNo);
		List<Room> rList = pService.selecteRoom(pensionNo);
		mv.addObject("category", category);
		mv.addObject("pension", pension);
		mv.addObject("rList", rList);
		mv.setViewName("myPagePension/modifyView");
		return mv;
	}
	// 숙소 수정
	@PostMapping("/pension/modify")
	public ModelAndView modifyPension(
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
			if(uploadFile != null && !pensionFileName.equals("")) {
				String root = request.getSession().getServletContext().getRealPath("resources");
				String savedPath = root + "\\files/pension";
				File file = new File(savedPath + "\\"+pension.getPensionFileRename());
				if(file.exists()) {
					file.delete();
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
				String pensionFileRename = sdf.format(new Date(System.currentTimeMillis()))
						+"." + pensionFileName.substring(pensionFileName.lastIndexOf(".")+1);
				String pensionFilePath = savedPath + "\\" + pensionFileRename;
				uploadFile.transferTo(new File(pensionFilePath));
				pension.setPensionFileName(pensionFileName);
				pension.setPensionFileRename(pensionFileRename);
				pension.setFilePath("/resources/files/pension/"+pensionFileRename);
			}
		}catch (Exception e) {
		}
		try {
			String roomFileName = uploadRoomFile.getOriginalFilename();
			if(uploadRoomFile != null && !roomFileName.equals("")) {
				String root = request.getSession().getServletContext().getRealPath("resources");
				String savedPath = root + "\\files/room";
				File file = new File(savedPath + "\\"+roomAttach.getRoomFileRename());
				if(file.exists()) {
					file.delete();
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
				String roomFileRename = sdf.format(new Date(System.currentTimeMillis()))
						+"." + roomFileName.substring(roomFileName.lastIndexOf(".")+1);
				String roomFilePath = savedPath + "\\" + roomFileRename;
				uploadRoomFile.transferTo(new File(roomFilePath));
				roomAttach.setRoomFileName(roomFileName);
				roomAttach.setRoomFileRename(roomFileRename);
				roomAttach.setRoomPath("/resources/files/room/"+roomFileRename);
			}
			pService.modifyRoom(room);
			DecimalFormat decFormat = new DecimalFormat("###,###원");
			String price = room.getPrice();
			String priceFormat = decFormat.format(Integer.parseInt(price));
			room.setPrice(priceFormat);
			pension.setPensionPrice(priceFormat);
			pService.modifyPension(pension);
			pService.modifyRoomAttach(roomAttach);
			pService.modifyCategory(category);
			mv.setViewName("redirect:/mypage/pensionManagement");
		}catch (Exception e) {
		}
		return mv; 
	}
	// 숙소 삭제
	@GetMapping("/pension/remove")
	public String removePension(@RequestParam("pensionNo") Integer pensionNo) {
		pService.removePension(pensionNo);
		return "redirect:/mypage/pensionManagement";
	}

	// 숙소 이름 중복 체크
	@ResponseBody
	@RequestMapping(value="/pension/checkPensionName", method=RequestMethod.GET)
	public int checkPensionName(@RequestParam("pensionName") String pensionName) {
		int result = pService.checkPensionName(pensionName);
		return result;
	}
	// 숙소 상세페이지
	@RequestMapping(value="/pension/detailView", method=RequestMethod.GET)
	public ModelAndView pensionDetailView(
			ModelAndView mv
			,@RequestParam(value="startDate", required=false) String startDate
			,@RequestParam(value="endDate", required=false) String endDate
			,@RequestParam("pensionNo") Integer pensionNo
			,Model model
			,HttpSession session) throws java.text.ParseException{
		List<Review> reviewList = pService.selectAllReview(pensionNo);
		Pension pension = pService.selecteOnePension(pensionNo);
		List<Category> category = pService.selectCategoryCheck(pensionNo);
		List<Room> rList = pService.selecteRoom(pensionNo);
		List<String> roomAttachList = new ArrayList<String>();
		for(int i = 0; i < rList.size(); i++) {
			Integer roomNo = rList.get(i).getRoomNo();
			List<String> roomAttach = pService.printAttach(roomNo);
			roomAttachList.addAll(roomAttach);
		}
		Date format1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
		Date format2 = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
		long diffSec = (format2.getTime() - format1.getTime()) / 1000; //초 차이
		long diffDays = diffSec / (24*60*60); //일자수 차이
		//가격리스트 가져옴
		for(int i=0; i<rList.size(); i++) {
			if(diffDays == 0) {
				diffDays = 1;
			}
			DecimalFormat decFormat = new DecimalFormat("###,###");
			String result = String.valueOf(Integer.parseInt(rList.get(i).getPrice()) * diffDays);
			String str = decFormat.format(Integer.parseInt(result));
			rList.get(i).setPrice(str);
		}
		int check = 0;
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		mv.addObject("roomAttachList", roomAttachList);
		mv.addObject("rList", rList);
		mv.addObject("pension", pension);
		mv.addObject("category", category);
		mv.addObject("reviewList", reviewList);
		mv.addObject("check", check);
		mv.setViewName("pension/detailView");
		return mv;
	}
	// 숙소 상세페이지 (마이페이지에서 숙소 관리,후기 내역 조회용)
		@RequestMapping(value="/pension/detailView2", method=RequestMethod.GET)
		public ModelAndView pensionDetailView2(
				ModelAndView mv
				,@RequestParam("pensionNo") Integer pensionNo){
			List<Review> reviewList = pService.selectAllReview(pensionNo);
			Pension pension = pService.selecteOnePension(pensionNo);
			List<Category> category = pService.selectCategoryCheck(pensionNo);
			List<Room> rList = pService.selecteRoom(pensionNo);
			List<String> roomAttachList = new ArrayList<String>();
			for(int i = 0; i < rList.size(); i++) {
				Integer roomNo = rList.get(i).getRoomNo();
				List<String> roomAttach = pService.printAttach(roomNo);
				roomAttachList.addAll(roomAttach);
			}
			for(int i=0; i<rList.size(); i++) {
				DecimalFormat decFormat = new DecimalFormat("###,###");
				String str = decFormat.format(Integer.parseInt(rList.get(i).getPrice()));
				rList.get(i).setPrice(str);
			}
			int check = 1;
			mv.addObject("rList", rList);
			mv.addObject("roomAttachList", roomAttachList);
			mv.addObject("pension", pension);
			mv.addObject("category", category);
			mv.addObject("reviewList", reviewList);
			mv.addObject("check", check);
			mv.setViewName("pension/detailView");
			return mv;
		}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public ModelAndView pensionListView(
			ModelAndView mv
			,String startDate
			, String endDate
			, Model model
	) {
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		startDate = sdf2.format(now);
		endDate = sdf2.format(now);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);

		List<Pension> pList = pService.selectAllPension();
		if(!pList.isEmpty()) {
			mv.addObject("pList", pList);
		}

			List<Pension> rList = new ArrayList<Pension>();
			//5순위까지 조회해서 펜션번호 5개 가져옴
 			List<Review> rankList = pService.selectReviewRank();
 			for(int i=0; i<rankList.size(); i++) {
 				rList.add(i, pService.selectPensionRank(rankList.get(i).getPensionNo()));
 			}
		mv.addObject("rList", rList);
		mv.setViewName("pension/list");
		return mv;
	}
	
	@RequestMapping(value="/pension/searchName", method=RequestMethod.GET)
	public ModelAndView searchPensionName(
			ModelAndView mv
			,@RequestParam("pensionName") String pensionName
			,String startDate
			, String endDate
			, Model model) {
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		startDate = sdf2.format(now);
		endDate = sdf2.format(now);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		List<Pension> pList = pService.searchPensionTitle(pensionName);
		List<Pension> rList = new ArrayList<Pension>();
		
		//5순위까지 조회해서 펜션번호 5개 가져옴
			List<Review> rankList = pService.selectReviewRank();
			for(int i=0; i<rankList.size(); i++) {
				rList.add(i, pService.selectPensionRank(rankList.get(i).getPensionNo()));
			}
		mv.addObject("rList", rList);	
		mv.addObject("pList", pList);
		mv.setViewName("pension/list");
		return mv;	
	}


	//날짜조회 후 ajax로 카테고리 적용한것도 고려하여 코드 작성
	@RequestMapping(value="/pension/category", method=RequestMethod.POST)
	public ModelAndView categoryFiltering(
			@ModelAttribute Category2 category
			,@ModelAttribute Pension pension
			,@RequestParam("startDate") String startDate
			,@RequestParam("endDate") String endDate
			,@RequestParam("price1") String price1
			,@RequestParam("price2") String price2
			,Model model
			,ModelAndView mv) throws java.text.ParseException{
		System.out.println("price1 : " + price1);
		System.out.println("price2 : " + price2);
		//가져온 날짜를 가져와서 가격을 변경시키기 위해 일수의 차이를 구하는 코드
		Date format1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
		Date format2 = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
		long diffSec = (format2.getTime() - format1.getTime()) / 1000; //초 차이
		long diffDays = diffSec / (24*60*60); //일자수 차이
		DecimalFormat decFormat = new DecimalFormat("###,###");		
		ArrayList<Pension> cList = new ArrayList<>();
		List<Category2> gList = pService.selectCategory(category);
		
		for(int i=0; i < gList.size(); i++) {
			//숙소리스트를 가져와 pension에 저장후 cList에 add하는 작업
			pension = pService.selectCategoryFilter(gList.get(i).getRefPensionNumber());
			System.out.println("펜션 가격 : " + pension.getPensionPrice());
			if(pension.getPensionPrice().equals("판매 완료") || pension.getPensionPrice().equals("다른날짜 확인")) {
				cList.add(i, pension);
			}else {				
				System.out.println("if문 안의 펜션 가격 : " + pension.getPensionPrice());
				String price = pension.getPensionPrice().replaceAll("[^0-9]","");
				if(diffDays == 0) {
					diffDays = 1;
				}
				long priceNum1 = Integer.parseInt(price) * diffDays;
				System.out.println("priceNum1 : " + priceNum1);
				if(priceNum1 >= (Integer.parseInt(price1)*10000) && priceNum1 <= (Integer.parseInt(price2)*10000)) {
					String str = decFormat.format(priceNum1);
					System.out.println(str);
					pension.setPensionPrice(str);
					cList.add(i, pension);		
					System.out.println(cList.get(i).getPensionPrice());
				}else {
					cList.add(i, null);
				}
			}
			System.out.println(cList.size());
		}
		List<Pension> rList = new ArrayList<Pension>();
		//5순위까지 조회해서 펜션번호 5개 가져옴
			List<Review> rankList = pService.selectReviewRank();
			for(int i=0; i<rankList.size(); i++) {
				rList.add(i, pService.selectPensionRank(rankList.get(i).getPensionNo()));
			}
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("cList", cList);
		mv.addObject("rList", rList);
		mv.setViewName("pension/list2");
		return mv;
	}
	
	//날짜조회 후 ajax로 카테고리 적용한것도 고려하여 코드 작성
		@RequestMapping(value="/pension/priceSet", method=RequestMethod.POST)
		public ModelAndView priceSet(
				@ModelAttribute Pension pension
				,@RequestParam("startDate") String startDate
				,@RequestParam("endDate") String endDate
				,@RequestParam("price1") String price1
				,@RequestParam("price2") String price2
				,Model model
				,ModelAndView mv) throws java.text.ParseException{
			System.out.println("price1 : " + price1);
			System.out.println("price2 : " + price2);
			//가져온 날짜를 가져와서 가격을 변경시키기 위해 일수의 차이를 구하는 코드
			Date format1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
			Date format2 = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
			long diffSec = (format2.getTime() - format1.getTime()) / 1000; //초 차이
			long diffDays = diffSec / (24*60*60); //일자수 차이
			DecimalFormat decFormat = new DecimalFormat("###,###");		
			ArrayList<Pension> fList = new ArrayList<>();
			List<Pension> gList = pService.priceSet();
			System.out.println(gList);
			for(int i=0; i < gList.size(); i++) {
				//숙소리스트를 가져와 pension에 저장후 cList에 add하는 작업
				if(gList.get(i).getPensionPrice().equals("판매 완료") || gList.get(i).getPensionPrice().equals("다른날짜 확인")) {
					fList.add(i, pension);
					System.out.println(fList.get(i));
				}else {				
					String price = gList.get(i).getPensionPrice().replaceAll("[^0-9]","");
					if(diffDays == 0) {
						diffDays = 1;
					}
					long priceNum1 = Integer.parseInt(price) * diffDays;
					System.out.println("priceNum1 : " + priceNum1);
					if(priceNum1 >= (Integer.parseInt(price1)*10000) && priceNum1 <= (Integer.parseInt(price2)*10000)) {
						String str = decFormat.format(priceNum1);
						System.out.println(str);
						gList.get(i).setPensionPrice(str);
						fList.add(i, gList.get(i));		
					}else {
						fList.add(i, null);
						System.out.println("null값 체크 : "+ fList.get(i));
					}
				}
				System.out.println(fList.size());
			}
			
			List<Pension> rList = new ArrayList<Pension>();
			//5순위까지 조회해서 펜션번호 5개 가져옴
				List<Review> rankList = pService.selectReviewRank();
				for(int i=0; i<rankList.size(); i++) {
					rList.add(i, pService.selectPensionRank(rankList.get(i).getPensionNo()));
				}
			model.addAttribute("startDate", startDate);
			model.addAttribute("endDate", endDate);
			model.addAttribute("fList", fList);
			mv.addObject("rList", rList);
			mv.setViewName("pension/list2");
			return mv;
		}

	@RequestMapping(value="/pension/dateSearch", method=RequestMethod.POST)
	public ModelAndView dateSearch(
			ModelAndView mv
			,@RequestParam("startDate") String startDate
			,@RequestParam("endDate") String endDate
			,Model model) throws ParseException, Exception {
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		Date format1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
		Date format2 = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
		long diffSec = (format2.getTime() - format1.getTime()) / 1000; //초 차이
		long diffDays = diffSec / (24*60*60); //일자수 차이
		ArrayList<Pension> prList = new ArrayList<Pension>();
		//가격리스트 가져옴
		List<Pension> priceList = pService.selectPrice();
		for(int i=0; i<priceList.size(); i++) {
			if(priceList.get(i).getPensionPrice() == null) {
				priceList.get(i).setPensionPrice("판매완료");
				prList.add(i, priceList.get(i));
			}else {
				DecimalFormat decFormat = new DecimalFormat("###,###");
				String result = String.valueOf(Integer.parseInt(priceList.get(i).getPensionPrice()) * diffDays);
				String str = decFormat.format(Integer.parseInt(result));
				priceList.get(i).setPensionPrice(str);
				prList.add(i, priceList.get(i));
			}
		}

		List<Pension> rList = new ArrayList<Pension>();
		//5순위까지 조회해서 펜션번호 5개 가져옴
			List<Review> rankList = pService.selectReviewRank();
			for(int i=0; i<rankList.size(); i++) {
				rList.add(i, pService.selectPensionRank(rankList.get(i).getPensionNo()));
			}
		mv.addObject("rList", rList);	//일반 펜션목록 출력용
		mv.addObject("prList", prList);	//날짜 조회용
		mv.setViewName("pension/list");
		return mv;
	}

	@ResponseBody
	@RequestMapping(value="/pension/dateSearchSort", method=RequestMethod.POST)
	public ModelAndView dateSearchSort(
			ModelAndView mv
			,@RequestParam("startDate") String startDate
			,@RequestParam("endDate") String endDate
			,Model model) throws ParseException, Exception {
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		Date format1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
		Date format2 = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
		long diffSec = (format2.getTime() - format1.getTime()) / 1000; //초 차이
		long diffDays = diffSec / (24*60*60); //일자수 차이
		ArrayList<Pension> prList = new ArrayList<Pension>();
		//가격리스트 가져옴
		List<Pension> priceList = pService.selectPrice();
		for(int i=0; i<priceList.size(); i++) {
			if(priceList.get(i).getPensionPrice() == null) {
				priceList.get(i).setPensionPrice("판매완료");
				prList.add(i, priceList.get(i));
			}else {
				DecimalFormat decFormat = new DecimalFormat("###,###");
				String result = String.valueOf(Integer.parseInt(priceList.get(i).getPensionPrice()) * diffDays);
				String str = decFormat.format(Integer.parseInt(result));
				priceList.get(i).setPensionPrice(str);
				prList.add(i, priceList.get(i));
			}
		}
		System.out.println(prList);
		Collections.sort(prList, Collections.reverseOrder());
		List<Pension> rList = new ArrayList<Pension>();
		//5순위까지 조회해서 펜션번호 5개 가져옴
			List<Review> rankList = pService.selectReviewRank();
			for(int i=0; i<rankList.size(); i++) {
				rList.add(i, pService.selectPensionRank(rankList.get(i).getPensionNo()));
			}
		mv.addObject("rList", rList);	//일반 펜션목록 출력용
		mv.addObject("drList", prList);	//날짜 조회용
		mv.setViewName("pension/list2");
		return mv;
	}

//카테고리 필터링만 적용시키고 인기순 정렬했을때 코
	@ResponseBody
	@RequestMapping(value="/pension/popular", method=RequestMethod.GET)
	public ModelAndView searchPopular(
			@ModelAttribute Category2 category
			,@ModelAttribute Pension pension
			,@RequestParam("startDate") String startDate
			,@RequestParam("endDate") String endDate
			,Model model
			,ModelAndView mv) throws java.text.ParseException {
		Date format1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
		Date format2 = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
		long diffSec = (format2.getTime() - format1.getTime()) / 1000; //초 차이
		long diffDays = diffSec / (24*60*60); //일자수 차이

		ArrayList<Pension> cList = new ArrayList<>();
		List<Category2> gList = pService.selectCategory(category);
		for(int i=0; i < gList.size(); i++) {
			//숙소리스트를 가져와 pension에 저장후 cList에 add하는 작업
			pension = pService.selectCategoryFilter(gList.get(i).getRefPensionNumber());
			System.out.println("펜션 가격 : " + pension.getPensionPrice());
			if(pension.getPensionPrice().equals("판매 완료") || pension.getPensionPrice().equals("다른날짜 확인")) {
				cList.add(i, pension);
			}else {
				DecimalFormat decFormat = new DecimalFormat("###,###");
				System.out.println("if문 안의 펜션 가격 : " + pension.getPensionPrice());
				//숫자만 남기고 다제거
				String price = pension.getPensionPrice().replaceAll("[^0-9]","");
				if(diffDays == 0) {
					diffDays = 1;
				}
				String result = String.valueOf(Integer.parseInt(price) * diffDays);
				String str = decFormat.format(Integer.parseInt(result));
				System.out.println(str);
				pension.setPensionPrice(str);
				cList.add(i, pension);
			}
		}
		Collections.sort(cList, Collections.reverseOrder());
		List<Pension> rList = new ArrayList<Pension>();
		//5순위까지 조회해서 펜션번호 5개 가져옴
			List<Review> rankList = pService.selectReviewRank();
			for(int i=0; i<rankList.size(); i++) {
				rList.add(i, pService.selectPensionRank(rankList.get(i).getPensionNo()));
			}
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("cList", cList);
		mv.addObject("rList", rList);
		mv.setViewName("pension/list2");
		return mv;
	}

	//날짜선택 후 낮은가격순 정렬
	@ResponseBody
	@RequestMapping(value="/pension/datePriceSort", method=RequestMethod.POST)
	public ModelAndView datePriceSort(
			ModelAndView mv
			,@RequestParam("startDate") String startDate
			,@RequestParam("endDate") String endDate
			,Model model) throws ParseException, Exception {
		System.out.println("들어왔어!");
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		Date format1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
		Date format2 = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
		long diffSec = (format2.getTime() - format1.getTime()) / 1000; //초 차이
		long diffDays = diffSec / (24*60*60); //일자수 차이
		System.out.println(diffDays);
		if(diffDays == 0) {
			diffDays = 1;
		}
		//최종 view로 보낼 새로운 리스트 생성
		ArrayList<Pension> prList = new ArrayList<Pension>();
		//오름차순 정렬된 가격리스트 가져옴
		List<Pension> priceList = pService.ascPriceSort();

		for(int i=0; i<priceList.size(); i++) {
			if(priceList.get(i).getPensionPrice() == null) {
				priceList.get(i).setPensionPrice("판매완료");
				prList.add(i, priceList.get(i));
			}else {
				DecimalFormat decFormat = new DecimalFormat("###,###");
				String result = String.valueOf(Integer.parseInt(priceList.get(i).getPensionPrice()) * diffDays);
				String str = decFormat.format(Integer.parseInt(result));
				priceList.get(i).setPensionPrice(str);
				prList.add(i, priceList.get(i));
			}
		}
//		Collections.sort(prList, Collections.reverseOrder());
		List<Pension> rList = new ArrayList<Pension>();
		//5순위까지 조회해서 펜션번호 5개 가져옴
			List<Review> rankList = pService.selectReviewRank();
			for(int i=0; i<rankList.size(); i++) {
				rList.add(i, pService.selectPensionRank(rankList.get(i).getPensionNo()));
			}
		mv.addObject("rList", rList);	//일반 펜션목록 출력용
		mv.addObject("drList", prList);	//날짜 조회용
		mv.setViewName("pension/list2");
		return mv;
	}

	//카테고리 필터링시 오름차순 정렬
	@ResponseBody
	@RequestMapping(value="/pension/categoryPriceSort", method=RequestMethod.POST)
	public ModelAndView categoryPriceSort(
			@ModelAttribute Category2 category
			,@ModelAttribute Pension pension
			,@RequestParam("startDate") String startDate
			,@RequestParam("endDate") String endDate
			,Model model
			,ModelAndView mv) throws java.text.ParseException {
		Date format1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
		Date format2 = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
		long diffSec = (format2.getTime() - format1.getTime()) / 1000; //초 차이
		long diffDays = diffSec / (24*60*60); //일자수 차이

		ArrayList<Pension> cList = new ArrayList<>();
		//우선 카테고리대로 넘버값을 가져옴
		List<Category2> gList = pService.selectCategory(category);

		int iNumber = 0;
		for(int i=0; i < gList.size(); i++) {
			pension = pService.selectCategoryFilter(gList.get(i).getRefPensionNumber());
			if(pension.getPensionPrice().equals("판매 완료") || pension.getPensionPrice().equals("다른날짜 확인")) {
				continue;
			}else {
				DecimalFormat decFormat = new DecimalFormat("###,###");
				//현재 i번째 숫자
				String price = pension.getPensionPrice().replaceAll("[^0-9]","");
				if(diffDays == 0) {
					diffDays = 1;
				}
				String result = String.valueOf(Integer.parseInt(price) * diffDays);
				String str = decFormat.format(Integer.parseInt(result));
				pension.setPensionPrice(str);
				cList.add(iNumber, pension);
				iNumber++;
			}
		}

		int pListNum = 0;
		Pension tmp = new Pension();
		for(int j=0; j<cList.size(); j++) {
			for(int k= j+1; k<cList.size(); k++) {
				if(Integer.parseInt(cList.get(j).getPensionPrice().replaceAll("[^0-9]","")) > Integer.parseInt(cList.get(k).getPensionPrice().replaceAll("[^0-9]",""))) {
					tmp = cList.get(j);
					cList.set(j, cList.get(k));
					cList.set(k, tmp);
				}
			}
		}

		List<Pension> rList = new ArrayList<Pension>();
		//5순위까지 조회해서 펜션번호 5개 가져옴
			List<Review> rankList = pService.selectReviewRank();
			for(int i=0; i<rankList.size(); i++) {
				rList.add(i, pService.selectPensionRank(rankList.get(i).getPensionNo()));
			}
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("cList", cList);
		mv.addObject("rList", rList);
		mv.setViewName("pension/list2");
		return mv;
	}

	//날짜선택 후 내림차순 가격 정렬
		@ResponseBody
		@RequestMapping(value="/pension/dateDescPriceSort", method=RequestMethod.POST)
		public ModelAndView dateDescPriceSort(
				ModelAndView mv
				,@RequestParam("startDate") String startDate
				,@RequestParam("endDate") String endDate
				,Model model) throws ParseException, Exception {
			model.addAttribute("startDate", startDate);
			model.addAttribute("endDate", endDate);
			Date format1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
			Date format2 = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
			long diffSec = (format2.getTime() - format1.getTime()) / 1000; //초 차이
			long diffDays = diffSec / (24*60*60); //일자수 차이
			System.out.println(diffDays);
			if(diffDays == 0) {
				diffDays = 1;
			}
			//최종 view로 보낼 새로운 리스트 생성
			ArrayList<Pension> prList = new ArrayList<Pension>();
			//내림차순 정렬된 가격리스트 가져옴
			List<Pension> priceList = pService.DescPriceSort();

			for(int i=0; i<priceList.size(); i++) {
				if(priceList.get(i).getPensionPrice() == null) {
					priceList.get(i).setPensionPrice("판매완료");
					prList.add(i, priceList.get(i));
				}else {
					DecimalFormat decFormat = new DecimalFormat("###,###");
					String result = String.valueOf(Integer.parseInt(priceList.get(i).getPensionPrice()) * diffDays);
					String str = decFormat.format(Integer.parseInt(result));
					priceList.get(i).setPensionPrice(str);
					prList.add(i, priceList.get(i));
				}
			}
//			Collections.sort(prList, Collections.reverseOrder());
			List<Pension> rList = new ArrayList<Pension>();
			//5순위까지 조회해서 펜션번호 5개 가져옴
				List<Review> rankList = pService.selectReviewRank();
				for(int i=0; i<rankList.size(); i++) {
					rList. add(i, pService.selectPensionRank(rankList.get(i).getPensionNo()));
				}
			mv.addObject("rList", rList);	//일반 펜션목록 출력용
			mv.addObject("drList", prList);	//날짜 조회용
			mv.setViewName("pension/list2");
			return mv;
		}


		//카테고리 필터링시 오름차순 정렬
		@ResponseBody
		@RequestMapping(value="/pension/categoryDescPriceSort", method=RequestMethod.POST)
		public ModelAndView categoryDescPriceSort(
				@ModelAttribute Category2 category
				,@ModelAttribute Pension pension
				,@RequestParam("startDate") String startDate
				,@RequestParam("endDate") String endDate
				,Model model
				,ModelAndView mv) throws java.text.ParseException {
			Date format1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
			Date format2 = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
			long diffSec = (format2.getTime() - format1.getTime()) / 1000; //초 차이
			long diffDays = diffSec / (24*60*60); //일자수 차이

			ArrayList<Pension> cList = new ArrayList<>();
			//우선 카테고리대로 넘버값을 가져옴
			List<Category2> gList = pService.selectCategory(category);

			int iNumber = 0;
			for(int i=0; i < gList.size(); i++) {
				pension = pService.selectCategoryFilter(gList.get(i).getRefPensionNumber());
				if(pension.getPensionPrice().equals("판매 완료") || pension.getPensionPrice().equals("다른날짜 확인")) {
					continue;
				}else {
					DecimalFormat decFormat = new DecimalFormat("###,###");
					//현재 i번째 숫자
					String price = pension.getPensionPrice().replaceAll("[^0-9]","");
					if(diffDays == 0) {
						diffDays = 1;
					}
					String result = String.valueOf(Integer.parseInt(price) * diffDays);
					String str = decFormat.format(Integer.parseInt(result));
					pension.setPensionPrice(str);
					cList.add(iNumber, pension);
					iNumber++;
				}
			}


			int pListNum = 0;
			Pension tmp = new Pension();
			for(int j=0; j<cList.size(); j++) {
				for(int k= j+1; k<cList.size(); k++) {
					if(Integer.parseInt(cList.get(j).getPensionPrice().replaceAll("[^0-9]","")) < Integer.parseInt(cList.get(k).getPensionPrice().replaceAll("[^0-9]",""))) {
						tmp = cList.get(j);
						cList.set(j, cList.get(k));
						cList.set(k, tmp);
					}
				}
			}

			List<Pension> rList = new ArrayList<Pension>();
			//5순위까지 조회해서 펜션번호 5개 가져옴
				List<Review> rankList = pService.selectReviewRank();
				for(int i=0; i<rankList.size(); i++) {
					rList.add(i, pService.selectPensionRank(rankList.get(i).getPensionNo()));
				}
			model.addAttribute("startDate", startDate);
			model.addAttribute("endDate", endDate);
			model.addAttribute("cList", cList);
			mv.addObject("rList", rList);
			mv.setViewName("pension/list2");
			return mv;
		}
}
