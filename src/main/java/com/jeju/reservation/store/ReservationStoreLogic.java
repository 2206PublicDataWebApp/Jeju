package com.jeju.reservation.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jeju.coupon.domain.Coupon;
import com.jeju.coupon.domain.MyCoupon;
import com.jeju.member.domain.Member;
import com.jeju.pension.domain.Pension;
import com.jeju.reservation.domain.Reservation;
import com.jeju.room.domain.Room;

@Repository
public class ReservationStoreLogic implements ReservationStore{

	@Override
	public int addReserve(SqlSession session, Reservation reservation) {
		int result = session.insert("ReservationMapper.insertReservation", reservation);
		return result;
	}

	@Override
	public Pension selectOneByPension(SqlSession session, Integer pensionNo) {
		Pension pList = session.selectOne("PensionMapper.selectPension", pensionNo);
		return pList;
	}

	@Override
	public Room selectOneByRoom(SqlSession session, Integer roomNo) {
		Room room = session.selectOne("RoomMapper.selectOneByRoom", roomNo);
		return room;
	}

	@Override
	public int addReserveWati(SqlSession session, Reservation reservation) {
		int result = session.insert("ReservationMapper.insertReservationWait", reservation);
		return result;
	}

	//결제대기 리스트 불러오기
	@Override
	public List<Reservation> selectWaitList(SqlSession session, String memberId) {
		List<Reservation> wList = session.selectList("ReservationMapper.selectWaitList", memberId);
		return wList;
	}

	@Override
	public Pension selectImage(SqlSession session, Integer rePensionNo) {
		Pension imageList = session.selectOne("PensionMapper.selectImage", rePensionNo);
 		return imageList;
	}

	@Override
	public List<Reservation> selectReserveList(SqlSession session, String memberId) {
		List<Reservation> rList = session.selectList("ReservationMapper.selectReserveList", memberId);
		return rList;
	}

	@Override
	public Reservation selectOneByWaitList(SqlSession session, Integer reservationNo) {
		Reservation rList = session.selectOne("ReservationMapper.selectOneByWaitList", reservationNo);
		return rList;
	}

	//결제대기 수동삭제
	@Override
	public int deleteWaitReserve(SqlSession session, Integer reservationNo) {
		int result = session.delete("ReservationMapper.deleteWaitReserve", reservationNo);
		return result;
	}

	//결제대기 자동삭제
	@Override
	public int removeWaitReserve(SqlSession session, String reservationName) {
		int result = session.delete("ReservationMapper.removeWaitReserve", reservationName);
		return result;
	}

	@Override
	public int selectWaitRstatus(SqlSession session, String memberId) {
		int result = session.selectOne("ReservationMapper.selectRstatus", memberId);
		return result;
	}



	// 관리자페이지 전체예약조회
	@Override
	public List<Reservation> showAllReservation(SqlSession session) {
		List<Reservation> reservationList = session.selectList("ReservationMapper.adminShowAllReservation");
		return reservationList;
	}

	@Override
	public List<Reservation> expirationList(SqlSession session, String memberId) {
		List<Reservation> sList = session.selectList("ReservationMapper.selectExpirationList", memberId);
		return sList;
	}

	@Override
	public List<MyCoupon> selectAllMyCoupon(SqlSession session, String memberId) {
		List<MyCoupon> cList = session.selectList("MyCouponMapper.selectAllMyCoupon", memberId);
		return cList;
	}

	@Override
	public Coupon selectAllCouponList(SqlSession session, String couponCode) {
		Coupon cList = session.selectOne("CouponMapper.selectOneByCoupon", couponCode);
		return cList;
	}

	@Override
	public Reservation selectNonMember(SqlSession session, Reservation reservation) {
		Reservation reserveInfo = session.selectOne("ReservationMapper.selectNonMemberReserve", reservation);
		return reserveInfo;
	}

	@Override
	public int deleteReserve(SqlSession session, Reservation reservation) {
		int result = session.delete("ReservationMapper.deleteReservation", reservation);
		return result;
	}

	@Override
	public Reservation selectReservationInfo(SqlSession session, Integer reservationNo) {
		Reservation reserveInfo = session.selectOne("ReservationMapper.selectOneReservation", reservationNo);
		return reserveInfo;
	}

	@Override
	public int deleteReservation(SqlSession session, Integer reservationNo) {
		int result = session.delete("ReservationMapper.deleteReserve",reservationNo);
		return result;
	}

	@Override
	public Reservation selectCouponCode(SqlSession session, Integer reservationNo) {
		Reservation couponCode = session.selectOne("ReservationMapper.selectCouponCode", reservationNo);
		return couponCode;
	}

	@Override
	public int upCouponCount(SqlSession session, Reservation reservation) {
		int result = session.update("MyCouponMapper.updateStatusOrigin", reservation);
		return result;
	}

	@Override
	public int updateStatus(SqlSession session, Reservation reservation) {
		int result = session.update("MyCouponMapper.updateStatus", reservation);
		return result;
	}

	@Override
	public Member selectOneByMember(SqlSession session, String memberId) {
		Member mOne = session.selectOne("MemberMapper.selectOneByMember", memberId);
		return mOne;
	}

}
