package com.jeju.member.service;


import com.jeju.member.domain.Member;

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
}
