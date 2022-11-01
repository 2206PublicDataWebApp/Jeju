package com.jeju.pension.service;

import com.jeju.category.domain.Category;
import com.jeju.pension.domain.Pension;
import com.jeju.room.domain.Room;
import com.jeju.room.domain.RoomAttach;

import java.util.ArrayList;
import java.util.List;

import com.jeju.category.domain.Category2;
import com.jeju.pension.domain.Pension;
import com.jeju.review.domain.Review;

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
	
	List<Pension> selectAllPension();

	List<Category2> selectCategory(Category2 category);

	Pension selectCategoryFilter(String pensionNo);

	List<Review> selectReviewRank();

	Pension selectPensionRank(Integer pensionNo);
	//숙소 상세페이지
	Pension selecteOnePension(Integer pensionNo);
	// 숙소 카테고리 가져오기
//	Category selectPensionCategory(Integer pensionNo);
	// 숙소 이름 중복체크
	int checkPensionName(String pensionName);
	// 객실 가져오기
	List<Room> selecteRoom(Integer pensionNo);

	List<String> selecteRoomAttach(Integer pensionNo);
	// 객실 번호 가져오기 (객실 이미지 가져오기위한 번호)
//	List<Integer> selecteRoomAttachNo(Integer pensionNo);
	// 카테고리 가져오기
	List<Category> selectCategoryCheck(Integer pensionNo);
	//날짜 조회용
	List<Pension> selectDate(long diffDays);
	//가격 조회용
	List<Pension> selectPrice();
	//카테고리 인기순 정렬
	List<Pension> ascPriceSort();
	//날짜만 필터링했을때 내림차순 정렬
	List<Pension> DescPriceSort();

	// 리뷰 전부 불러오기
	List<Review> selectAllReview(Integer pensionNo);
	//펜션 제목 검색
	List<Pension> searchPensionTitle(String pensionName);
	//모든 펜션 조회
	List<Pension> priceSet();


}
