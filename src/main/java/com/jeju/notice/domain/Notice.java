package com.jeju.notice.domain;

import java.sql.Date;

public class Notice {
	private int noticeNo;
	private String noticeContents;
	private String noticeTitle;
	private Date regDate;
	private Date NoticeUpdate;
	private int noticeCount;
	
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getNoticeContents() {
		return noticeContents;
	}
	public void setNoticeContents(String noticeContents) {
		this.noticeContents = noticeContents;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getNoticeUpdate() {
		return NoticeUpdate;
	}
	public void setNoticeUpdate(Date noticeUpdate) {
		NoticeUpdate = noticeUpdate;
	}
	public int getNoticeCount() {
		return noticeCount;
	}
	public void setNoticeCount(int noticeCount) {
		this.noticeCount = noticeCount;
	}
	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeContents=" + noticeContents + ", noticeTitle=" + noticeTitle
				+ ", regDate=" + regDate + ", NoticeUpdate=" + NoticeUpdate + ", noticeCount=" + noticeCount + "]";
	}
	

	
	
}
