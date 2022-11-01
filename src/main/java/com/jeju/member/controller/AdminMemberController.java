package com.jeju.member.controller;

import com.jeju.member.domain.Member;
import com.jeju.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.sonatype.aether.impl.internal.Slf4jLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminMemberController {

    private final MemberService memberService;

    // 관리자페이지 회원조회
   /* @GetMapping("/memberList")
    public ModelAndView adminMemberList(ModelAndView mv){
        List<Member> memberList = memberService.showAllMember();
        mv.addObject("memberList", memberList);
        mv.setViewName("admin/adminPage");
        return mv;
    }*/

}
