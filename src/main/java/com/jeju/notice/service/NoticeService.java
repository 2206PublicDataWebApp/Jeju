package com.jeju.notice.service;

import java.util.List;

import com.jeju.notice.domain.Notice;

public interface NoticeService {
	// 공지사항 등록
	void registerNotice(Notice notice);
	// 공지사항 게시글 총 갯수 가져오기(페이징 처리)
	int getTotalCount();
	// 공지사항 다 가져오기
	List<Notice> printAllNotice(int currentPage, int boardLimit);
	// 공지사항 하나 가져오기
	Notice selectOneNo(Integer noticeNo);
	// 공지사항 수정
	int modifyNotice(Notice notice);
	// 공지사항 삭제
	void removeNotice(int noticeNo);
	// 공지사항 조회수
	void updateViewCount(Integer noticeNo);
		
}
