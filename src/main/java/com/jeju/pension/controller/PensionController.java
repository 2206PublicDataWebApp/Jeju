package com.jeju.pension.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jeju.category.domain.Category;
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
		System.out.println(room);
		pService.registerPension(pension); 
		int pensionNo = pService.selectePensionNo(pension);
		room.setPensionNo(pensionNo);
		pService.registerRoom(room);
		int roomNo = pService.selecteRoomNo(room);
		roomAttach.setRoomNo(roomNo);
		pService.registerRoomAttach(roomAttach);
		category.setPensionNo(pensionNo);
		pService.registerCategory(category);
		mv.setViewName("redirect:/home");
		return mv;
	}
	
	public ModelAndView pensionDetailView(ModelAndView mv) {
		
		return mv;
	}
}
