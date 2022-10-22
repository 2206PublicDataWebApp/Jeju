package com.jeju.pension.service;

import java.util.List;

import com.jeju.category.domain.Category2;
import com.jeju.pension.domain.Pension;
import com.jeju.review.domain.Review;

public interface PensionService {

	List<Pension> selectAllPension();

	List<Category2> selectCategory(Category2 category);

	Pension selectCategoryFilter(String pensionNo);

	List<Pension> selectReviewRank();

	List<Pension> selectPensionRank(Pension pension);


}
