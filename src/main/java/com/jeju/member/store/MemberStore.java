package com.jeju.member.store;



import org.apache.ibatis.session.SqlSession;

import com.jeju.member.domain.Member;

public interface MemberStore {
	// selectLoginMember
	public Member selectLoginMember(SqlSession session, Member member);
	// checkIdDuplicate
	public int checkDupId(SqlSession session, String memberId);
	// selectOneById
	public Member selectOneById(SqlSession session, String memberId);
	// insertMember
	public int insertMember(SqlSession session, Member member);
	// updateMember
	public int updateMember(SqlSession session, Member member);
	// deleteMember
	public int deleteMember(SqlSession session, String memberId);
}
