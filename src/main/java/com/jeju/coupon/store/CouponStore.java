package com.jeju.coupon.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jeju.coupon.domain.Coupon;

public interface CouponStore {
	//이벤트 진행중인 쿠폰 전체 조회
	List<Coupon> selectAllCoupon(SqlSession session);

}
