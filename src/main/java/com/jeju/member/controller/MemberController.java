package com.jeju.member.controller;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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


	// 회원가입할때 회원가입 페이지
	@RequestMapping(value="/member/joinView.kh", method=RequestMethod.GET)
	public String memberJoinView(Model model) {
		return "member/join";
		// /WEB-INF/views/member/join.jsp
	}
	//마이페이지 수정
//		@RequestMapping(value="/mypage/modifyView", method=RequestMethod.GET)
//		public String memberModifyView(Model model) {
//			return "mypage/modify";
//			// /WEB-INF/views/member/join.jsp
//		}
	// login 페이지
	@RequestMapping(value="/member/loginView.kh", method=RequestMethod.GET)
	public String memberLoginView(Model model) {
		return "member/login";
		// /WEB-INF/views/member/join.jsp
	}
	// 찜 login 페이지
		@RequestMapping(value="/member/loginView.kh2", method=RequestMethod.GET)
		public ModelAndView memberLoginView2(
				ModelAndView mv
				,@RequestParam("pensionNo") Integer pensionNo) {
			mv.addObject("pensionNo", pensionNo);
			mv.setViewName("member/login");
			return mv;
		}
	//  회원정보를 DB에 저장하는 URL
	@RequestMapping(value="/member/register.kh", method=RequestMethod.POST)
	public ModelAndView memberJoin(
			@ModelAttribute Member member
			, @RequestParam("post") String post
			, @RequestParam("address1") String address1
			, @RequestParam("address2") String address2
//			, Model model
			, ModelAndView mv) {
		try {

			System.out.println("주의 이름은");
			member.setMemberAddr(post + "," + address1 + "," + address2);
			System.out.println(member.getMemberAddr());
			int result = mService.registerMember(member);
			if(result > 0) {
				mv.setViewName("redirect:/member/loginView.kh");
			}else {
				mv.addObject("msg", "회원가입을 실패했습니다.");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {

			mv.addObject("msg", e.toString()).setViewName("common/errorPage");
		}
		return mv;
	}
	// 로그인 기능
	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public ModelAndView memberLogin(
			@RequestParam("memberId") String memberId
			,@RequestParam("memberPwd") String memberPwd
			,@RequestParam(value="pensionNo", required = false) Integer pensionNo
			, ModelAndView mv
			, HttpServletRequest request
			,HttpServletResponse response) {
		try {
			Member member = new Member();
			member.setMemberId(memberId);
			member.setMemberPwd(memberPwd);
			System.out.println(memberId);
			System.out.println(memberPwd);
			Member loginUser = mService.loginMember(member);
			System.out.println(loginUser);
			if(loginUser != null) {
				System.out.println("성공");
				HttpSession session = request.getSession();

				session.setAttribute("loginUser", loginUser);
				if(pensionNo != null) {
					mv.setViewName("redirect:/pension/detailView2?pensionNo=" + pensionNo);
				}else {
					mv.setViewName("redirect:/home");
				}
			}else {
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
		String content =
				"홈페이지를 방문해주셔서 감사합니다." +
						"<br><br>" +
						"인증 번호는 " + checkNum + "입니다." +
						"<br>" +
						"해당 인증번호를 인증번호 확인란에 기입하여 주세요.";

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content,true);
			mailSender.send(message);

		}catch(Exception e) {
			e.printStackTrace();
		}
		return Integer.toString(checkNum);
	}

	// 로그아웃 기능
	@RequestMapping(value="/member/logout.kh", method=RequestMethod.GET)
	public ModelAndView memberLogout(
			HttpServletRequest request
//			, Model model
			, ModelAndView mv) {
		HttpSession session = request.getSession();
		if(session != null) {
			session.invalidate();
//			return "redirect:/home.kh";
			mv.setViewName("redirect:/home.kh");
		}else {
//			model.addAttribute("msg", "로그아웃 실패");
//			return "common/errorPage";
			mv.addObject("msg", "로그아웃 실패");
			mv.setViewName("common/errorPage");
		}

		return mv;
	}

	@RequestMapping(value="/mypage/modifyView", method=RequestMethod.GET)
	public ModelAndView memberModifyView(ModelAndView mv
			,HttpSession session) {
		Member member = (Member) session.getAttribute("loginUser");
		String memberId = member.getMemberId();
		Member memberInfo = mService.selectMemberInfo(memberId);
		mv.addObject("member", member);
		mv.setViewName("mypage/modify");

		return mv;
		// /WEB-INF/views/member/join.jsp
	}
	// 회원 정보 수정
	@RequestMapping(value="/member/modify", method=RequestMethod.POST)
	public ModelAndView modifyMember(
			@ModelAttribute Member member
			, @RequestParam("post") String post
			, @RequestParam("address") String memberAddr
//			, Model model
			, ModelAndView mv) {
		try {
			member.setMemberAddr(post + "," + memberAddr);
			int result = mService.modifyMember(member);
			if(result > 0) {
				// redirect
				// return "redirect:/home.kh";
//				return "redirect:/home.kh";
				mv.setViewName("/home");
			}else {
//				model.addAttribute("msg", "회원 정보가 수정되지 않았습니다.");
//				return "common/errorPage";
				mv.addObject("msg", "회원 정보 수정 실패!");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
//			model.addAttribute("msg", e.getMessage());
//			return "common/errorPage";
			mv.addObject("msg", e.getMessage()).setViewName("common/errorPage");
		}
		return mv;
	}
	// 회원정보삭제 -> 회원탈퇴 기능
	@RequestMapping(value="/member/remove", method=RequestMethod.GET)
	public ModelAndView removeMember(HttpSession session
//			, Model model
			, ModelAndView mv) {
		try {
			Member member = (Member)session.getAttribute("loginUser");
			String memberId = member.getMemberId();
			int result = mService.removeMember(memberId);
//			return "redirect:/member/logout.kh";

			mv.setViewName("redirect:/member/logout.kh");
		} catch (Exception e) {
//			model.addAttribute("msg", e.toString());
//			return "common/errorPage";
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	//	private void doPost(HttpServletRequest request, HttpServletResponse response) {
//		// TODO Auto-generated method stub
//		String memberId = request.getParameter("memberId");
//		Member member = new Member();
//		int result = new MemberServiceImple().registerMember(member);
//	}
	// 회원 상세정보 조회
	@RequestMapping(value="/member/myPage.kh", method=RequestMethod.GET)
	public ModelAndView showMyPage(HttpServletRequest request
								   //			, Model model
			, ModelAndView mv) {
		try {
			/////////////////////////////////////////////////////
			HttpSession session = request.getSession();
			Member member = (Member)session.getAttribute("loginUser");
			String memberId = member.getMemberId();
			Member mOne = mService.printOneById(memberId);
			//////////////////////////////////////////////////////
			String mAddr = mOne.getMemberAddr(); // 18230,서울시 중구
			String [] addrInfos = mAddr.split(",");
			//			model.addAttribute("member", mOne);
			//			model.addAttribute("addrInfos", addrInfos);
			//			return "member/myPage";
			mv.addObject("member", mOne).addObject("addrInfos", addrInfos);
			mv.setViewName("member/myPage");
		} catch (Exception e) {
			//			model.addAttribute("msg", e.getMessage());
			//			return "common/errorPage";
			mv.addObject("msg", e.getMessage()).setViewName("common/errorPage");
		}
		return mv;
	}
	
	//아이디 중복검사
	@ResponseBody
	@RequestMapping(value="/member/checkDupEmail.kh", method=RequestMethod.GET)
	public String duplicateEmailCheck(
			@RequestParam("memberEmail") String memberEmail) {
		// 데이터가 있으면 객체 or 1 or true
		// 데이터가 없으면 null or 0 or false
		int result = mService.checkDupEmail(memberEmail);
//			return result+"";
		return String.valueOf(result);
	}

	//아이디 중복검사
	@ResponseBody
	@RequestMapping(value="/member/checkDupId.kh", method=RequestMethod.GET)
	public String duplicateIdCheck(
			@RequestParam("memberId") String memberId) {
		// 데이터가 있으면 객체 or 1 or true
		// 데이터가 없으면 null or 0 or false
		int result = mService.checkDupId(memberId);
//			return result+"";
		return String.valueOf(result);
	}
	//아이디 찾기
	@RequestMapping(value="/member/findId",method=RequestMethod.GET)
	public String findId() {
		return "/member/findId";
	}

	//어아디 찾기 결과창
	@RequestMapping(value="/member/findIdResult", method=RequestMethod.POST)
	public ModelAndView findIdResult(
			ModelAndView mv
			,@RequestParam("memberEmail") String memberEmail) {
		List<Member> sList = mService.findIdByEmail(memberEmail);
		mv.addObject("sList", sList);
		mv.setViewName("/member/findIdResult");
		return mv;
	}

	//비번 찾기 페이지
	@RequestMapping("/member/findPwd")
	public String findPwd() {
		return "/member/findPwd";
	}
	//비번 찾기 결과창
	@RequestMapping(value="/member/findPwdResult", method=RequestMethod.POST)
	public ModelAndView findPwdResult(
			ModelAndView mv
			,@RequestParam("memberEmail") String memberEmail) {
		List<Member> sList = mService.findPwdByEmail(memberEmail);
		mv.addObject("sList", sList);
		mv.setViewName("/member/findPwdResult");
		return mv;
	}
	// 마이페이지로 이동
	@RequestMapping(value="/mypage/myPage", method=RequestMethod.GET)
	public String myPageView() {
		return "/mypage/myPageView";
	}





//	//아이디 찾는화면
//	@RequestMapping(value="/member/findId.kh", method=RequestMethod.GET)
//	public String findId() {
//		return "member/findId";
//	}
	//아이디를 찾아서 보여주는 컨트롤러
//	@RequestMapping(value="/member/findMember", method=RequestMethod.POST)
//	public ModelAndView findMember(
//		@RequestParam("memberName") String memberName
//		,@RequestParam("memberPwd") String memberPwd
//		, ModelAndView mv
//		, HttpServletRequest request
//		,HttpServletResponse response) {
//		try
//
//		return mv;
//	}

}





