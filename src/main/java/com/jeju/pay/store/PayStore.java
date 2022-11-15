package com.jeju.pay.store;

import com.jeju.chart.domain.Payment;
import org.apache.ibatis.session.SqlSession;

import com.jeju.pay.domain.Pay;

import java.util.List;

public interface PayStore {

	int insertPayInfo(SqlSession session, Pay pay);

    List<Payment> selectPaymentChart(SqlSession session);
}
