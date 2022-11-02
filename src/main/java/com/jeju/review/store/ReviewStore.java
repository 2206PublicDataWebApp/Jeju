package com.jeju.review.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jeju.pension.domain.Pension;
import com.jeju.review.domain.Review;

public interface ReviewStore {

	/// 해당 아이디 후기 총 갯수 가져오기
	int selectRivewCount(SqlSession session, String memberId);
	// 해당 아이디 후기 전부 가져오기
	List<Review> selectReview(SqlSession session, String memberId, int currentPage, int boardLimit);
	// 리뷰 수정
	void updateReview(SqlSession session, Review review);
	// 리뷰 삭제
	void deleteReview(SqlSession session, Integer reviewNo);

}
