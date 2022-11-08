package com.jeju.chat.store;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.jeju.chat.domain.Chat;

public class ChatStoreLogic {
	// 공지사항 전부 가져오기
		@Override
		public List<Chat> selectAllChat(SqlSessionTemplate session, int currentPage, int boardLimit) {
			int offset = (currentPage - 1) * boardLimit;
			RowBounds rowBounds = new RowBounds(offset, boardLimit);
			List<Chat> cList = session.selectList("ChatMapper.selectAllChat", null, rowBounds);
			return cList;
		}

		// 공지사항 하나 가져오기
		@Override
		public Notice selectOneChat(SqlSessionTemplate session, Integer chatNo) {
			Chat chat = session.selectOne("ChatMapper.selectOneChat", chatNo);
			return chat;
		}

}
