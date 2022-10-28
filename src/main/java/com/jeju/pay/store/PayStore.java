package com.jeju.pay.store;

import org.apache.ibatis.session.SqlSession;

import com.jeju.pay.domain.Pay;

public interface PayStore {

	int insertPayInfo(SqlSession session, Pay pay);

}
