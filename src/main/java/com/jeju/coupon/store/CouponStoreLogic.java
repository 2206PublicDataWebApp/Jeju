package com.jeju.coupon.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jeju.coupon.domain.Coupon;

@Repository
public class CouponStoreLogic implements CouponStore{
	
	//이벤트 진행중인 쿠폰 전체 조회
	@Override
	public List<Coupon> selectAllCoupon(SqlSession session) {
		List<Coupon> cList = session.selectList("CouponMapper.selectAllEventCoupon");
		return cList;
	}

}
