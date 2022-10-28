package com.jeju.review.domain;

import java.sql.Date;

public class Review {
	private Integer reivewNo;
	private String memberId;
	private Date regDate;
	private Date reviewUpdate;
	private String reivewContents;
	private Integer reviewCount;
	private Integer pensionNo;

	public Review () {}

	public Review(Integer reivewNo, String memberId, Date regDate, Date reviewUpdate, String reivewContents,
			Integer reviewCount, Integer pensionNo) {
		this.reivewNo = reivewNo;
		this.memberId = memberId;
		this.regDate = regDate;
		this.reviewUpdate = reviewUpdate;
		this.reivewContents = reivewContents;
		this.reviewCount = reviewCount;
		this.pensionNo = pensionNo;
	}

	public Integer getReivewNo() {
		return reivewNo;
	}

	public void setReivewNo(Integer reivewNo) {
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

	public Integer getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(Integer reviewCount) {
		this.reviewCount = reviewCount;
	}

	public Integer getPensionNo() {
		return pensionNo;
	}

	public void setPensionNo(Integer pensionNo) {
		this.pensionNo = pensionNo;
	}

	@Override
	public String toString() {
		return "Review [reivewNo=" + reivewNo + ", memberId=" + memberId + ", regDate=" + regDate + ", reviewUpdate="
				+ reviewUpdate + ", reivewContents=" + reivewContents + ", reviewCount=" + reviewCount + ", pensionNo="
				+ pensionNo + "]";
	}


}
