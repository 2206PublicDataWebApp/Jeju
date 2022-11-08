package com.jeju.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jeju.member.domain.Member;
import com.jeju.member.service.MemberService;
import com.jeju.pension.domain.Pension;
import com.jeju.pension.service.PensionService;
import com.jeju.reservation.domain.Reservation;
import com.jeju.reservation.service.ReservationService;
import com.jeju.review.domain.Review;
import com.jeju.review.service.ReviewService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
/*@Slf4j
@RequiredArgsConstructor*/
@RequestMapping("/admin")
public class AdminController {

    /*
    private final MemberService memberService;
    private final PensionService pensionService;
    private final ReviewService reviewService;
    private final ReservationService reservationService;
    */

    @Autowired
    private MemberService memberService;
    @Autowired
    private PensionService pensionService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ReservationService reservationService;


    // 관리자페이지 일반 화면조회, 회원목록조회, 펜션목록조회, 예약내역조회, 리뷰내역조회
    @GetMapping("/adminPage")
    public ModelAndView showAdminPage
                        (ModelAndView modelAndView,
                         @RequestParam(value = "page", required=false) Integer page
                         ){
        /*log.info("관리자  일반페이지 접속 시도 {}", modelAndView);*/

        //회원목록조회
        List<Member> memberList = memberService.showAllMember();
        //펜션목록조회
        List<Pension> pensionList = pensionService.showAllPension();
        // 예약내역조회
        List<Reservation> reservationList = reservationService.showAllReservation();
        // 리뷰내역조회
        List<Review> reviewList = reviewService.showAllReview();

        modelAndView.addObject("memberList", memberList);
        modelAndView.addObject("pensionList", pensionList);
        modelAndView.addObject("reservationList", reservationList);
        modelAndView.addObject("reviewList", reviewList);

        modelAndView.setViewName("admin/adminPage");
        return modelAndView;
    }
}
