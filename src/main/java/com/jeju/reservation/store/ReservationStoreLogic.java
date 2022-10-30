package com.jeju.reservation.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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

	@Override
	public int deleteWaitReserve(SqlSession session, Integer reservationNo) {
		int result = session.delete("ReservationMapper.deleteWaitReserve", reservationNo);
		return result;
	}

	
}
