package com.jeju.member.service;


import com.jeju.member.domain.Member;

import java.util.List;

public interface MemberService {
	// loginMember
	public Member loginMember(Member member);
	// checkIdDuplicate
	public int checkDupId(String memberId);
	// checkIdDuplicate
	public int checkDupEmail(String memberEmail);
	// printOneById
	public Member printOneById(String memberId);
	// registerMember
	public int registerMember(Member member);
	// modifyMember
	public int modifyMember(Member member);
	// removeMember
	public int removeMember(String memberId);
	//아이디찾기 리스트
	public List<Member> findIdByEmail(String memberId);
	//비밀번호찾기
	public List<Member> findPwdByEmail(String memberPwd);


	// 관리자페이지 전체멤버 조회
	public List<Member> showAllMember();


	// 관리자페이지 회원수 총합
	int countAllMember(String searchCondition, String searchValue);


	public Member selectMemberInfo(String memberId);



	List<Member> pagingShowAllMember(int currentPage, int memberLimit);

	// 관리자페이지 회원탈퇴
	void removeAdminMember(Integer memberNo);

	// 관리자페이지 회원검색
	List<Member> searchAllByValue(String searchCondition, String searchValue);

	List<Member> selectNewRegisterChart();
}
