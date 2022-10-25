package com.jeju.member.store;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jeju.member.domain.Member;
import com.jeju.member.store.MemberStore;

@Repository
public class MemberStoreLogic implements MemberStore{

	@Override
	public Member selectLoginMember(SqlSession session, Member member) {
		System.out.println("ddd");
		Member mOne = session.selectOne("MemberMapper.selectLoginOne", member);
		return mOne;
	}

	@Override
	public Member selectOneById(SqlSession session, String memberId) {
		Member member = session.selectOne("MemberMapper.selectOneById", memberId);
		return member;
	}

	@Override
	public int checkDupId(SqlSession session, String memberId) {
		int result = session.selectOne("MemberMapper.checkIdDuplicate", memberId);
		return result;
	}

	@Override
	public int insertMember(SqlSession session, Member member) {
		System.out.println("주의 이름을");
		int result = session.insert("MemberMapper.insertMember", member);
		return result;
	}

	@Override
	public int updateMember(SqlSession session, Member member) {
		int result = session.update("MemberMapper.updateMember", member);
		return result;
	}

	@Override
	public int deleteMember(SqlSession session, String memberId) {
//		int result = session.delete("MemberMapper.deleteMember", memberId);
		int result = session.update("MemberMapper.deleteMember", memberId);
		return result;
	}

}
