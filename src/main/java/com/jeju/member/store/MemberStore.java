package com.jeju.member.store;




import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import com.jeju.member.domain.Member;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public interface MemberStore {
	// selectLoginMember
	public Member selectLoginMember(SqlSession session, Member member);
	// checkIdDuplicate
	public int checkDupId(SqlSession session, String memberId);
	// checkEmailDuplicate
	public int checkDupEmail(SqlSession session, String memberEmail);
	// selectOneById
	public Member selectOneById(SqlSession session, String memberId);
	// insertMember
	public int insertMember(SqlSession session, Member member);
	// updateMember
	public int updateMember(SqlSession session, Member member);
	// deleteMember
	public int deleteMember(SqlSession session, String memberId);

	public List<Member> findIdByEmail(SqlSession session, String memberEmail);

	public List<Member> findPwdByEmail(SqlSession session, String memberEmail);



	// 관리자 전체멤버 조회
	public List<Member> showAllMember(SqlSession session);

	// 관리자페이지 회원수 총합
	int countAllMember(SqlSessionTemplate session, String searchCondition, String searchValue);

	public Member selectMemberInfo(SqlSessionTemplate session, String memberId);

	List<Member> pagingShowAllMember(SqlSessionTemplate session, int currentPage, int memberLimit);

	// 관리자 회원탈퇴
	void removeAdminMember(SqlSessionTemplate session, Integer memberNo);

	// 관리자페이지 회원검색
    List<Member> searchAllByValue(SqlSessionTemplate session, String searchCondition, String searchValue);

	List<Member> selectNewRegisterChart(SqlSessionTemplate session);

    List<Member> selectGenderChart(SqlSessionTemplate session);
}
