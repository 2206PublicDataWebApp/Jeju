package com.jeju.pay.service;

import com.jeju.chart.domain.Payment;
import com.jeju.pay.domain.Pay;

import java.util.List;

public interface PayService {

	int insertPayInfo(Pay pay);

    // 관리자페이지 결재총액 차트
    List<Payment> selectPaymentChart();
}
