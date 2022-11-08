package com.jeju.member.store;



import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.jeju.member.domain.Member;
import com.jeju.member.store.MemberStore;

import java.util.HashMap;
import java.util.List;

@Repository
public class MemberStoreLogic implements MemberStore{

	@Override
	public Member selectLoginMember(SqlSession session, Member member) {
		Member mOne = session.selectOne("MemberMapper.selectLoginOne",member);
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



	// 관리자 페이징용 전체조회
	@Override
	public List<Member> pagingShowAllMember(SqlSessionTemplate session, int currentPage, int memberLimit) {
		int offset = (currentPage - 1) * memberLimit;
		RowBounds rowBounds = new RowBounds(offset, memberLimit);
		List<Member> memberList = session.selectList("MemberMapper.pagingShowAllMember", null, rowBounds);
		return memberList;
	}

	// 관리자 전체멤버 조회
	@Override
	public List<Member> showAllMember(SqlSession session){
		List<Member> memberList = session.selectList("MemberMapper.adminShowAllMember");
		return memberList;
	}

	// 관리자 회원탈퇴
	@Override
		public void removeAdminMember(SqlSessionTemplate session, Integer memberNo) {
		session.delete("MemberMapper.deleteAdminMember", memberNo);
		}

	// 관리자페이지 회원검색
	@Override
	public List<Member> searchAllByValue(SqlSessionTemplate session, String searchCondition, String searchValue) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchValue", searchValue);
		List<Member> searchList = session.selectList("MemberMapper.searchAllByValue", paramMap);
		return searchList;
	}

	// 관리자페이지 회원수 총합
	@Override
	public int countAllMember(SqlSessionTemplate session, String searchCondition, String searchValue) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchValue", searchValue);
		int count = session.selectOne("MemberMapper.countAllMember", paramMap);
		return count;
	}


	@Override
	public int checkDupEmail(SqlSession session, String memberEmail) {
		int result = session.selectOne("MemberMapper.checkEmailDuplicate", memberEmail);
		return result;
	}

	@Override
	public List<Member> findIdByEmail(SqlSession session, String memberEmail) {
		List<Member> sList = session.selectList("MemberMapper.findIdByEmail", memberEmail);
		return sList;
	}

	@Override
	public List<Member> findPwdByEmail(SqlSession session, String memberEmail) {
		List<Member> sList = session.selectList("MemberMapper.findPwdByEmail", memberEmail);
		return sList;
	}
}
