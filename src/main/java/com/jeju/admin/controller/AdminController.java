package com.jeju.admin.controller;

import com.jeju.admin.service.AdminService;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Logger;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final MemberService memberService;
    private final PensionService pensionService;
    private final ReviewService reviewService;
    private final ReservationService reservationService;

    // 관리자페이지 화면조회, 회원목록조회, 펜션목록조회, 예약내역조회, 리뷰내역조회
    @GetMapping("/adminPage")
    public ModelAndView showAdminPage(ModelAndView modelAndView){
        log.info("어드민 페이지 접속 시도 {}", modelAndView);

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


  /*  @GetMapping("/adminPage")
    public ModelAndView showAdminPension(ModelAndView modelAndView){
        //log.info("펜션목록 접근 시도 {}", modelAndView);
        List<Pension> pensionList = pensionService.showAllPension();
        modelAndView.addObject("pensionList", pensionList);
        modelAndView.setViewName("admin/adminPage");
        return modelAndView;
    }*/


    // 관리자페이지 회원탈퇴
    public void deleteAdminMember(){
    }

    // 관리자페이지 숙소 삭제
    public void deleteAdminPension(){
    }

    //관리자페이지 리뷰 삭제
    public void deleteAdminReview(){
    }
}
