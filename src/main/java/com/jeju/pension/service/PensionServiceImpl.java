package com.jeju.pension.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.category.domain.Category;
import com.jeju.category.domain.Category2;
import com.jeju.pension.domain.Pension;
import com.jeju.pension.store.PensionStore;
import com.jeju.room.domain.Room;
import com.jeju.room.domain.RoomAttach;

@Service
public class PensionServiceImpl implements PensionService{
	@Autowired
	private PensionStore pStore;
	@Autowired
	private SqlSession session;

	@Override
	public List<Pension> selectAllPension() {
		List<Pension> pList = pStore.selectAllPension(session);
		return pList;
	}

	@Override
	public List<Category2> selectCategory(Category2 category) {
		List<Category2> gList = pStore.selectCategory(session, category);
		return gList;
	}

	@Override
	public Pension selectCategoryFilter(String pensionNo) {
		Pension cList = pStore.selectCategoryFilter(session, pensionNo);
		return cList;
	}

	@Override
	public List<Pension> selectReviewRank() {
		List<Pension> rList = pStore.selectReviewRank(session);
		return rList;
	}


	@Override
	public List<Pension> selectPensionRank(Pension pensionNo) {
		List<Pension> rList = pStore.selectPensionRank(session, pensionNo);
		return rList;
	}

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
