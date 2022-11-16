package com.jeju.pay.service;

import com.jeju.chart.domain.Payment;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.pay.domain.Pay;
import com.jeju.pay.store.PayStore;

import java.util.List;

@Service
public class PayServiceImpl implements PayService{
	@Autowired 
	private SqlSession session;
	
	@Autowired
	private PayStore pStore;

	@Override
	public int insertPayInfo(Pay pay) {
		int result = pStore.insertPayInfo(session, pay);
		return result;
	}

	// 관리자페이지 결재총액 차트
	@Override
	public List<Payment> selectPaymentChart() {
		List<Payment> paymentChart = pStore.selectPaymentChart(session);
		return paymentChart;
	}

}
