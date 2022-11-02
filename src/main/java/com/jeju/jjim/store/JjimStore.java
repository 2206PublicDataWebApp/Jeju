package com.jeju.jjim.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jeju.jjim.domain.Jjim;
import com.jeju.pension.domain.Pension;

public interface JjimStore {

	// 찜 여부 조회
	int selectJjimCount(SqlSession session, Jjim jjim);
	// 찜 등록
	void insertJjim(SqlSession session, Jjim jjim);
	// PENSION_TBL에 찜 +1
	void updateJjimCount(SqlSession session, Integer pensionNo);
	// 찜 삭제
	void deleteJjim(SqlSession session, Jjim jjim);
	// PENSION_TBL에 찜 -1
	void deleteJjimCount(SqlSession session, Integer pensionNo);
	// 찜 한 숙소 갯수 가져오기
	int selectPensionCount(SqlSession session, String memberId);
	// 찜 한 숙소 전부 가져오기
	List<Pension> selectJjimPension(SqlSession session, String memberId, int currentPage, int boardLimit);

}
