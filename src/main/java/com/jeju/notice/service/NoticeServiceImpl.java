package com.jeju.notice.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.notice.domain.Notice;
import com.jeju.notice.store.NoticeStore;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private SqlSessionTemplate session;
	
	@Autowired
	private NoticeStore nStore;
	
	//공지사항 등록
	@Override
	public void registerNotice(Notice notice) {
		nStore.insertNotice(session, notice);
	}

	// 공지사항 총 갯수 가져오기(페이징 처리)
	@Override
	public int getTotalCount() {
		int result = nStore.selectTotalCount(session);
		return result;
	}

	// 공지사항 전부 불러오기
	@Override
	public List<Notice> printAllNotice(int currentPage, int boardLimit) {
		List<Notice> nList = nStore.selectAllNotice(session,currentPage, boardLimit);
		return nList;
	}

	// 공지사항 하나 가져오기
	@Override
	public Notice selectOneNo(Integer noticeNo) {
		Notice notice = nStore.selectOneNo(session, noticeNo);
		return notice;
	}

	// 공지사항 수정
	@Override
	public void modifyNotice(Notice notice) {
		nStore.updateNotice(session, notice);
	}

	// 공지사항 삭제
	@Override
	public void removeNotice(int noticeNo) {
		nStore.deleteNotice(session, noticeNo);
	}
	// 공지사항 조회수
	@Override
	public void updateViewCount(Integer noticeNo) {
		nStore.updateViewCount(session, noticeNo);
	}

}
