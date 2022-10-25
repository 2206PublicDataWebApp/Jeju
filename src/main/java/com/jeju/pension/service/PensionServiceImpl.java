package com.jeju.pension.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.category.domain.Category2;
import com.jeju.pension.domain.Pension;
import com.jeju.pension.store.PensionStore;
import com.jeju.review.domain.Review;

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
	public List<Pension> selectReviewRank() {
		List<Pension> rList = pStore.selectReviewRank(session);
		return rList;
	}


	@Override
	public List<Pension> selectPensionRank(Pension pensionNo) {
		List<Pension> rList = pStore.selectPensionRank(session, pensionNo);
		return rList;
	}

	@Override
	public List<Pension> selectDate(long diffDays) {
		List<Pension> rList = pStore.selectDate(session, diffDays);
		return rList;
	}

	@Override
	public List<Pension> selectPrice() {
		List<Pension> priceList = pStore.selectPrice(session);
		return priceList;
	}

}
