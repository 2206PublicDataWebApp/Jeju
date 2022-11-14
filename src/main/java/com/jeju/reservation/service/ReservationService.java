package com.jeju.reservation.service;

import java.util.List;

import com.jeju.coupon.domain.Coupon;
import com.jeju.coupon.domain.MyCoupon;
import com.jeju.member.domain.Member;
import com.jeju.pension.domain.Pension;
import com.jeju.reservation.domain.Reservation;
import com.jeju.room.domain.Room;

public interface ReservationService {

	void certifiedPhoneNumber(String userPhoneNumber, int randomNumber);

	int addReservation(Reservation reservation);

	Pension selectOneByPension(Integer pensionNo);

	Room selectOneByRoom(Integer roomNo);
	//결제 대기 추가
	int addReservationWait(Reservation reservation);	
	//결제대기 리스트 불러오기
	List<Reservation> selectWaitList(String memberId);
	//결제대기 추가시 이미지 경로 불러오기
	Pension selectImage(Integer rePensionNo);
	//예약완료 내역 리스트 조회
	List<Reservation> selectReserveList(String memberId);
	//결제대기 후 결제하려는 창에서 정보 조회
	Reservation selectOneByWaitList(Integer reservationNo);
	//결제대기 삭제
	int deleteWaitReserve(Integer reservationNo);

	int removeWaitReserve(String reservationName);

	int selectRstatus(String memberId);

	//관리자페이지 전체예약조회
	List<Reservation> showAllReservation();
	//기한 만료 내역 불러오기
	List<Reservation> expirationReserveList(String memberId);
	//나의 쿠폰정보 가져오기
	List<MyCoupon> selectAllMyCoupon(String memberId);
	//나의쿠폰정보로 쿠폰테이블의 내용, 제목등 가져오기
	Coupon selectAllCouponList(String couponCode);
	//비회원 정보 조회
	Reservation selectNonMemberInfo(Reservation reservation);
	//비회원 예약내역 삭제
	int deleteReserve(Reservation reservation);
	//회원용 예약내역 조회
	Reservation selectReservationInfo(Integer reservationNo);
	//회원용 예약 삭제
	int deleteReservation(Integer reservationNo);
	//결제대기 취소시 쿠폰코드 삭제를 위해 조회
	Reservation selectCouponCode(Integer reservationNo);
	//쿠폰 다시사용할 수 있게 함
	int upCouponCount(Reservation reservation);

	int updateStatus(Reservation reservation);

	void sendReservationCode(String phoneNumber, String reservationCode);

	Member selectOneByMember(String memberId);

}
