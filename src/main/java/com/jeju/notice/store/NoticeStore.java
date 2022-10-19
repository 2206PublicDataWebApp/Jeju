package com.jeju.notice.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.jeju.notice.domain.Notice;

public interface NoticeStore {
	// 공지사항 등록
	void insertNotice(SqlSessionTemplate session, Notice notice);
	// 공지사항 총 갯수 가져오기(페이징 처리)
	int selectTotalCount(SqlSessionTemplate session);
	// 공지사항 전부 가져오기
	List<Notice> selectAllNotice(SqlSessionTemplate session, int currentPage, int boardLimit);
	// 공지사항 하나 가져오기
	Notice selectOneNo(SqlSessionTemplate session, Integer noticeNo);
	// 공지사항 수정
	int updateNotice(SqlSessionTemplate session, Notice notice);
	// 공지사항 삭제
	void deleteNotice(SqlSessionTemplate session, int noticeNo);
	
}
