package com.jeju.reservation.service;

import java.util.List;

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

}
