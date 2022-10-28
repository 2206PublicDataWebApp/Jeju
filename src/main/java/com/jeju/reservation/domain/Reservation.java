package com.jeju.reservation.domain;

import java.sql.Date;

public class Reservation {
	private Integer reservationNo;
	private String memberId;
	private String rStatus;
	private Integer roomNo;
	private Integer rePensionNo;
	private int useHistory;
	private int rePrice;
	
	public Reservation() {}
	
	public Reservation(Integer reservationNo, String memberId, String rStatus, Integer roomNo, Integer rePensionNo,
			int useHistory, int rePrice) {
		this.reservationNo = reservationNo;
		this.memberId = memberId;
		this.rStatus = rStatus;
		this.roomNo = roomNo;
		this.rePensionNo = rePensionNo;
		this.useHistory = useHistory;
		this.rePrice = rePrice;
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

	public int getRePrice() {
		return rePrice;
	}

	public void setRePrice(int rePrice) {
		this.rePrice = rePrice;
	}
}
