package com.jeju.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.member.domain.Member;
import com.jeju.member.service.MemberService;
import com.jeju.member.store.MemberStore;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private SqlSessionTemplate session;
	@Autowired
	private MemberStore mStore;

	@Override
	public Member loginMember(Member member) {
		Member mOne 
		= mStore.selectLoginMember(session, member);
		return mOne;
	}

	@Override
	public int checkDupId(String memberId) {
		int result = mStore.checkDupId(session, memberId);
		return result;
	}

	@Override
	public Member printOneById(String memberId) {
		Member member = mStore.selectOneById(session, memberId);
		return member;
	}

	@Override
	public int registerMember(Member member) {
		System.out.println("왜안돼시");
		// SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = mStore.insertMember(session, member);
		return result;
	}

	@Override
	public int modifyMember(Member member) {
		int result = mStore.updateMember(session, member);
		return result;
	}

	@Override
	public int removeMember(String memberId) {
		int result 
		= mStore.deleteMember(session
				, memberId);
		return result;
	}

}
