package com.jeju.pension.store;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.jeju.category.domain.Category;
import com.jeju.pension.domain.Pension;
import com.jeju.room.domain.Room;
import com.jeju.room.domain.RoomAttach;

@Repository
public class PensionStoreLogic implements PensionStore{

	// 숙소 번호 가져오기
	@Override
	public int selectPensionNo(SqlSessionTemplate session, Pension pension) {
		int pensionNo = session.selectOne("PensionMapper.selectPensionNo", pension);
		return pensionNo;
	}
	// 숙소 등록
	@Override
	public void insertPension(SqlSessionTemplate session, Pension pension) {
		session.insert("PensionMapper.insertPension", pension);
	}
	// 객실 번호 가져오기
	@Override
	public int selectRoomNo(SqlSessionTemplate session, Room room) {
		int roomNo = session.selectOne("RoomMapper.selectRoomNo", room);
		return roomNo;
	}
	// 객실 등록
	@Override
	public void insertRoom(SqlSessionTemplate session, Room room) {
		session.insert("RoomMapper.insertRoom",room);
	}
	// 객실 이미지 등록
	@Override
	public void insertRoomAttach(SqlSessionTemplate session, RoomAttach roomAttach) {
		session.insert("RoomAttachMapper.insertRoomAttach",roomAttach);
	}
	// 카테고리 등록
	@Override
	public void insertCategory(SqlSessionTemplate session, Category category) {
		session.insert("CategoryMapper.insertCategory", category);
	}

}
