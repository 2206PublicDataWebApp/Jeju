package com.jeju.member.store;


import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.jeju.member.domain.Member;
import com.jeju.member.store.MemberStore;

import java.util.List;

@Repository
public class MemberStoreLogic implements MemberStore{

	@Override
	public Member selectLoginMember(SqlSession session, Member member) {
		
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
		int result = session.delete("MemberMapper.deleteMember", memberId);
	//	int result = session.update("MemberMapper.deleteMember", memberId);
		return result;
	}

	@Override
	public Member selectMemberInfo(SqlSessionTemplate session, String memberId) {
		Member member = session.selectOne("MemberMapper.selectMemberInfo", memberId);
		return null;
	}

	@Override
	public int idChk(SqlSession session, String memberId) {
		int result = session.selectOne("memberMapper.idChk",memberId);
		return result;
	}

	// 관리자 전체멤버 조회
	@Override
	public List<Member> showAllMember(SqlSession session){
		List<Member> memberList = session.selectList("MemberMapper.adminShowAllMember");
		return memberList;
	}

	@Override
	public void removeAdminMember(SqlSessionTemplate session, String memberId) {
		session.delete("MemberMapper.deleteAdminMember", memberId);
	}
}
