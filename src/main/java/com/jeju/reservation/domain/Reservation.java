package com.jeju.reservation.domain;

import java.sql.Date;

public class Reservation {
	private Integer reservationNo;
	private String memberId;
	private String rStatus;
	private Integer roomNo;
	private Integer rePensionNo;
	private int useHistory;
	private String rePrice;
	private String reservationName;
	private String reFilePath;
	private String rePensionName;
	private Date reStartDate;
	private Date reEndDate;
	private Date rePayDate;

	public Reservation() {}

	public Reservation(Integer reservationNo, String memberId, String rStatus, Integer roomNo, Integer rePensionNo,
			int useHistory, String rePrice, String reservationName, String reFilePath, String rePensionName,
			Date reStartDate, Date reEndDate, Date rePayDate) {
		super();
		this.reservationNo = reservationNo;
		this.memberId = memberId;
		this.rStatus = rStatus;
		this.roomNo = roomNo;
		this.rePensionNo = rePensionNo;
		this.useHistory = useHistory;
		this.rePrice = rePrice;
		this.reservationName = reservationName;
		this.reFilePath = reFilePath;
		this.rePensionName = rePensionName;
		this.reStartDate = reStartDate;
		this.reEndDate = reEndDate;
		this.rePayDate = rePayDate;
	}

	public Integer getReservationNo() {
		return reservationNo;
	}

	public void setReservationNo(Integer reservationNo) {
		this.reservationNo = reservationNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getrStatus() {
		return rStatus;
	}

	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}

	public Integer getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(Integer roomNo) {
		this.roomNo = roomNo;
	}

	public Integer getRePensionNo() {
		return rePensionNo;
	}

	public void setRePensionNo(Integer rePensionNo) {
		this.rePensionNo = rePensionNo;
	}

	public int getUseHistory() {
		return useHistory;
	}

	public void setUseHistory(int useHistory) {
		this.useHistory = useHistory;
	}

	public String getRePrice() {
		return rePrice;
	}

	public void setRePrice(String rePrice) {
		this.rePrice = rePrice;
	}

	public String getReservationName() {
		return reservationName;
	}

	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}

	public String getReFilePath() {
		return reFilePath;
	}

	public void setReFilePath(String reFilePath) {
		this.reFilePath = reFilePath;
	}

	public String getRePensionName() {
		return rePensionName;
	}

	public void setRePensionName(String rePensionName) {
		this.rePensionName = rePensionName;
	}

	public Date getReStartDate() {
		return reStartDate;
	}

	public void setReStartDate(Date reStartDate) {
		this.reStartDate = reStartDate;
	}

	public Date getReEndDate() {
		return reEndDate;
	}

	public void setReEndDate(Date reEndDate) {
		this.reEndDate = reEndDate;
	}

	public Date getRePayDate() {
		return rePayDate;
	}

	public void setRePayDate(Date rePayDate) {
		this.rePayDate = rePayDate;
	}


}
