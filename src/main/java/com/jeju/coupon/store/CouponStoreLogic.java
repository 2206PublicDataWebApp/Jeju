package com.jeju.coupon.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jeju.coupon.domain.Coupon;
import com.jeju.coupon.domain.MyCoupon;

@Repository
public class CouponStoreLogic implements CouponStore{
	
	//이벤트 진행중인 쿠폰 전체 조회
	@Override
	public List<Coupon> selectAllCoupon(SqlSession session) {
		List<Coupon> cList = session.selectList("CouponMapper.selectAllEventCoupon");
		return cList;
	}
	
	//쿠폰 내려받기
	@Override
	public int addMyCoupon(SqlSession session, MyCoupon myCoupon) {
		int result = session.insert("MyCouponMapper.addMyCoupon", myCoupon);
		return result;
	}
	//쿠폰 1개 조회
	@Override
	public Coupon selectOneByCoupon(SqlSession session, String couponCode) {
		Coupon coupon = session.selectOne("CouponMapper.selectOneByCoupon", couponCode);
		return coupon;
	}

	@Override
	public int decreaseCount(SqlSession session, String couponCode) {
		int decrease = session.update("CouponMapper.decreaseCouponCount", couponCode);
		return decrease;
	}

	@Override
	public int increaseCount(SqlSession session, String memberId) {
		int increase = session.update("MemberMapper.increaseCouponCount", memberId);
		return increase;
	}

	@Override
	public int confirmCoupon(SqlSession session, MyCoupon couponConfirm) {
		int count = session.selectOne("MyCouponMapper.confirmCoupon", couponConfirm);
		return count;
	}

	@Override
	public int deleteMyCoupon(SqlSession session, String couponCode) {
		int result = session.delete("MyCouponMapper.deleteMyCoupon", couponCode);
		return result;
	}

	@Override
	public int decreaseMemberCoupon(SqlSession session, String memberId) {
		int result = session.update("MemberMapper.decreaseCouponCount", memberId);
		return result;
	}

	@Override
	public int updateUseCount(SqlSession session, MyCoupon myCoupon) {
		int result = session.update("MyCouponMapper.updateUseCount", myCoupon);
		return result;
	}

	@Override
	public List<MyCoupon> selectMyCouponList(SqlSession session, String memberId) {
		List<MyCoupon> mList = session.selectList("MyCouponMapper.selectAllMyCoupon", memberId);
		return mList;
	}

	@Override
	public int increaseUseCount(SqlSession session, MyCoupon myCoupon) {
		int result = session.update("MyCouponMapper.increaseUseCount", myCoupon);
		return result;
	}


	@Override
	public List<MyCoupon> selectCouponCode(SqlSession session, String memberId) {
		List<MyCoupon> mList = session.selectList("MyCouponMapper.selectCouponCode", memberId);
		return mList;
	}

	@Override
	public int updateStatus(SqlSession session, MyCoupon myCoupon) {
		int result = session.update("MyCouponMapper.updateStatusOrigin", myCoupon);
		return result;
	}

	@Override
	public int updateCouponStatus(SqlSession session, MyCoupon myCoupon) {
		int result = session.update("MyCouponMapper.updateStatus", myCoupon);
		return result;
	}


}
