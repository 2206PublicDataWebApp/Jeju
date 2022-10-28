package com.jeju.pension.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jeju.category.domain.Category;
import com.jeju.category.domain.Category2;
import com.jeju.pension.domain.Pension;
import com.jeju.review.domain.Review;
import com.jeju.room.domain.Room;
import com.jeju.room.domain.RoomAttach;

@Repository
public class PensionStoreLogic implements PensionStore{

	// 숙소 번호 가져오기
	@Override
	public int selectPensionNo(SqlSession session, Pension pension) {
		int pensionNo = session.selectOne("PensionMapper.selectPensionNo", pension);
		return pensionNo;
	}
	// 숙소 등록
	@Override
	public void insertPension(SqlSession session, Pension pension) {
		System.out.println("ddddd");
		session.insert("PensionMapper.insertPension", pension);
	}
	// 객실 번호 가져오기
	@Override
	public int selectRoomNo(SqlSession session, Room room) {
		int roomNo = session.selectOne("RoomMapper.selectRoomNo", room);
		return roomNo;
	}
	// 객실 등록
	@Override
	public void insertRoom(SqlSession session, Room room) {
		session.insert("RoomMapper.insertRoom",room);
	}
	// 객실 이미지 등록
	@Override
	public void insertRoomAttach(SqlSession session, RoomAttach roomAttach) {
		session.insert("RoomAttachMapper.insertRoomAttach",roomAttach);
	}
	// 카테고리 등록
	@Override
	public void insertCategory(SqlSession session, Category category) {
		session.insert("CategoryMapper.insertCategory", category);
	}


	@Override
	public List<Pension> selectAllPension(SqlSession session) {
		List<Pension> pList = session.selectList("PensionMapper.selectAllPension");
		return pList;
	}

	@Override
	public List<Category2> selectCategory(SqlSession session, Category2 category) {	
		List<Category2> gList = session.selectList("PensionMapper.selectCategory", category);
		return gList;
	}

	@Override
	public Pension selectCategoryFilter(SqlSession session, String pensionNo) {
		Pension cList = session.selectOne("PensionMapper.selectCategoryFilter", pensionNo);
		return cList;
	}

	@Override
	public List<Review> selectReviewRank(SqlSession session) {
		List<Review> rList = session.selectList("ReviewMapper.selectReviewRank");
		return rList;
	}

	@Override
	public Pension selectPensionRank(SqlSession session, Integer pensionNo) {
		Pension rList = session.selectOne("PensionMapper.selectPensionRank", pensionNo);
		return rList;
	}

	@Override
	public List<Pension> selectDate(SqlSession session, long diffDays) {
		List<Pension> rList = session.selectList("PensionMapper.selectDate", diffDays);
		return rList;
	}

	@Override
	public List<Pension> selectPrice(SqlSession session) {
		List<Pension> priceList = session.selectList("PensionMapper.selectPrice");
		return priceList;
	}

	// 숙소 상세페이지
	@Override
	public Pension selectOnePension(SqlSession session, Integer pensionNo) {
		Pension pension = session.selectOne("PensionMapper.selectPension", pensionNo);
		return pension;
	}
	// 숙소 카테고리 가져오기
//	@Override
//	public Category selectPensionCategory(SqlSession session, Integer pensionNo) {
//		Category category= session.selectOne("CategoryMapper.selectPensionCategory", pensionNo);
//		return category;
//	}
	// 숙소 이름 중복체크
	@Override
	public int checkPensionName(SqlSession session, String pensionName) {
		int result = session.selectOne("PensionMapper.selectPensionName", pensionName);
		return result;
	}
	// 객실 가져오기
	@Override
	public List<Room> selectRoom(SqlSession session, Integer pensionNo) {
		List<Room> rList = session.selectList("RoomMapper.selectRoom", pensionNo);
		return rList;
	}
	// 객실 번호 가져오기 (객실 이미지 가져오기위한 번호)
//	@Override
//	public List<Integer> selectRoomAttachNo(SqlSession session, Integer pensionNo) {
//		List<Integer> roomNo = session.selectOne("RoomMapper.selectRoomAttachNo", pensionNo);
//		return roomNo;
//	}
	// 카테고리 가져오기
	@Override
	public List<Category> selectCategoryCheck(SqlSession session, Integer pensionNo) {
		List<Category> category = session.selectList("CategoryMapper.selectCategory", pensionNo);
		return category;
	}
	@Override
	public List<Pension> ascPriceSort(SqlSession session) {
		List<Pension> apList = session.selectList("PensionMapper.ascPriceSort");
		return apList;
	}
	@Override
	public List<Pension> descPriceSort(SqlSession session) {
		List<Pension> apList = session.selectList("PensionMapper.descPriceSort");
		return apList;
	}





}
