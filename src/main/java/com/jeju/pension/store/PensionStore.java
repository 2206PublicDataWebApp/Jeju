package com.jeju.pension.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jeju.category.domain.Category2;
import com.jeju.pension.domain.Pension;
import com.jeju.review.domain.Review;

public interface PensionStore {

	List<Pension> selectAllPension(SqlSession session);

	List<Category2> selectCategory(SqlSession session, Category2 category);

	Pension selectCategoryFilter(SqlSession session, String pensionNo);

	List<Pension> selectReviewRank(SqlSession session);

	List<Pension> selectPensionRank(SqlSession session, Pension pensionNo);

}
