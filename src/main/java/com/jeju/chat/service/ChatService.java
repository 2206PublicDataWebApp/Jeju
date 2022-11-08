package com.jeju.chat.service;

import java.util.List;

import com.jeju.chat.domain.Chat;
import com.jeju.member.domain.Member;
import com.jeju.notice.domain.Notice;
public interface ChatService {

	// 채팅 다 가져오기
		public List<Chat> printAllCha(String roomTitle);
		
	// 채팅하나 가져오기
		Notice selectOneChat(Integer noticeNo);
		int getTotalCount();
}
