package com.jeju.coupon.domain;

import java.sql.Date;

public class Coupon {
	private String couponCode;
	private String salePrice;
	private int cStatus;
	private Date couponReDate;
	private Date couponEndDate;
	private Date couponStartDate;
	private int count;
	private String couponComments;
	private String couponTitle;
	private String couponImage;
	
	public Coupon() {
		
	}
	
	public Coupon(String couponCode, String salePrice, int cStatus, Date couponReDate, Date couponEndDate,
			Date couponStartDate, int count, String couponComments, String couponTitle, String couponImage) {
		this.couponCode = couponCode;
		this.salePrice = salePrice;
		this.cStatus = cStatus;
		this.couponReDate = couponReDate;
		this.couponEndDate = couponEndDate;
		this.couponStartDate = couponStartDate;
		this.count = count;
		this.couponComments = couponComments;
		this.couponTitle = couponTitle;
		this.couponImage = couponImage;
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

	public Date getCouponReDate() {
		return couponReDate;
	}

	public void setCouponReDate(Date couponReDate) {
		this.couponReDate = couponReDate;
	}

	public Date getCouponEndDate() {
		return couponEndDate;
	}

	public void setCouponEndDate(Date couponEndDate) {
		this.couponEndDate = couponEndDate;
	}

	public Date getCouponStartDate() {
		return couponStartDate;
	}

	public void setCouponStartDate(Date couponStartDate) {
		this.couponStartDate = couponStartDate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getCouponComments() {
		return couponComments;
	}

	public void setCouponComments(String couponComments) {
		this.couponComments = couponComments;
	}

	public String getCouponTitle() {
		return couponTitle;
	}

	public void setCouponTitle(String couponTitle) {
		this.couponTitle = couponTitle;
	}

	public String getCouponImage() {
		return couponImage;
	}

	public void setCouponImage(String couponImage) {
		this.couponImage = couponImage;
	}

}
