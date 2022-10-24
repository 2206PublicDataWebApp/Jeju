package com.jeju.review.domain;

import java.sql.Date;

public class Review {
	private int reivewNo;
	private String memberId;
	private Date regDate;
	private Date reviewUpdate;
	private String reivewContents;
	private int reivewCount;
	private int pensionNo;
	public int getReivewNo() {
		return reivewNo;
	}
	public void setReivewNo(int reivewNo) {
		this.reivewNo = reivewNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getReviewUpdate() {
		return reviewUpdate;
	}
	public void setReviewUpdate(Date reviewUpdate) {
		this.reviewUpdate = reviewUpdate;
	}
	public String getReivewContents() {
		return reivewContents;
	}
	public void setReivewContents(String reivewContents) {
		this.reivewContents = reivewContents;
	}
	public int getReivewCount() {
		return reivewCount;
	}
	public void setReivewCount(int reivewCount) {
		this.reivewCount = reivewCount;
	}
	public int getPensionNo() {
		return pensionNo;
	}
	public void setPensionNo(int pensionNo) {
		this.pensionNo = pensionNo;
	}
	@Override
	public String toString() {
		return "Review [reivewNo=" + reivewNo + ", memberId=" + memberId + ", regDate=" + regDate + ", reviewUpdate="
				+ reviewUpdate + ", reivewContents=" + reivewContents + ", reivewCount=" + reivewCount + ", pensionNo="
				+ pensionNo + "]";
	}
	public Review(int reivewNo, String memberId, Date regDate, Date reviewUpdate, String reivewContents,
			int reivewCount, int pensionNo) {
		this.reivewNo = reivewNo;
		this.memberId = memberId;
		this.regDate = regDate;
		this.reviewUpdate = reviewUpdate;
		this.reivewContents = reivewContents;
		this.reivewCount = reivewCount;
		this.pensionNo = pensionNo;
	}

	
}
