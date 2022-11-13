package com.jeju.review.controller;

import com.jeju.HomeController;
import com.jeju.member.domain.Member;
import com.jeju.pagination.Pagination;
import com.jeju.pension.domain.Pension;
import com.jeju.reservation.domain.Reservation;
import com.jeju.reservation.service.ReservationService;
import com.jeju.review.domain.Review;
import com.jeju.review.service.ReviewService;
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
public class AdminReviewController {

   /* private final ReviewService reviewService;*/

    private static final Logger logger = LoggerFactory.getLogger(AdminReviewController.class);
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/review")
    public ModelAndView showAdminReview
            (ModelAndView modelAndView,
             @RequestParam(value = "page", required=false) Integer page
            ){
        logger.info("관리자 리뷰페이지 페이지 접속 시도 {}", modelAndView);

        int reviewTotalCount = reviewService.showAllReview().size();
        int reviewLimit = 10; // 한 화면에 나타날 회원의 수

        Pagination pagination = new Pagination(page, reviewTotalCount, reviewLimit);

        List<Review> reviewPageList = reviewService.pagingShowAllReview(pagination.getCurrentPage(), reviewLimit);

        // 출력되는 글자수 제한
       /*for(int i=0; i<reviewPageList.size(); i++){
           reviewPageList.get(i).setSubstringReview(reviewPageList.get(i).getReviewContents());
       }*/
        for(Review review: reviewPageList){
            review.setSubstringReview(review.getReviewContents());
        }


        modelAndView.addObject("reviewPagingList", reviewPageList);
        modelAndView.addObject("pagination", pagination);

        modelAndView.setViewName("admin/adminReview");
        return modelAndView;
    }

    //관리자페이지 리뷰 삭제
    @GetMapping("/review/remove")
    public String removeAdminReview(@RequestParam("reviewNo") Integer reviewNo){
        logger.info("관리자페이지 리뷰 삭제 시도 {}");
        reviewService.removeAdminReview(reviewNo);
        return "redirect:/admin/adminPage";
    }


}
