package com.jeju.coupon.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.coupon.store.CouponStore;

@Service
public class CouponServiceImpl implements CouponService{
	@Autowired 
	private SqlSession session;
	@Autowired 
	private CouponStore cStore;
}
