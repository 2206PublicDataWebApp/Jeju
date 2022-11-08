package com.jeju.reservation.controller;

import com.jeju.member.domain.Member;
import com.jeju.pension.domain.Pension;
import com.jeju.reservation.domain.Reservation;
import com.jeju.reservation.service.ReservationService;
import com.jeju.review.domain.Review;
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
public class AdminReservationController {

   /* private final ReservationService reservationService;*/

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservation")
    public ModelAndView showAdminReservation
            (ModelAndView modelAndView,
             @RequestParam(value = "page", required=false) Integer page
            ) {
       /* log.info("관리자 예약페이지 접속 시도 {}", modelAndView);*/

        List<Reservation> reservationList = reservationService.showAllReservation();
        modelAndView.addObject("reservationList", reservationList);
        modelAndView.setViewName("admin/adminReservation");
        return modelAndView;
    }
}
