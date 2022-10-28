package com.jeju.pay.domain;

import java.sql.Date;

public class Pay {
	private String payId;
	private String memberId;
	private int paySuccess;
	private int payPrice;
	private Date payDate;
	private Integer roomNo;
	private Integer payPensionNo;

	
	public Pay() {}
	
	public Pay(String payId, String memberId, int paySuccess, int payPrice, Date payDate, Integer roomNo,
			Integer payPensionNo) {
		this.payId = payId;
		this.memberId = memberId;
		this.paySuccess = paySuccess;
		this.payPrice = payPrice;
		this.payDate = payDate;
		this.roomNo = roomNo;
		this.payPensionNo = payPensionNo;
	}
	public String getPayId() {
		return payId;
	}
	public void setPayId(String payId) {
		this.payId = payId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getPaySuccess() {
		return paySuccess;
	}
	public void setPaySuccess(int paySuccess) {
		this.paySuccess = paySuccess;
	}
	public int getPayPrice() {
		return payPrice;
	}
	public void setPayPrice(int payPrice) {
		this.payPrice = payPrice;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public Integer getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(Integer roomNo) {
		this.roomNo = roomNo;
	}
	public Integer getPayPensionNo() {
		return payPensionNo;
	}
	public void setPayPensionNo(Integer payPensionNo) {
		this.payPensionNo = payPensionNo;
	}
	
	
}
