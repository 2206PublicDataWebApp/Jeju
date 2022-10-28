package com.jeju.jjim.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.jjim.domain.Jjim;
import com.jeju.jjim.store.JjimStore;
import com.jeju.pension.domain.Pension;

@Service
public class JjimServiceImpl implements JjimService{

	@Autowired
	private JjimStore jStore;
	@Autowired
	private SqlSession session;
	
	// 찜 여부 조회
	@Override
	public int jjimCount(Jjim jjim) {
		int jjimCount = jStore.selectJjimCount(session, jjim);
		return jjimCount;
	}
	// 찜 등록
	@Override
	public void registerJjim(Jjim jjim) {
		jStore.insertJjim(session, jjim);
	}
	// PENSION_TBL에 찜 + 1
	@Override
	public void modifyJjimCount(Integer pensionNo) {
		jStore.updateJjimCount(session, pensionNo);
	}
	// 찜 삭제
	@Override
	public void removeJjim(Jjim jjim) {
		jStore.deleteJjim(session, jjim);
	}
	// PENSION_TBL에 찜 - 1
	@Override
	public void removeJjimCount(Integer pensionNo) {
		jStore.deleteJjimCount(session, pensionNo);
	}
	@Override
	public int getTotalCount(String memberId) {
		int result = jStore.selectPensionCount(session, memberId);
		return result;
	}
	@Override
	public List<Pension> printJjimPension(String memberId, int currentPage, int boardLimit) {
		List<Pension> pList = jStore.selectJjimPension(session, memberId, currentPage, boardLimit);
		return pList;
	}
}
