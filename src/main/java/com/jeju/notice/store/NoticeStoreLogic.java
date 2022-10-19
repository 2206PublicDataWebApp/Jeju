package com.jeju.notice.store;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.jeju.notice.domain.Notice;

@Repository
public class NoticeStoreLogic implements NoticeStore{

	//공지사항 등록
	@Override
	public void insertNotice(SqlSessionTemplate session, Notice notice) {
		session.insert("NoticeMapper.insertNotice",notice);
	}

	// 공지사항 총 갯수 출력(페이징처리)
	@Override
	public int selectTotalCount(SqlSessionTemplate session) {
		int result = session.selectOne("NoticeMapper.selectTotalCount");
		return result;
	}

	// 공지사항 전부 가져오기
	@Override
	public List<Notice> selectAllNotice(SqlSessionTemplate session, int currentPage, int boardLimit) {
		int offset = (currentPage - 1) * boardLimit;
		RowBounds rowBounds = new RowBounds(offset, boardLimit);
		List<Notice> nList = session.selectList("NoticeMapper.selectAllNotice", null, rowBounds);
		return nList;
	}

	// 공지사항 하나 가져오기
	@Override
	public Notice selectOneNo(SqlSessionTemplate session, Integer noticeNo) {
		Notice notice = session.selectOne("NoticeMapper.selectOneNo", noticeNo);
		return notice;
	}

	// 공지사항 수정
	@Override
	public int updateNotice(SqlSessionTemplate session, Notice notice) {
		int result = session.update("NoticeMapper.updateNotice", notice);
		return result;
	}

	// 공지사항 삭제
	@Override
	public void deleteNotice(SqlSessionTemplate session, int noticeNo) {
		session.delete("NoticeMapper.deleteNotice", noticeNo);
	}

}
