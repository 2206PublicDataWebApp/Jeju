package com.jeju.admin.controller;

import com.jeju.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // 관리자페이지 화면조회
    @GetMapping(value="/adminPage")
    public String showAdminPage(){
        return "admin/adminPage";
    }

    // 관리자페이지 회원목록 조회
    public void showAdminMember(){

    }


}
