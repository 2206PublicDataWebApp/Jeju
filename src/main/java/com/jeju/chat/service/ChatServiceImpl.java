package com.jeju.chat.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.chat.domain.Chat;
import com.jeju.chat.store.ChatStore;



public class ChatServiceImpl implements ChatService{

	@Autowired
	private SqlSessionTemplate session;
	
	@Autowired
	private ChatStore cStore;
	
	//채팅 전부 불러오기
		@Override
		public List<Chat> printAllChat(int currentPage, int boardLimit) {
			List<Chat> cList = cStore.selectAllChat(session,currentPage, boardLimit);
			return cList;
		}

		// 공지사항 하나 가져오기
		@Override
		public Notice selectOneChat(Integer chatNo) {
			Chat chat = cStore.selectOneChat(session, chatNo);
			return chat;
		}
}