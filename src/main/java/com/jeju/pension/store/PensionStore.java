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

	List<Review> selectReviewRank(SqlSession session);

	Pension selectPensionRank(SqlSession session, Integer pensionNo);
	// 숙소 상세페이지
	Pension selectOnePension(SqlSession session, Integer pensionNo);
	// 숙소 이름 중복체크
	int checkPensionName(SqlSession session, String pensionName);
	// 객실 가져오기
	List<String> selectRoomAttach(SqlSession session, Integer pensionNo);
	// 카테고리 가져오기
	List<Category> selectCategoryCheck(SqlSession session, Integer pensionNo);

	List<Pension> selectDate(SqlSession session, long diffDays);

	List<Pension> selectPrice(SqlSession session);
	//낮은가격 정렬
	List<Pension> ascPriceSort(SqlSession session);
	//날짜 필터링시 내림차순 정렬
	List<Pension> descPriceSort(SqlSession session);


	List<Room> selectRoom(SqlSession session, Integer pensionNo);
	// 리뷰 전부 가져오기
	List<Review> selectAllReview(SqlSession session, Integer pensionNo);
	// 마이페이지 회원이 등록한 펜션 갯수 가져오기
	int selectPensionCount(SqlSession session, String memberId);
	// 마이페이지 회원이 등록한 펜션 전부 가져오기
	List<Pension> selectMyPension(SqlSession session, String memberId, int currentPage, int boardLimit);
	// 숙소 수정
	void updatePension(SqlSession session, Pension pension);
	// 객실 수정
	void updateRoom(SqlSession session, Room room);
	// 객실 사진 수정
	void updateRoomAttach(SqlSession session, RoomAttach roomAttach);
	// 숙소 카테고리 수정
	void updateCategory(SqlSession session, Category category);
	// 숙소 최저가 업데이트
	void updatePensionPrice(SqlSession session, Room room);
	// 숙소 삭제
	void deletePension(SqlSession session, Integer pensionNo);
	List<Pension> searchPensionName(SqlSession session, String pensionName);
	//모든 펜션 조회
	List<Pension> priceSet(SqlSession session);

	// 관리자페이지 전체 펜션목록 조회
	List<Pension> showAllPension(SqlSession session);

	// 관리자 펜션 삭제
	void removeAdminPension(SqlSession session, Integer pensionNo);
	// 임시
	List<String> printAttach(SqlSession session, Integer roomNo);
}
