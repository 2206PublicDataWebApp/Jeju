package com.jeju.notice.domain;

public class NoticeCount {
	private String memberId;
	private int memberNo;
	private int noticeNo;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	@Override
	public String toString() {
		return "NoticeCount [memberId=" + memberId + ", memberNo=" + memberNo + ", noticeNo=" + noticeNo + "]";
	}
	
	
}
