package com.jeju.chat.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.jeju.chat.domain.Chat;


public interface ChatStore {
	// 공지사항 전부 가져오기
	List<Chat> selectAllChat(SqlSessionTemplate session, int currentPage, int boardLimit);
	// 공지사항 하나 가져오기
	Chat selectOneChat(SqlSessionTemplate session, Integer noticeChat);

}
