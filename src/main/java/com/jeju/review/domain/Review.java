package com.jeju.review.domain;

import java.sql.Date;

public class Review {
	private Integer reviewNo;
	private String memberId;
	private Date regDate;
	private Date reviewUpdate;
	private String reviewContents;
	private Integer reviewCount;
	private Integer pensionNo;

	public Review() {}

	public Review(Integer reviewNo, String memberId, Date regDate, Date reviewUpdate, String reviewContents,
			Integer reviewCount, Integer pensionNo) {
		this.reviewNo = reviewNo;
		this.memberId = memberId;
		this.regDate = regDate;
		this.reviewUpdate = reviewUpdate;
		this.reviewContents = reviewContents;
		this.reviewCount = reviewCount;
		this.pensionNo = pensionNo;
	}

	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", memberId=" + memberId + ", regDate=" + regDate + ", reviewUpdate="
				+ reviewUpdate + ", reviewContents=" + reviewContents + ", reviewCount=" + reviewCount + ", pensionNo="
				+ pensionNo + "]";
	}

	public Integer getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(Integer reviewNo) {
		this.reviewNo = reviewNo;
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

	public String getReviewContents() {
		return reviewContents;
	}

	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
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
	
}
