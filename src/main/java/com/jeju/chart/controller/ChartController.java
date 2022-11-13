package com.jeju.chart.controller;

import com.jeju.member.controller.AdminMemberController;
import com.jeju.member.domain.Member;
import com.jeju.member.service.MemberService;
import org.apache.maven.model.Model;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ChartController {

    private static final Logger logger = LoggerFactory.getLogger(ChartController.class);

    @Autowired
    private MemberService memberService;


    @GetMapping("/chart")
        public ModelAndView showAdminChart(ModelAndView modelAndView){
        logger.info("관리자페이지 차트 접속시도");

        // 신규가입현황 차트 조회
        List<Member> result  = memberService.selectNewRegisterChart();
        JSONArray cJsonArr = new JSONArray();
        JSONObject cJsonObj = new JSONObject();
        for(Member member : result ) {
            cJsonObj.put("y", member.getCount());
            cJsonObj.put("d", member.getEnrollDate());
            cJsonArr.add(cJsonObj);
        }
        modelAndView.addObject("chartJSON", cJsonArr);
        //

        modelAndView.setViewName("/admin/adminChart");
        return modelAndView;
        }
}
