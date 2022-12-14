package com.jeju.member.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jeju.member.domain.Member;
import com.jeju.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService mService;

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	// 회원가입할때 회원가입 페이지
	@RequestMapping(value = "/member/joinView.kh", method = RequestMethod.GET)
	public String memberJoinView(Model model) {
		return "member/join";
		// /WEB-INF/views/member/join.jsp
	}

	@RequestMapping(value = "/member/loginView.kh", method = RequestMethod.GET)
	public String memberLoginView(Model model) {
		return "member/login";
		// /WEB-INF/views/member/join.jsp
	}

	// 찜 login 페이지
	@RequestMapping(value = "/member/loginView.kh2", method = RequestMethod.GET)
	public ModelAndView memberLoginView2(ModelAndView mv, @RequestParam("pensionNo") Integer pensionNo) {
		mv.addObject("pensionNo", pensionNo);
		mv.setViewName("member/login");
		return mv;
	}

	// 회원정보를 DB에 저장하는 URL
	@RequestMapping(value = "/member/register.kh", method = RequestMethod.POST)
	public ModelAndView memberJoin(@ModelAttribute Member member, @RequestParam("post") String post,
			@RequestParam("address1") String address1, @RequestParam("address2") String address2, ModelAndView mv) {
		try {

			// 비밀번호 암호화
			String securePw = passwordEncoder.encode(member.getMemberPwd());
			member.setMemberPwd(securePw);
			logger.info("비밀번호 암호화 시도 {}", securePw);

			member.setMemberAddr(post + "," + address1 + "," + address2);
			int result = mService.registerMember(member);
			if (result > 0) {
				mv.setViewName("redirect:/member/loginView.kh");
			} else {
				mv.addObject("msg", "회원가입을 실패했습니다.");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", e.toString()).setViewName("common/errorPage");
		}
		return mv;
	}

	// 로그인 기능
	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public ModelAndView memberLogin(@RequestParam("memberId") String memberId,
			@RequestParam("memberPwd") String memberPwd,
			@RequestParam(value = "pensionNo", required = false) Integer pensionNo, ModelAndView mv,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			// 암호화된 비밀번호를 matches를 이용하여 비교
			Member member = mService.printOneById(memberId);
			Member loginUser = new Member();
			loginUser.setMemberId(member.getMemberId());
			loginUser.setMemberName(member.getMemberName());
			loginUser.setAdminCheck(member.getAdminCheck());
			if (passwordEncoder.matches(memberPwd, member.getMemberPwd())) {

				logger.info("로그인 성공");
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", loginUser);
				if (pensionNo != null) {
					mv.setViewName("redirect:/pension/detailView2?pensionNo=" + pensionNo);
				} else {
					mv.setViewName("redirect:/home");
				}
			} else {
				mv.addObject("msg", "회원정보를 찾을 수 없습니다.");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}

	@Autowired
	private JavaMailSender mailSender;

	@ResponseBody
	@RequestMapping(value = "/emailAuth", method = RequestMethod.POST)
	public String emailAuth(@RequestParam("email") String email) {
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;

		/* 이메일 보내기 */
		String setFrom = "lhr7517@naver.com";
		String toMail = email;
		String title = " 인증 이메일 입니다.";
		String content = "홈페이지를 방문해주셔서 감사합니다." + "<br><br>" + "인증 번호는 " + checkNum + "입니다." + "<br>"
				+ "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content, true);
			mailSender.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Integer.toString(checkNum);
	}

	// 로그아웃 기능
	@RequestMapping(value = "/member/logout.kh", method = RequestMethod.GET)
	public ModelAndView memberLogout(HttpServletRequest request, ModelAndView mv) {
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();

			mv.setViewName("redirect:/home.kh");
		} else {

			mv.addObject("msg", "로그아웃 실패");
			mv.setViewName("common/errorPage");
		}

		return mv;
	}

	@RequestMapping(value = "/mypage/modifyView", method = RequestMethod.GET)
	public ModelAndView memberModifyView(ModelAndView mv, HttpSession session) {
		Member member = (Member) session.getAttribute("loginUser");
		String memberId = member.getMemberId();
		Member memberInfo = mService.selectMemberInfo(memberId);
		mv.addObject("member", memberInfo);
		mv.setViewName("mypage/modify");

		return mv;

	}

	// 회원 정보 수정
	@RequestMapping(value = "/member/modify", method = RequestMethod.POST)
	public ModelAndView modifyMember(@ModelAttribute Member member, @RequestParam("post") String post,
			@RequestParam("address") String memberAddr

			, ModelAndView mv) {
		try {
			String securePw = passwordEncoder.encode(member.getMemberPwd());
			member.setMemberPwd(securePw);
			logger.info("비밀번호 암호화 시도 {}", securePw);

			member.setMemberAddr(post + "," + memberAddr);
			int result = mService.modifyMember(member);
			if (result > 0) {
				mv.setViewName("redirect:/mypage/myPage");
			} else {
				mv.addObject("msg", "회원 정보 수정 실패!");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage()).setViewName("common/errorPage");
		}
		return mv;
	}

	// 회원정보삭제 -> 회원탈퇴 기능
	@RequestMapping(value = "/member/remove", method = RequestMethod.GET)
	public ModelAndView removeMember(HttpSession session

			, ModelAndView mv) {
		try {
			Member member = (Member) session.getAttribute("loginUser");
			String memberId = member.getMemberId();
			int result = mService.removeMember(memberId);

			mv.setViewName("redirect:/member/logout.kh");
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}

	// 회원 상세정보 조회
	@RequestMapping(value = "/member/myPage.kh", method = RequestMethod.GET)
	public ModelAndView showMyPage(HttpServletRequest request
	// , Model model
			, ModelAndView mv) {
		try {

			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginUser");
			String memberId = member.getMemberId();
			Member mOne = mService.printOneById(memberId);

			String mAddr = mOne.getMemberAddr(); // 18230,서울시 중구
			String[] addrInfos = mAddr.split(",");

			mv.addObject("member", mOne).addObject("addrInfos", addrInfos);
			mv.setViewName("member/myPage");
		} catch (Exception e) {

			mv.addObject("msg", e.getMessage()).setViewName("common/errorPage");
		}
		return mv;
	}

	// 아이디 중복검사
	@ResponseBody
	@RequestMapping(value = "/member/checkDupEmail.kh", method = RequestMethod.GET)
	public String duplicateEmailCheck(@RequestParam("memberEmail") String memberEmail) {
		// 데이터가 있으면 객체 or 1 or true
		// 데이터가 없으면 null or 0 or false
		int result = mService.checkDupEmail(memberEmail);
//			return result+"";
		return String.valueOf(result);
	}

	// 아이디 중복검사
	@ResponseBody
	@RequestMapping(value = "/member/checkDupId.kh", method = RequestMethod.GET)
	public String duplicateIdCheck(@RequestParam("memberId") String memberId) {
		// 데이터가 있으면 객체 or 1 or true
		// 데이터가 없으면 null or 0 or false
		int result = mService.checkDupId(memberId);
		return String.valueOf(result);
	}

	// 아이디 찾기
	@RequestMapping(value = "/member/findId", method = RequestMethod.GET)
	public String findId() {
		return "/member/findId";
	}

	// 어아디 찾기 결과창
	@RequestMapping(value = "/member/findIdResult", method = RequestMethod.POST)
	public ModelAndView findIdResult(ModelAndView mv, @RequestParam("memberEmail") String memberEmail) {
		List<Member> sList = mService.findIdByEmail(memberEmail);
		mv.addObject("sList", sList);
		mv.setViewName("/member/findIdResult");
		return mv;
	}

	
	@RequestMapping(value="/member/findPwdResult", method=RequestMethod.POST)
	public String findPwdResult(
			String memberId,
			String memberEmail) {
		//임시 비밀번호 생성
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7','8', '9',
									  'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
									  'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
									  'U', 'V', 'W', 'X', 'Y', 'Z' };
		int idx = 0;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 10; i++) {
		  idx = (int)(charSet.length * Math.random()); // 0~35 난수 발생
		  sb.append(charSet[idx]);
		}
		//임시 비밀번호로 테이블 변경
		String memberPwd = passwordEncoder.encode(sb.toString());
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPwd(memberPwd);
		int result = mService.changePwd(member);
		//이메일 발송
		String subject = "임시 비밀번호가 전송 됐습니다";
		String content = " 비밀번호가 ["+sb+"]로 변경되었습니다.임시 비밀번호이기 때문에 로그인 후 비밀번호를 꼭 변경해주세요";
		String from =" <lhr7517@naver.com>";
		String to = memberEmail;
		try {
			//MimeMessage 객체를 생성하여 발송하는 방법
			MimeMessage mail = mailSender.createMimeMessage();
			MimeMessageHelper mailHelper = new MimeMessageHelper(mail,true,"UTF-8"); //true는 멀티파트 메시지를 사용한다는 의미, 단순 텍스트는 생략가능
			mailHelper.setFrom(from);			//보내는이
			mailHelper.setTo(to);				//받는이
			mailHelper.setSubject(subject);		//제목
            mailHelper.setText(content, true);	//내용, 

           mailSender.send(mail);				//전송
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return "member/login";
	}
	// 비번 찾기 페이지
	@RequestMapping("/member/findPwd")
	public String findPwd() {
		return "/member/findPwd";
	}

	// 마이페이지로 이동
	@RequestMapping(value = "/mypage/myPage", method = RequestMethod.GET)
	public String myPageView() {
		return "/mypage/myPageView";
	}

}




