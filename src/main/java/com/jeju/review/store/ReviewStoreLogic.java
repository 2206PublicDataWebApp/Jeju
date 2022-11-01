package com.jeju.review.store;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jeju.pension.domain.Pension;
import com.jeju.review.domain.Review;

@Repository
public class ReviewStoreLogic implements ReviewStore{

	// 해당 아이디 후기 총 갯수 가져오기
	@Override
	public int selectRivewCount(SqlSession session, String memberId) {
		int result = session.selectOne("ReviewMapper.selectReviewCount", memberId);
		return result;
	}
	// 해당 아이디 후기 전부 가져오기
	@Override
	public List<Review> selectReview(SqlSession session, String memberId, int currentPage, int boardLimit) {
		int offset = (currentPage - 1) * boardLimit;
		RowBounds rowBounds = new RowBounds(offset, boardLimit);
		List<Review> rList = session.selectList("ReviewMapper.selectReview", memberId, rowBounds);
		return rList;
	}

	@Override
	public List<Review> showAllReview(SqlSession session) {
		List<Review> reviewList = session.selectList("ReviewMapper.adminShowAllReview");
		return reviewList;
	}

}
