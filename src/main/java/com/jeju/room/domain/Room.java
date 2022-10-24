package com.jeju.room.domain;

import java.sql.Date;

public class Room {
	private Integer roomNo;
	private Date startTime;
	private Date endTime;
	private String rStatus;
	private String price;
	private String roomName;
	private String delStatus;
	private Integer refPensionNo;
	private int maxPersonnel;
	@Override
	public String toString() {
		return "Room [roomNo=" + roomNo + ", startTime=" + startTime + ", endTime=" + endTime + ", rStatus=" + rStatus
				+ ", price=" + price + ", roomName=" + roomName + ", delStatus=" + delStatus + ", refPensionNo="
				+ refPensionNo + ", maxPersonnel=" + maxPersonnel + "]";
	}
	public Room(Integer roomNo, Date startTime, Date endTime, String rStatus, String price, String roomName,
			String delStatus, Integer refPensionNo, int maxPersonnel) {
		this.roomNo = roomNo;
		this.startTime = startTime;
		this.endTime = endTime;
		this.rStatus = rStatus;
		this.price = price;
		this.roomName = roomName;
		this.delStatus = delStatus;
		this.refPensionNo = refPensionNo;
		this.maxPersonnel = maxPersonnel;
	}
	public Integer getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(Integer roomNo) {
		this.roomNo = roomNo;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getrStatus() {
		return rStatus;
	}
	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(String delStatus) {
		this.delStatus = delStatus;
	}
	public Integer getRefPensionNo() {
		return refPensionNo;
	}
	public void setRefPensionNo(Integer refPensionNo) {
		this.refPensionNo = refPensionNo;
	}
	public int getMaxPersonnel() {
		return maxPersonnel;
	}
	public void setMaxPersonnel(int maxPersonnel) {
		this.maxPersonnel = maxPersonnel;
	}

	   
}
