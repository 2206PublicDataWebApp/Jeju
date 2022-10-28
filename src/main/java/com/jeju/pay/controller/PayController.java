package com.jeju.pay.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeju.member.domain.Member;
import com.jeju.pay.domain.Pay;
import com.jeju.pay.service.PayService;

@Controller
public class PayController {
	@Autowired
	private PayService pService;
	
	@ResponseBody
	@RequestMapping(value = "/pay/success", produces="text/plain;charset=utf-8", method=RequestMethod.POST)
	public String addReservation(
			@RequestParam("payId") String payId
			,@RequestParam("roomNo") Integer roomNo
			,@RequestParam("payPrice") int payPrice
			,@RequestParam("payPensionNo") Integer payPensionNo
			,HttpSession session) {
		Member member = (Member) session.getAttribute("loginUser");
		String memberId = member.getMemberId();
		Pay pay = new Pay();
		pay.setMemberId(memberId);
		pay.setPayId(payId);
		pay.setRoomNo(roomNo);
		pay.setPayPrice(payPrice);
		pay.setPayPensionNo(payPensionNo);
		int result = pService.insertPayInfo(pay);
		if(result > 0) {
			System.out.println("결제 테이블 추가 성공!");
		}
		
		return "결제 성공! 메인페이지로 이동합니다.";	
	}
}
