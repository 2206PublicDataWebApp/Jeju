package com.jeju.pension.store;

import org.mybatis.spring.SqlSessionTemplate;

import com.jeju.category.domain.Category;
import com.jeju.pension.domain.Pension;
import com.jeju.room.domain.Room;
import com.jeju.room.domain.RoomAttach;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jeju.category.domain.Category2;
import com.jeju.pension.domain.Pension;
import com.jeju.review.domain.Review;

public interface PensionStore {

	// 숙소 번호 가져오기
	int selectPensionNo(SqlSession session, Pension pension);
	// 숙소 등록
	void insertPension(SqlSession session, Pension pension);
	// 객실 번호 가져오기
	int selectRoomNo(SqlSession session, Room room);
	// 객실 등록
	void insertRoom(SqlSession session, Room room);
	// 객실 이미지 등록
	void insertRoomAttach(SqlSession session, RoomAttach roomAttach);
	// 카테고리 등록
	void insertCategory(SqlSession session, Category category);
	
	List<Pension> selectAllPension(SqlSession session);

	List<Category2> selectCategory(SqlSession session, Category2 category);

	Pension selectCategoryFilter(SqlSession session, String pensionNo);

	List<Pension> selectReviewRank(SqlSession session);

	List<Pension> selectPensionRank(SqlSession session, Pension pensionNo);
	// 숙소 상세페이지
	Pension selectOnePension(SqlSession session, Integer pensionNo);
	// 숙소 카테고리 가져오기
//	Category selectPensionCategory(SqlSession session, Integer pensionNo);
	// 숙소 이름 중복체크
	int checkPensionName(SqlSession session, String pensionName);
	// 객실 가져오기
	List<String> selectRoomAttach(SqlSession session, Integer pensionNo);
	// 객실 번호 가져오기 (객실 이미지 가져오기위한 번호)
//	List<Integer> selectRoomAttachNo(SqlSession session, Integer pensionNo);
	// 카테고리 가져오기
	List<Category> selectCategoryCheck(SqlSession session, Integer pensionNo);

	List<Pension> selectDate(SqlSession session, long diffDays);

	List<Pension> selectPrice(SqlSession session);
	
	List<Room> selectRoom(SqlSession session, Integer pensionNo);
	// 리뷰 전부 가져오기
	List<Review> selectAllReview(SqlSession session, Integer pensionNo);

}
