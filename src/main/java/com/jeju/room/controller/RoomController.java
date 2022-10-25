package com.jeju.room.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jeju.room.service.RoomService;

@Controller
public class RoomController {
	@Autowired
	private RoomService rService;
	
	
}
