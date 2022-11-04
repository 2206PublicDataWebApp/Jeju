package com.jeju.coupon.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jeju.coupon.domain.Coupon;
import com.jeju.coupon.domain.MyCoupon;

public interface CouponStore {
	//이벤트 진행중인 쿠폰 전체 조회
	List<Coupon> selectAllCoupon(SqlSession session);
	//쿠폰 내려받기
	int addMyCoupon(SqlSession session, MyCoupon myCoupon);
	//쿠폰 1개 조회
	Coupon selectOneByCoupon(SqlSession session, String couponCode);
	//쿠폰 갯수 감소
	int decreaseCount(SqlSession session, String couponCode);
	//회원 쿠폰 갯수 증가
	int increaseCount(SqlSession session, String memberId);
	//쿠폰 유무 확인
	int confirmCoupon(SqlSession session, MyCoupon couponConfirm);
	//쿠폰 적용시 나의 쿠폰 삭제
	int deleteMyCoupon(SqlSession session, String couponCode);
	//쿠폰 적용시 멤버테이블 쿠폰갯수 감소
	int decreaseMemberCoupon(SqlSession session, String memberId);
	//쿠폰적용시 사용상태 변경
	int updateUseCount(SqlSession session, MyCoupon mycoupon);
	//내 쿠폰함 리스트 가져오기
	List<MyCoupon> selectMyCouponList(SqlSession session, String memberId);

}
