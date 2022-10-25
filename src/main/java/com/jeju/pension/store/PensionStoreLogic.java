package com.jeju.pension.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jeju.category.domain.Category2;
import com.jeju.pension.domain.Pension;
import com.jeju.review.domain.Review;

@Repository
public class PensionStoreLogic implements PensionStore{

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
	public List<Pension> selectReviewRank(SqlSession session) {
		System.out.println("�ù�");
		List<Pension> rList = session.selectList("ReviewMapper.selectReviewRank");
		return rList;
	}

	@Override
	public List<Pension> selectPensionRank(SqlSession session, Pension pensionNo) {
		List<Pension> rList = session.selectOne("PensionMapper.selectPensionRank", pensionNo);
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
	
	


}
