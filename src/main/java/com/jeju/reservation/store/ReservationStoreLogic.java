package com.jeju.reservation.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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
	
}
