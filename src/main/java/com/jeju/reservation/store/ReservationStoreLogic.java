package com.jeju.reservation.store;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jeju.reservation.domain.Reservation;

@Repository
public class ReservationStoreLogic implements ReservationStore{

	@Override
	public int addReserve(SqlSession session, Reservation reservation) {
		int result = session.insert("ReservationMapper.insertReservation", reservation);
		return result;
	}
	
}
