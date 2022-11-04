package com.jeju.review.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.pension.domain.Pension;
import com.jeju.review.domain.Review;
import com.jeju.review.store.ReviewStore;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	private ReviewStore rStore;
	@Autowired
	private SqlSession session;
	
	// 해당 아이디 후기 총 갯수 가져오기
	@Override
	public int getTotalCount(String memberId) {
		int result = rStore.selectRivewCount(session, memberId);
		return result;
	}
	// 해당 아이디 후기 전부 가져오기
	@Override
	public List<Review> printReviewAll(String memberId, int currentPage, int boardLimit) {
		List<Review> rList = rStore.selectReview(session, memberId, currentPage, boardLimit);
		return rList;
	}
	// 리뷰 수정
	@Override
	public void modifyReview(Review review) {
		rStore.updateReview(session, review);
	}
	// 리뷰 삭제
	@Override
	public void removeReview(Integer reviewNo) {
		rStore.deleteReview(session, reviewNo);
	}

	// 관리자페이지 리뷰전체조회

	@Override
	public List<Review> showAllReview() {
		List<Review> reviewList = rStore.showAllReview(session);
		return reviewList;
	}

	// 관리자페이지 리뷰삭제
	@Override
	public void removeAdminReview(Integer reviewNo) {
		rStore.deleteAdminReview(session, reviewNo);
	}
	// 리뷰 등록
	@Override
	public void registerReview(Review review) {
		rStore.registerReview(session, review);
	}
	// 리뷰 등록시 RESERVATION_TBL REVIEW_CHECK +1
	@Override
	public void modifyReviewCheck(Review review) {
		rStore.updateReviewCheck(session, review);
	}
}
