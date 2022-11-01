package com.jeju.member.service;


import com.jeju.member.domain.Member;

import java.util.List;

public interface MemberService {
	// loginMember
	public Member loginMember(Member member);
	// checkIdDuplicate
	public int checkDupId(String memberId);
	// printOneById
	public Member printOneById(String memberId);
	// registerMember
	public int registerMember(Member member);
	// modifyMember
	public int modifyMember(Member member);
	// removeMember
	public int removeMember(String memberId);



	// 관리자 전체멤버 조회
	public List<Member> showAllMember();

	// 관리자 멤버 삭제


}
