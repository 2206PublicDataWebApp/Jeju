package com.jeju.room.domain;

import java.sql.Date;

public class Room {
	private int roomNo;
	private Date startTime;
	private Date endTime;
	private char rStatus;
	private String price;
	private String roomName;
	private char delStatus;
	private int pensionNo;
	private int maxPersonnel;
	
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
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
	public char getrStatus() {
		return rStatus;
	}
	public void setrStatus(char rStatus) {
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
	public char getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(char delStatus) {
		this.delStatus = delStatus;
	}
	public int getPensionNo() {
		return pensionNo;
	}
	public void setPensionNo(int pensionNo) {
		this.pensionNo = pensionNo;
	}
	public int getMaxPersonnel() {
		return maxPersonnel;
	}
	public void setMaxPersonnel(int maxPersonnel) {
		this.maxPersonnel = maxPersonnel;
	}
	@Override
	public String toString() {
		return "Room [roomNo=" + roomNo + ", startTime=" + startTime + ", endTime=" + endTime + ", rStatus=" + rStatus
				+ ", price=" + price + ", roomName=" + roomName + ", delStatus=" + delStatus + ", pensionNo="
				+ pensionNo + ", maxPersonnel=" + maxPersonnel + "]";
	}
	
public class Room {
	 private int roomNo;
	   private Date startTime;
	   private Date endTime;
	   private char rStatus;
	   private int price;
	   private String roomName;
	   private char delStatus;
	   private int pensionNo;
	   private int maxPersonnel;
	   
	public Room(int roomNo, Date startTime, Date endTime, char rStatus, int price, String roomName, char delStatus,
			int pensionNo, int maxPersonnel) {
		this.roomNo = roomNo;
		this.startTime = startTime;
		this.endTime = endTime;
		this.rStatus = rStatus;
		this.price = price;
		this.roomName = roomName;
		this.delStatus = delStatus;
		this.pensionNo = pensionNo;
		this.maxPersonnel = maxPersonnel;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
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
	public char getrStatus() {
		return rStatus;
	}
	public void setrStatus(char rStatus) {
		this.rStatus = rStatus;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public char getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(char delStatus) {
		this.delStatus = delStatus;
	}
	public int getPensionNo() {
		return pensionNo;
	}
	public void setPensionNo(int pensionNo) {
		this.pensionNo = pensionNo;
	}
	public int getMaxPersonnel() {
		return maxPersonnel;
	}
	public void setMaxPersonnel(int maxPersonnel) {
		this.maxPersonnel = maxPersonnel;
	}

	   
}
