package com.jeju.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommunityController {

    @GetMapping(value="/community/chat")
    public String showCommunity(){
        return "community/chat";
    }
}
