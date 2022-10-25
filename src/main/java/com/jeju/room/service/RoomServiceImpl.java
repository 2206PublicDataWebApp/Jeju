package com.jeju.room.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.room.store.RoomStore;

@Service
public class RoomServiceImpl implements RoomService{
	@Autowired
	private RoomStore rStore;
	@Autowired
	private SqlSession session;
}
