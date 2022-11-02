package com.jeju.coupon.service;

import java.util.List;

import com.jeju.coupon.domain.Coupon;

public interface CouponService {
	//이벤트 진행중인 쿠폰 전체 조회
	List<Coupon> selectAllCoupon();

}
