package com.jeju.room.domain;

import java.sql.Date;
import java.util.List;

public class Room {
	private Integer roomNo;
	private String rStatus;
	private String price;
	private String roomName;
	private String delStatus;
	private Integer refPensionNo;
	private Integer maxPersonnel;
	private RoomAttach roomAttach;
	
	public Room() {}

	public Room(Integer roomNo, String rStatus, String price, String roomName, String delStatus, Integer refPensionNo,
			Integer maxPersonnel, RoomAttach roomAttach) {
		this.roomNo = roomNo;
		this.rStatus = rStatus;
		this.price = price;
		this.roomName = roomName;
		this.delStatus = delStatus;
		this.refPensionNo = refPensionNo;
		this.maxPersonnel = maxPersonnel;
		this.roomAttach = roomAttach;
	}

	@Override
	public String toString() {
		return "Room [roomNo=" + roomNo + ", rStatus=" + rStatus + ", price=" + price + ", roomName=" + roomName
				+ ", delStatus=" + delStatus + ", refPensionNo=" + refPensionNo + ", maxPersonnel=" + maxPersonnel
				+ ", roomAttach=" + roomAttach + "]";
	}

	public Integer getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(Integer roomNo) {
		this.roomNo = roomNo;
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

	public Integer getMaxPersonnel() {
		return maxPersonnel;
	}

	public void setMaxPersonnel(Integer maxPersonnel) {
		this.maxPersonnel = maxPersonnel;
	}

	public RoomAttach getRoomAttach() {
		return roomAttach;
	}

	public void setRoomAttach(RoomAttach roomAttach) {
		this.roomAttach = roomAttach;
	}
	
	   
}
