package com.jeju.reservation.domain;

import java.sql.Date;

public class Reservation {
	private int reservationNo;
	private String memberId;
	private Date checkIn;
	private Date checkOut;
	private String rStatus;
	private int roomNo;
	private int pensionNo;
	private int useHistory;
	private String price;
	
	public Reservation(int reservationNo, String memberId, Date checkIn, Date checkOut, String rStatus, int roomNo,
			int pensionNo, int useHistory, String price) {
		this.reservationNo = reservationNo;
		this.memberId = memberId;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.rStatus = rStatus;
		this.roomNo = roomNo;
		this.pensionNo = pensionNo;
		this.useHistory = useHistory;
		this.price = price;
	}
	
	public int getReservationNo() {
		return reservationNo;
	}
	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	public String getrStatus() {
		return rStatus;
	}
	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public int getPensionNo() {
		return pensionNo;
	}
	public void setPensionNo(int pensionNo) {
		this.pensionNo = pensionNo;
	}
	public int getUseHistory() {
		return useHistory;
	}
	public void setUseHistory(int useHistory) {
		this.useHistory = useHistory;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}
