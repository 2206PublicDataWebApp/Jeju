package com.jeju.coupon.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.coupon.domain.Coupon;
import com.jeju.coupon.store.CouponStore;

@Service
public class CouponServiceImpl implements CouponService{
	@Autowired 
	private SqlSession session;
	@Autowired 
	private CouponStore cStore;
	
	//이벤트 진행중인 쿠폰 전체 조회
	@Override
	public List<Coupon> selectAllCoupon() {
		List<Coupon> cList = cStore.selectAllCoupon(session);
		return cList;
	}
}
