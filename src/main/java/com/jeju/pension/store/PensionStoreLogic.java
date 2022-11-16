package com.jeju.pension.store;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
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
	// 숙소 이름 중복체크
	@Override
	public int checkPensionName(SqlSession session, String pensionName) {
		int result = session.selectOne("PensionMapper.selectPensionName", pensionName);
		return result;
	}
	// 객실 가져오기
	@Override
	public List<String> selectRoomAttach(SqlSession session, Integer pensionNo) {
		List<String> roomAttach = session.selectList("RoomMapper.selectRoomAttach", pensionNo);
		return roomAttach;
	}
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


	@Override
	public List<Room> selectRoom(SqlSession session, Integer pensionNo) {
		List<Room> rList = session.selectList("RoomMapper.selectRoomAll", pensionNo);
		return rList;
	}
	
	
	// 리뷰 전부 가져오기
	@Override
	public List<Review> selectAllReview(SqlSession session, Integer pensionNo) {
		List<Review> reviewList = session.selectList("ReviewMapper.selectAllReview", pensionNo);
		return reviewList;
	}
	// 마이페이지 회원이 등록한 펜션 갯수 가져오기
	@Override
	public int selectPensionCount(SqlSession session, String memberId) {
		int result = session.selectOne("PensionMapper.selectPensionCount", memberId);
		return result;
	}
	// 마이페이지 회원이 등록한 펜션 전부 가져오기
	@Override
	public List<Pension> selectMyPension(SqlSession session, String memberId, int currentPage, int boardLimit) {
		int offset = (currentPage - 1) * boardLimit;
		RowBounds rowBounds = new RowBounds(offset, boardLimit);
		List<Pension> pList = session.selectList("PensionMapper.selectMyPension",memberId, rowBounds);
		return pList;
	}
	// 숙소 수정
	@Override
	public void updatePension(SqlSession session, Pension pension) {
		session.update("PensionMapper.updatePension", pension);
	}
	// 객실 수정
	@Override
	public void updateRoom(SqlSession session, Room room) {
		session.update("RoomMapper.updateRoom", room);
	}
	// 객실 사진 수정
	@Override
	public void updateRoomAttach(SqlSession session, RoomAttach roomAttach) {
		session.update("RoomAttachMapper.updateRoomAttach", roomAttach);
	}
	// 숙소 카테고리 수정
	@Override
	public void updateCategory(SqlSession session, Category category) {
		session.update("CategoryMapper.updateCategory", category);
	}
	// 숙소 최저가 업데이트
	@Override
	public void updatePensionPrice(SqlSession session, Room room) {
		session.update("PensionMapper.updatePensionPrice", room);
	}
	// 숙소 삭제
	@Override
	public void deletePension(SqlSession session, Integer pensionNo) {
		session.delete("PensionMapper.deletePension", pensionNo);
	}

	// 관리자페이지 전체 펜션목록 조회
	@Override
	public List<Pension> showAllPension(SqlSession session) {
		List<Pension> pensionList = session.selectList("PensionMapper.adminShowAllPension");
		return pensionList;
	}

	// 관리자 펜션 삭제
	@Override
	public void removeAdminPension(SqlSession session, Integer pensionNo) {
		session.delete("PensionMapper.deleteAdminPension", pensionNo);
	}

	@Override
	public List<Pension> searchPensionName(SqlSession session, String pensionName) {
		List<Pension> pList = session.selectList("PensionMapper.searchPensionName", pensionName);
		return pList;
	}
	//모든 펜션 조회(카테고리체크하지 않았을때 가격 설정 조회)
	@Override
	public List<Pension> priceSet(SqlSession session) {
		List<Pension> pList = session.selectList("PensionMapper.selectAllPension");
		return pList;
	}
	//임시
	@Override
	public List<String> printAttach(SqlSession session, Integer roomNo) {
		List<String> roomAttach = session.selectList("RoomAttachMapper.selectAttach",roomNo);
		return roomAttach;
	}

	// 관리자 페이징용 모든 숙소 조회
	@Override
	public List<Pension> pagingShowAllMember(SqlSession session, int currentPage, int pensionLimit) {
		int offset = (currentPage - 1) * pensionLimit;
		RowBounds rowBounds = new RowBounds(offset, pensionLimit);
		List<Pension> pensionList = session.selectList("PensionMapper.pagingShowAllPension", null, rowBounds);
		return pensionList;
	}


}
