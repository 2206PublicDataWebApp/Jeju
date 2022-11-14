package com.jeju.coupon.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.coupon.domain.Coupon;
import com.jeju.coupon.domain.MyCoupon;
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
	
	//쿠폰 내려받기
	@Override
	public int addMyCoupon(MyCoupon myCoupon) {
		int result = cStore.addMyCoupon(session, myCoupon);
		return result;
	}
	//쿠폰 1개 조회
	@Override
	public Coupon selectOneByCoupon(String couponCode) {
		Coupon coupon = cStore.selectOneByCoupon(session, couponCode);
		return coupon;
	}
	
	//쿠폰 갯수 감소
	@Override
	public int decreaseCount(String couponCode) {
		int decrease = cStore.decreaseCount(session, couponCode);
		return decrease;
	}

	@Override
	public int increaseCount(String memberId) {
		int increase = cStore.increaseCount(session, memberId);
		return increase;
	}

	@Override
	public int confirmCoupon(MyCoupon couponConfirm) {
		int count = cStore.confirmCoupon(session, couponConfirm);
		return count;
	}

	@Override
	public int deleteMyCoupon(String couponCode) {
		int result = cStore.deleteMyCoupon(session, couponCode);
		return result;
	}

	@Override
	public int decreaseMemberCoupon(String memberId) {
		int result = cStore.decreaseMemberCoupon(session, memberId);
		return result;
	}

	@Override
	public int updateUseCount(MyCoupon mycoupon) {
		int result = cStore.updateUseCount(session, mycoupon);
		return result;
	}

	@Override
	public List<MyCoupon> selectMyCouponList(String memberId) {
		List<MyCoupon> mList = cStore.selectMyCouponList(session, memberId);
		return mList;
	}

	@Override
	public int increaseUseCount(MyCoupon myCoupon) {
		int result = cStore.increaseUseCount(session, myCoupon);
		return result;
	}


	@Override
	public List<MyCoupon> selectCouponCode(String memberId) {
		List<MyCoupon> mList = cStore.selectCouponCode(session, memberId);
		return mList;
	}

	@Override
	public int updateStatus(MyCoupon myCoupon) {
		int result = cStore.updateStatus(session, myCoupon);
		return result;
	}

	@Override
	public int updateCouponStatus(MyCoupon myCoupon) {
		int result = cStore.updateCouponStatus(session, myCoupon);
		return result;
	}

}
