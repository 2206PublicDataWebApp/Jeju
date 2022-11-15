package com.jeju.pay.store;

import com.jeju.chart.domain.Payment;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jeju.pay.domain.Pay;

import java.util.List;

@Repository
public class PayStoreLogic implements PayStore{

	@Override
	public int insertPayInfo(SqlSession session, Pay pay) {
		int result = session.insert("PayMappers.insertPayInfo", pay);
		return result;
	}

	@Override
	public List<Payment> selectPaymentChart(SqlSession session) {
		List<Payment> paymentChart = session.selectList("PayMappers.paymentChart");
		return paymentChart;
	}

}
