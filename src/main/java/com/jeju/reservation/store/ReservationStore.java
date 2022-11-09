package com.jeju.reservation.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jeju.coupon.domain.Coupon;
import com.jeju.coupon.domain.MyCoupon;
import com.jeju.member.domain.Member;
import com.jeju.pension.domain.Pension;
import com.jeju.reservation.domain.Reservation;
import com.jeju.room.domain.Room;

public interface ReservationStore {

	int addReserve(SqlSession session, Reservation reservation);

	Pension selectOneByPension(SqlSession session, Integer pensionNo);

	Room selectOneByRoom(SqlSession session, Integer roomNo);

	// 관리자페이지 전체예약조회
	List<Reservation> showAllReservation(SqlSession session);
	int addReserveWati(SqlSession session, Reservation reservation);

	//결제대기 리스트 불러오기
	List<Reservation> selectWaitList(SqlSession session, String memberId);
	//결제대기 추가전 이미지 경로 불러오기
	Pension selectImage(SqlSession session, Integer rePensionNo);
	//예약완료 내역 리스트 조회
	List<Reservation> selectReserveList(SqlSession session, String memberId);
	//결제대기 후 결제하려는 창에서 정보 조회
	Reservation selectOneByWaitList(SqlSession session, Integer reservationNo);
	//결제대기 삭제
	int deleteWaitReserve(SqlSession session, Integer reservationNo);

	int removeWaitReserve(SqlSession session, String reservationName);

	int selectWaitRstatus(SqlSession session, String memberId);
	//기간만료 예약내역 불러오기
	List<Reservation> expirationList(SqlSession session, String memberId);
	//나의 쿠폰 가져오기
	List<MyCoupon> selectAllMyCoupon(SqlSession session, String memberId);
	//나의 쿠폰 정보로 쿠폰 리스트 가져오기
	Coupon selectAllCouponList(SqlSession session, String couponCode);
	//비회원 예약 조회
	Reservation selectNonMember(SqlSession session, Reservation reservation);
	//비회원 예약내역 삭제
	int deleteReserve(SqlSession session, Reservation reservation);
	//회원용 예약내역 조회
	Reservation selectReservationInfo(SqlSession session, Integer reservationNo);
	//회원용 예약 삭제
	int deleteReservation(SqlSession session, Integer reservationNo);


}
