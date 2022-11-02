package com.jeju.jjim.service;

import java.util.List;

import com.jeju.jjim.domain.Jjim;
import com.jeju.pension.domain.Pension;

public interface JjimService {
	
	// 찜 여부 조회
	int jjimCount(Jjim jjim);
	// 찜 등록
	void registerJjim(Jjim jjim);
	// PENSION_TBL에 찜 + 1
	void modifyJjimCount(Integer pensionNo);
	// 찜 삭제
	void removeJjim(Jjim jjim);
	// PENSION_TBL에 찜 - 1
	void removeJjimCount(Integer pensionNo);
	// 찜 총 갯수 가져오기(페이징 처리)
	int getTotalCount(String memberId);
	// 찜 한 숙소 전부 가져오기
	List<Pension> printJjimPension(String memberId, int currentPage, int boardLimit);
	
}
