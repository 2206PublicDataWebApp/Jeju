package com.jeju.pension.store;

import org.mybatis.spring.SqlSessionTemplate;

import com.jeju.category.domain.Category;
import com.jeju.pension.domain.Pension;
import com.jeju.room.domain.Room;
import com.jeju.room.domain.RoomAttach;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jeju.category.domain.Category2;
import com.jeju.pension.domain.Pension;
import com.jeju.review.domain.Review;

public interface PensionStore {

	// 숙소 번호 가져오기
	int selectPensionNo(SqlSessionTemplate session, Pension pension);
	// 숙소 등록
	void insertPension(SqlSessionTemplate session, Pension pension);
	// 객실 번호 가져오기
	int selectRoomNo(SqlSessionTemplate session, Room room);
	// 객실 등록
	void insertRoom(SqlSessionTemplate session, Room room);
	// 객실 이미지 등록
	void insertRoomAttach(SqlSessionTemplate session, RoomAttach roomAttach);
	// 카테고리 등록
	void insertCategory(SqlSessionTemplate session, Category category);
	List<Pension> selectAllPension(SqlSession session);

	List<Category2> selectCategory(SqlSession session, Category2 category);

	Pension selectCategoryFilter(SqlSession session, String pensionNo);

	List<Pension> selectReviewRank(SqlSession session);

	List<Pension> selectPensionRank(SqlSession session, Pension pensionNo);

}
