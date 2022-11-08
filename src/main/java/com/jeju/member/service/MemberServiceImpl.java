package com.jeju.member.service;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.member.domain.Member;
import com.jeju.member.service.MemberService;
import com.jeju.member.store.MemberStore;

import java.util.List;

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


	// 관리자페이지 전체멤버 조회
	@Override
	public List<Member> showAllMember() {
		List<Member> memberList = mStore.showAllMember(session);
		return memberList;
	}

	// 관리자페이지 회원탈퇴
	@Override
		public void removeAdminMember(Integer memberNo) {
			mStore.removeAdminMember(session, memberNo);
		}

		// 관리자페이지 회원검색
	@Override
	public List<Member> searchAllByValue(String searchCondition, String searchValue) {
		List<Member> searchList = mStore.searchAllByValue(session, searchCondition, searchValue);
		return searchList;
	}

	// 관리자페이지 회원수 총합
	@Override
	public int countAllMember(String searchCondition, String searchValue) {
		int count = mStore.countAllMember(session, searchCondition, searchValue);
		return count;
	}


	@Override
	public Member selectMemberInfo(String memberId) {
		Member member =mStore.selectMemberInfo(session, memberId);
		return member;
	}


	@Override
	public int checkDupEmail(String memberEmail) {
		int result = mStore.checkDupEmail(session, memberEmail);
		return result;
	}

	@Override
	public List<Member> pagingShowAllMember(int currentPage, int memberLimit) {
		List<Member> memberList = mStore.pagingShowAllMember(session, currentPage, memberLimit);
		return memberList;
	}


@Override
	public List<Member> findIdByEmail(String memberEmail) {
		List<Member> sList = mStore.findIdByEmail(session, memberEmail);
		return sList;
	}

	@Override
	public List<Member> findPwdByEmail(String memberEmail) {
		List<Member> sList = mStore.findPwdByEmail(session, memberEmail);
		return sList;
	}

//	@Override
//	public String findId(String memberName, String memberPhone) {
//String result = "";
//
//		try {
//		 result= mStore.findId(memberName, \memhone);
//
//		} catch(Exception e) {
//
//			e.printStackTrace();
//		}
//
//		return result ;
//	}
}
