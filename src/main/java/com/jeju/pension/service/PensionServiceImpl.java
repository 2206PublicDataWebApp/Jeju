package com.jeju.pension.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.category.domain.Category;
import com.jeju.category.domain.Category2;
import com.jeju.pension.domain.Pension;
import com.jeju.pension.store.PensionStore;
import com.jeju.review.domain.Review;
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
	public List<Review> selectReviewRank() {
		List<Review> rList = pStore.selectReviewRank(session);
		return rList;
	}


	@Override
	public Pension selectPensionRank(Integer pensionNo) {
		Pension rList = pStore.selectPensionRank(session, pensionNo);
		return rList;
	}
	@Override
   public List<Pension> selectDate(long diffDays) {
      List<Pension> rList = pStore.selectDate(session, diffDays);
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
	// 객실 등록
	@Override
	public void registerRoom(Room room) {
		pStore.insertRoom(session, room);
	}
	// 객실 번호 가져오기
		@Override
		public int selecteRoomNo(Room room) {
			int roomNo = pStore.selectRoomNo(session, room);
			return roomNo;
		}
		
	@Override
	public List<Pension> selectPrice() {
		List<Pension> priceList = pStore.selectPrice(session);
		return priceList;
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

	// 숙소 상세페이지
	@Override
	public Pension selecteOnePension(Integer pensionNo) {
		Pension pension = pStore.selectOnePension(session, pensionNo);
		return pension;
	}
	// 숙소 카테고리 가져오기
//	@Override
//	public Category selectPensionCategory(Integer pensionNo) {
//		Category category = pStore.selectPensionCategory(session, pensionNo);
//		return category;
//	}
	// 숙소 이름 중복체크
	@Override
	public int checkPensionName(String pensionName) {
		int result = pStore.checkPensionName(session, pensionName);
		return result;
	}
	// 객실 가져오기
	@Override
	public List<String> selecteRoomAttach(Integer pensionNo) {
		List<String> roomAttack = pStore.selectRoomAttach(session, pensionNo);
		return roomAttack;
	}
	// 객실 번호 가져오기 (객실 이미지 가져오기위한 번호)
//	@Override
//	public List<Integer> selecteRoomAttachNo(Integer pensionNo) {
//		List<Integer> roomNo = pStore.selectRoomAttachNo(session, pensionNo);
//		return roomNo;
//	}
	// 카테고리 가져오기
	@Override
	public List<Category> selectCategoryCheck(Integer pensionNo) {
		List<Category> category = pStore.selectCategoryCheck(session, pensionNo);
		return category;
	}
	// 객실 가져오기
	@Override
	public List<Room> selecteRoom(Integer pensionNo) {
		List<Room> rList = pStore.selectRoom(session, pensionNo);
		return rList;
	}
	
	// 리뷰 전부 가져오기
	@Override
	public List<Review> selectAllReview(Integer pensionNo) {
		List<Review> reviewList = pStore.selectAllReview(session, pensionNo);
		return reviewList;
	}

	//낮은가격순 정렬
	@Override
	public List<Pension> ascPriceSort() {
		List<Pension> priceList = pStore.ascPriceSort(session);
		return priceList;
	}

	@Override
	public List<Pension> DescPriceSort() {
		List<Pension> priceList = pStore.descPriceSort(session);
		return priceList;
	}

	// 관리자페이지 전체 펜션목록 조회
	@Override
	public List<Pension> showAllPension() {
		List<Pension> pensionList = pStore.showAllPension(session);
		return pensionList;
}
	// 마이페이지 회원이 등록한 펜션 갯수 가져오기
	@Override
	public int getTotalCount(String memberId) {
		int result = pStore.selectPensionCount(session, memberId);
		return result;
	}
	// 마이페이지 회원이 등록한 펜션 전부 가져오기
	@Override
	public List<Pension> printMyPension(String memberId, int currentPage, int boardLimit) {
		List<Pension> pList = pStore.selectMyPension(session, memberId, currentPage, boardLimit);
		return pList;
	}
	// 숙소 수정
	@Override
	public void modifyPension(Pension pension) {
		pStore.updatePension(session, pension);
	}
	// 객실 수정
	@Override
	public void modifyRoom(Room room) {
		pStore.updateRoom(session, room);
	}
	// 객실 사진 수정
	@Override
	public void modifyRoomAttach(RoomAttach roomAttach) {
		pStore.updateRoomAttach(session, roomAttach);
	}
	// 숙소 카테고리 수정
	@Override
	public void modifyCategory(Category category) {
		pStore.updateCategory(session, category);
	}
	// 숙소 최저가 업데이트
	@Override
	public void modifyPensionPrice(Room room) {
		pStore.updatePensionPrice(session, room);
	}
	// 숙소 삭제
	@Override
	public void removePension(Integer pensionNo) {
		pStore.deletePension(session, pensionNo);
	}
	@Override
	public List<Pension> searchPensionTitle(String pensionName) {
		List<Pension> pList = pStore.searchPensionName(session, pensionName);
		return pList;
	}
	//모든 펜션 조회
	@Override
	public List<Pension> priceSet() {
		List<Pension> pList = pStore.priceSet(session);
		return pList;
	}

	// 관리자 펜션 삭제
	@Override
	public void removeAdminPension(Integer pensionNo) {
		pStore.removeAdminPension(session, pensionNo);
	}
	//임시
	@Override
	public List<String> printAttach(Integer roomNo) {
		List<String> roomAttach = pStore.printAttach(session, roomNo);
		return roomAttach;
	}

	// 관리자 페이징용 모든 숙소 조회
	@Override
	public List<Pension> pagingShowAllPension(int currentPage, int pensionLimit) {
		List<Pension> pensionList = pStore.pagingShowAllMember(session, currentPage, pensionLimit);
		return pensionList;
	}


}
