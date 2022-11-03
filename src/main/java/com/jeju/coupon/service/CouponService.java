package com.jeju.coupon.service;

import java.util.List;

import com.jeju.coupon.domain.Coupon;
import com.jeju.coupon.domain.MyCoupon;

public interface CouponService {
	//이벤트 진행중인 쿠폰 전체 조회
	List<Coupon> selectAllCoupon();
	//쿠폰 내려받기
	int addMyCoupon(MyCoupon myCoupon);
	//쿠폰 1개정보 조회
	Coupon selectOneByCoupon(String couponCode);
	//쿠폰 갯수 감소
	int decreaseCount(String couponCode);
	//회원 현재 쿠폰 갯수 증가
	int increaseCount(String memberId);
	//쿠폰 유무 확인
	int confirmCoupon(MyCoupon couponConfirm);
	//쿠폰적용시 쿠폰 삭제
	int deleteMyCoupon(String couponCode);
	//쿠폰적용시 멤버테이블 쿠폰갯수 1감소
	int decreaseMemberCoupon(String memberId);
	//쿠폰적용했을때 사용횟수 1로바뀜
	int updateUseCount(MyCoupon mycoupon);

}
