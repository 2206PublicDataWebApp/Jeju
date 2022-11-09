package com.jeju.chart.controller;

import com.jeju.member.controller.AdminMemberController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ChartController {

    private static final Logger logger = LoggerFactory.getLogger(ChartController.class);

    @GetMapping("/chart")
        public String showAdminChart(){
        logger.info("관리자페이지 차트 접속시도");
        return "/admin/adminChart";
        }
}
