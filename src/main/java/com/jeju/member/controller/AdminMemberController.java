package com.jeju.member.controller;

import com.jeju.member.domain.Member;
import com.jeju.member.service.MemberService;
import com.jeju.pagination.Pagination;

import com.jeju.review.controller.AdminReviewController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class AdminMemberController {

    // private final MemberService memberService;
    @Autowired
    private MemberService memberService;

    private static final Logger logger = LoggerFactory.getLogger(AdminMemberController.class);

    // 관리자페이지 회원조회 및 페이징
    @GetMapping("/member")
    public ModelAndView showAdminMember
            (ModelAndView modelAndView,
             @RequestParam(value = "page", required=false) Integer page
            ){
        logger.info("관리자 회원관리 페이지 접속 시도 {}", modelAndView);

        int memberTotalCount = memberService.showAllMember().size();
        int memberLimit = 10; // 한 화면에 나타날 회원의 수

        Pagination pagination = new Pagination(page, memberTotalCount, memberLimit);

        List<Member> memberPageList = memberService.pagingShowAllMember(pagination.getCurrentPage(), memberLimit);
        modelAndView.addObject("memberPageList", memberPageList);
        modelAndView.addObject("pagination", pagination);

        modelAndView.setViewName("/admin/adminMember");
        return modelAndView;
    }

    // 관리자페이지 회원탈퇴
    @GetMapping("/member/remove")
    public String removeAdminMember(@RequestParam("memberNo") Integer memberNo){
        logger.info("memberNo 데이터 확인 {}", memberNo);
        memberService.removeAdminMember(memberNo);
        return "redirect:/admin/member";
    }

    // 관리자페이지 회원 검색
    @GetMapping("/member/search")
    public ModelAndView searchAdminMember(
            ModelAndView modelAndView,
            @RequestParam("searchCondition") String searchCondition,
            @RequestParam("searchValue") String searchValue) {
        logger.info("관리자 회원관리 검색 시도 {}", modelAndView);
        List<Member> searchList = memberService.searchAllByValue(searchCondition, searchValue);
        modelAndView.addObject("memberPageList", searchList);
        modelAndView.setViewName("/admin/adminMember");

        return modelAndView;
    }
}
