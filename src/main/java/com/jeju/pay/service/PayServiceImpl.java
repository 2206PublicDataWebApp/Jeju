package com.jeju.pay.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.pay.domain.Pay;
import com.jeju.pay.store.PayStore;

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
	
}
