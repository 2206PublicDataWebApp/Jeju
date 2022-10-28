package com.jeju.jjim.store;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jeju.jjim.domain.Jjim;
import com.jeju.pension.domain.Pension;

@Repository
public class JjimStoreLogic implements JjimStore{

	// 찜 여부 조회
	@Override
	public int selectJjimCount(SqlSession session, Jjim jjim) {
		int jjimCount = session.selectOne("JjimMapper.selectJjimCount", jjim);
		return jjimCount;
	}
	// 찜 등록
	@Override
	public void insertJjim(SqlSession session, Jjim jjim) {
		session.insert("JjimMapper.insertJjim", jjim);
	}
	// PENSION_TBL에 찜 +1
	@Override
	public void updateJjimCount(SqlSession session, Integer pensionNo) {
		session.update("PensionMapper.updateJjimCount", pensionNo);
	}
	// 찜 삭제
	@Override
	public void deleteJjim(SqlSession session, Jjim jjim) {
		session.delete("JjimMapper.deleteJjim", jjim);
	}
	// PENSION_TBL에 찜 -1
	@Override
	public void deleteJjimCount(SqlSession session, Integer pensionNo) {
		session.update("PensionMapper.deleteJjimCount", pensionNo);
	}
	@Override
	public int selectPensionCount(SqlSession session, String memberId) {
		int result = session.selectOne("PensionMapper.selectPensionCount", memberId);
		return result;
	}
	@Override
	public List<Pension> selectJjimPension(SqlSession session, String memberId, int currentPage, int boardLimit) {
		int offset = (currentPage - 1) * boardLimit;
		RowBounds rowBounds = new RowBounds(offset, boardLimit);
		List<Pension> pList = session.selectList("PensionMapper.selectJjimPension",memberId, rowBounds);
		return pList;
	}

}
