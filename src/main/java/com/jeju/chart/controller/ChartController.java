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
        List<Member> newRegisterChart  = memberService.selectNewRegisterChart();
        JSONArray cJsonArrRegister = new JSONArray();
        JSONObject cJsonObjRegister = new JSONObject();
        for(Member member : newRegisterChart ) {
            cJsonObjRegister.put("x", member.getEnrollDate());
            cJsonObjRegister.put("y", member.getCount());
            cJsonArrRegister.add(cJsonObjRegister);
        }
        modelAndView.addObject("chartJSONRegister", cJsonArrRegister);
        //

        // 성비 차트 조회
        List<Member> genderChart = memberService.selectGenderChart();
        JSONArray cJsonArrGender = new JSONArray();
        JSONObject cJsonObjGender = new JSONObject();
        for(Member member : genderChart){
            cJsonObjGender.put("x", member.getGender());
            cJsonObjGender.put("y", member.getGenderCount());
            cJsonArrGender.add(cJsonArrGender);
        }
        modelAndView.addObject("chartJSONGender", cJsonArrGender);






        modelAndView.setViewName("/admin/adminChart");
        return modelAndView;
        }
}
