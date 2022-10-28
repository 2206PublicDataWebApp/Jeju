package com.jeju.jjim.domain;

import java.sql.Date;

public class Jjim {
	private Integer pensionNo;
	private String memberId;
	private Date regDate;
	
	public Jjim() {}

	public Jjim(Integer pensionNo, String memberId, Date regDate) {
		this.pensionNo = pensionNo;
		this.memberId = memberId;
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Jjim [pensionNo=" + pensionNo + ", memberId=" + memberId + ", regDate=" + regDate + "]";
	}

	public Integer getPensionNo() {
		return pensionNo;
	}

	public void setPensionNo(Integer pensionNo) {
		this.pensionNo = pensionNo;
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
	
}
