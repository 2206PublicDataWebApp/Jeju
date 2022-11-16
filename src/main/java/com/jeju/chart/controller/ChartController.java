package com.jeju.chart.controller;

import com.jeju.chart.domain.Enrollment;
import com.jeju.chart.domain.Gender;
import com.jeju.chart.domain.Payment;
import com.jeju.member.controller.AdminMemberController;
import com.jeju.member.domain.Member;
import com.jeju.member.service.MemberService;
import com.jeju.pay.service.PayService;
import org.apache.maven.model.Model;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ChartController {

    private static final Logger logger = LoggerFactory.getLogger(ChartController.class);

    @Autowired
    private MemberService memberService;

    @Autowired
    private PayService payService;

    @GetMapping("/chart")
    public ModelAndView showAdminChart(ModelAndView modelAndView,
                                       HttpSession httpSession,
                                       HttpServletRequest request){
        logger.info("관리자페이지 차트 접속시도");
        Member member = (Member)httpSession.getAttribute("loginUser"); // 로그인 체크용
        if(ObjectUtils.isEmpty(member) || !"Y".equals(member.getAdminCheck())){
            String errorMsg = "권한이 없습니다";
            modelAndView.addObject("errorMsg", errorMsg);
            modelAndView.addObject("redirectUrl", "/member/loginView.kh");
            modelAndView.setViewName("/common/error");
            logger.warn("권한이 없는 사용자의 관리자 페이지 접근 > IP address : {}", request.getRemoteAddr());
            return modelAndView;
        }

        // 신규가입현황 차트 조회
        List<Enrollment> newRegisterChart  = memberService.selectNewRegisterChart();
        JSONArray cJsonArrRegister = new JSONArray();
        for(Enrollment enrollment : newRegisterChart ) {
            JSONObject cJsonObjRegister = new JSONObject();
            cJsonObjRegister.put("x", enrollment.getEnrollment());
            cJsonObjRegister.put("y", enrollment.getCount());
            cJsonArrRegister.add(cJsonObjRegister);
        }
        modelAndView.addObject("chartJSONRegister", cJsonArrRegister);

        // 성비 차트 조회
        List<Gender> genderChart  = memberService.selectGenderChart();
        JSONArray cJsonArrGender = new JSONArray();
        for(Gender gender : genderChart){
            JSONObject cJsonObjGender = new JSONObject();
            cJsonObjGender.put("x", gender.getGender());
            cJsonObjGender.put("y", gender.getCount());
            cJsonArrGender.add(cJsonObjGender);
        }
        modelAndView.addObject("chartJSONGender", cJsonArrGender);


        // 결재총액 차트 조회
        List<Payment> paymentChart = payService.selectPaymentChart();
        JSONArray cJsonArrPayment = new JSONArray();
        for(Payment payment : paymentChart){
            JSONObject cJsonObjPayment = new JSONObject();
            cJsonObjPayment.put("x", payment.getPaydate());
            cJsonObjPayment.put("y", payment.getSum());
            cJsonArrPayment.add(cJsonObjPayment);
        }
        modelAndView.addObject("chartJSONPayment", cJsonArrPayment);

        

        modelAndView.setViewName("/admin/adminChart");
        return modelAndView;
    }
}
