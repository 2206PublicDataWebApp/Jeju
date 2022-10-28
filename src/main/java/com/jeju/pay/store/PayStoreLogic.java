package com.jeju.pay.store;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jeju.pay.domain.Pay;

@Repository
public class PayStoreLogic implements PayStore{

	@Override
	public int insertPayInfo(SqlSession session, Pay pay) {
		int result = session.insert("PayMappers.insertPayInfo", pay);
		return result;
	}

}
