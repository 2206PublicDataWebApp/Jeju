package com.jeju.pension.service;

import com.jeju.category.domain.Category;
import com.jeju.pension.domain.Pension;
import com.jeju.room.domain.Room;
import com.jeju.room.domain.RoomAttach;

public interface PensionService {

	// 숙소 번호 가져오기
	int selectePensionNo(Pension pension);
	// 숙소 등록
	void registerPension(Pension pension);
	// 객실 번호 가져오기
	int selecteRoomNo(Room room);
	// 객실 등록
	void registerRoom(Room room);
	// 객실 이미지 등록
	void registerRoomAttach(RoomAttach roomAttach);
	// 카테고리 등록
	void registerCategory(Category category);

}
