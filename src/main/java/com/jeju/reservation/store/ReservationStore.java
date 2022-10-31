package com.jeju.reservation.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jeju.member.domain.Member;
import com.jeju.pension.domain.Pension;
import com.jeju.reservation.domain.Reservation;
import com.jeju.room.domain.Room;

public interface ReservationStore {

	int addReserve(SqlSession session, Reservation reservation);

	Pension selectOneByPension(SqlSession session, Integer pensionNo);

	Room selectOneByRoom(SqlSession session, Integer roomNo);

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


}
