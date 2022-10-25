package com.jeju.pension.controller;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jeju.category.domain.Category;
import com.jeju.category.domain.Category2;
import com.jeju.pension.domain.Pension;
import com.jeju.pension.service.PensionService;
import com.jeju.room.domain.Room;
import com.jeju.room.domain.RoomAttach;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

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
	@RequestMapping(value="/pension/checkPensionName", method=RequestMethod.GET)
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
//			List<Pension> rList = new ArrayList<Pension>();
// 			List<Pension> rankList = pService.selectReviewRank();
//			System.out.println(rankList);
//			for(int i=0; i<5; i++) {
//				rList = pService.selectPensionRank(rankList.get(i));
//				rList.add(i, (Pension) rList);
//			}

//			mv.addObject("rList", rList);
		mv.setViewName("pension/list");
		return mv;
	}

	@RequestMapping(value="/pension/category", method=RequestMethod.POST)
	public String categoryFiltering(
			@ModelAttribute Category2 category
			,@ModelAttribute Pension pension
			,@RequestParam("startDate") String startDate
			,@RequestParam("endDate") String endDate
			,Model model) throws java.text.ParseException{
		//가져온 날짜를 가져와서 가격을 변경시키기 위해 일수의 차이를 구하는 코드
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
			System.out.println(cList);
		}
		model.addAttribute("cList", cList);
		return "pension/list2";
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
		System.out.println(diffDays);

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
		mv.addObject("prList", prList);
		mv.setViewName("pension/list");
		return mv;
	}
}
