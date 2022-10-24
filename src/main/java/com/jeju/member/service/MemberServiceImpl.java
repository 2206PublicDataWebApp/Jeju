package com.jeju.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.member.store.MemberStore;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private SqlSessionTemplate session;
	
	@Autowired
	private MemberStore mStore;
}
