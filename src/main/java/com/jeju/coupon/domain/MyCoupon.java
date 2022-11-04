package com.jeju.coupon.domain;

import java.sql.Date;

public class MyCoupon {
	private String memberId;
	private String couponCode;
	private String salePrice;
	private int cStatus;
	private Date couponStartDate;
	private Date couponEndDate;
	private Date couponGetDate;
	private int couponUse;
	private String couponImage;
	private String couponTitle;
	private String couponComments;
	
	public MyCoupon() {}

	public MyCoupon(String memberId, String couponCode, String salePrice, int cStatus, Date couponStartDate,
			Date couponEndDate, Date couponGetDate, int couponUse, String couponImage, String couponTitle,
			String couponComments) {
		this.memberId = memberId;
		this.couponCode = couponCode;
		this.salePrice = salePrice;
		this.cStatus = cStatus;
		this.couponStartDate = couponStartDate;
		this.couponEndDate = couponEndDate;
		this.couponGetDate = couponGetDate;
		this.couponUse = couponUse;
		this.couponImage = couponImage;
		this.couponTitle = couponTitle;
		this.couponComments = couponComments;
	}

	public MyCoupon(String memberId, String couponCode) {
		this.memberId = memberId;
		this.couponCode = couponCode;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public String getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

	public int getcStatus() {
		return cStatus;
	}

	public void setcStatus(int cStatus) {
		this.cStatus = cStatus;
	}

	public Date getCouponStartDate() {
		return couponStartDate;
	}

	public void setCouponStartDate(Date couponStartDate) {
		this.couponStartDate = couponStartDate;
	}

	public Date getCouponEndDate() {
		return couponEndDate;
	}

	public void setCouponEndDate(Date couponEndDate) {
		this.couponEndDate = couponEndDate;
	}

	public Date getCouponGetDate() {
		return couponGetDate;
	}

	public void setCouponGetDate(Date couponGetDate) {
		this.couponGetDate = couponGetDate;
	}

	public int getCouponUse() {
		return couponUse;
	}

	public void setCouponUse(int couponUse) {
		this.couponUse = couponUse;
	}

	public String getCouponImage() {
		return couponImage;
	}

	public void setCouponImage(String couponImage) {
		this.couponImage = couponImage;
	}

	public String getCouponTitle() {
		return couponTitle;
	}

	public void setCouponTitle(String couponTitle) {
		this.couponTitle = couponTitle;
	}

	public String getCouponComments() {
		return couponComments;
	}

	public void setCouponComments(String couponComments) {
		this.couponComments = couponComments;
	}

}
