package com.jeju.reservation.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jeju.pension.domain.Pension;
import com.jeju.reservation.domain.Reservation;
import com.jeju.room.domain.Room;

public interface ReservationStore {

	int addReserve(SqlSession session, Reservation reservation);

	Pension selectOneByPension(SqlSession session, Integer pensionNo);

	Room selectOneByRoom(SqlSession session, Integer roomNo);

	// 관리자페이지 전체예약조회
	List<Reservation> showAllReservation(SqlSession session);
}
