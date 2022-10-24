package com.jeju.pension.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.category.domain.Category;
import com.jeju.pension.domain.Pension;
import com.jeju.pension.store.PensionStore;
import com.jeju.room.domain.Room;
import com.jeju.room.domain.RoomAttach;

@Service
public class PensionServiceImpl implements PensionService{

	@Autowired
	private SqlSessionTemplate session;
	
	@Autowired
	private PensionStore pStore;

	// 숙소 번호 가져오기
	@Override
	public int selectePensionNo(Pension pension) {
		int pensionNo = pStore.selectPensionNo(session, pension);
		return pensionNo;
	}

	// 숙소 등록
	@Override
	public void registerPension(Pension pension) {
		pStore.insertPension(session, pension);
		
	}

	// 객실 번호 가져오기
	@Override
	public int selecteRoomNo(Room room) {
		int roomNo = pStore.selectRoomNo(session, room);
		return roomNo;
	}

	// 객실 등록
	@Override
	public void registerRoom(Room room) {
		pStore.insertRoom(session, room);
	}

	// 객실 이미지 등록
	@Override
	public void registerRoomAttach(RoomAttach roomAttach) {
		pStore.insertRoomAttach(session, roomAttach);
	}

	// 카테고리 등록
	@Override
	public void registerCategory(Category category) {
		pStore.insertCategory(session, category);
	}
}
