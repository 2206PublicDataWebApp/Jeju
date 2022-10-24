package com.jeju.reservation.store;

import org.apache.ibatis.session.SqlSession;

import com.jeju.reservation.domain.Reservation;

public interface ReservationStore {

	int addReserve(SqlSession session, Reservation reservation);

}
