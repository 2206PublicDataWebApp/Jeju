package com.jeju.review.controller;

import com.jeju.member.domain.Member;
import com.jeju.pension.domain.Pension;
import com.jeju.reservation.domain.Reservation;
import com.jeju.reservation.service.ReservationService;
import com.jeju.review.domain.Review;
import com.jeju.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
/*@Slf4j
@RequiredArgsConstructor*/
@RequestMapping("/admin")
public class AdminReviewController {

   /* private final ReviewService reviewService;*/

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/review")
    public ModelAndView showAdminReview
            (ModelAndView modelAndView,
             @RequestParam(value = "page", required=false) Integer page
            ){
       /* log.info("관리자 리뷰페이지 페이지 접속 시도 {}", modelAndView);*/
        List<Review> reviewList = reviewService.showAllReview();
        modelAndView.addObject("reviewList", reviewList);
        modelAndView.setViewName("admin/adminReview");
        return modelAndView;
    }

    //관리자페이지 리뷰 삭제
    @GetMapping("/review/remove")
    public String removeAdminReview(@RequestParam("reviewNo") Integer reviewNo){
        reviewService.removeAdminReview(reviewNo);
        return "redirect:/admin/adminPage";
    }


}
