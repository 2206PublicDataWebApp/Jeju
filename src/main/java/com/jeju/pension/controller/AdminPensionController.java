package com.jeju.pension.controller;

import com.jeju.member.domain.Member;
import com.jeju.pagination.Pagination;
import com.jeju.pension.domain.Pension;
import com.jeju.pension.service.PensionService;
import com.jeju.reservation.domain.Reservation;
import com.jeju.review.controller.AdminReviewController;
import com.jeju.review.domain.Review;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@EnableWebSecurity
@Controller
/*@Slf4j
@RequiredArgsConstructor*/
@RequestMapping("/admin")
public class AdminPensionController {

    /*private final PensionService pensionService;*/
    private static final Logger logger = LoggerFactory.getLogger(AdminPensionController.class);
    @Autowired
    private PensionService pensionService;

    @GetMapping("/pension")
    public ModelAndView showAdminPension
            (ModelAndView modelAndView,
             @RequestParam(value = "page", required=false) Integer page
            ){
        logger.info("관리자 펜션관리 페이지 접속 시도 {}", modelAndView);

        int pensionTotalCount = pensionService.showAllPension().size();
        int pensionLimit = 10;

        Pagination pagination = new Pagination(page, pensionTotalCount, pensionLimit);

        List<Pension> pensionPageList = pensionService.pagingShowAllPension(pagination.getCurrentPage(), pensionLimit);
        /*List<Pension> pensionList = pensionService.showAllPension();*/

        modelAndView.addObject("pensionPageList", pensionPageList);
        modelAndView.addObject("pagination", pagination);
        modelAndView.setViewName("admin/adminPension");
        return modelAndView;
    }

    // 관리자페이지 숙소 삭제
    @GetMapping("/pension/remove")
    public String removeAdminPension(@RequestParam("pensionNo") Integer pensionNo){
        pensionService.removeAdminPension(pensionNo);
        return "redirect:/admin/adminPage";
    }

}
