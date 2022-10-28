package com.jeju.room.domain;

public class RoomAttach {
	private String roomPath;
	private char roomImage;
	private int roomOrd;
	private Integer roomNo;
	private String roomFileRename;
	private String roomFileName;
	
	public RoomAttach () {}
	
	@Override
	public String toString() {
		return "RoomAttach [roomPath=" + roomPath + ", roomImage=" + roomImage + ", roomOrd=" + roomOrd + ", roomNo="
				+ roomNo + ", roomFileRename=" + roomFileRename + ", roomFileName=" + roomFileName + "]";
	}
	public String getRoomPath() {
		return roomPath;
	}
	public void setRoomPath(String roomPath) {
		this.roomPath = roomPath;
	}
	public char getRoomImage() {
		return roomImage;
	}
	public void setRoomImage(char roomImage) {
		this.roomImage = roomImage;
	}
	public int getRoomOrd() {
		return roomOrd;
	}
	public void setRoomOrd(int roomOrd) {
		this.roomOrd = roomOrd;
	}
	public Integer getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(Integer roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomFileRename() {
		return roomFileRename;
	}
	public void setRoomFileRename(String roomFileRename) {
		this.roomFileRename = roomFileRename;
	}
	public String getRoomFileName() {
		return roomFileName;
	}
	public void setRoomFileName(String roomFileName) {
		this.roomFileName = roomFileName;
	}
	public RoomAttach(String roomPath, char roomImage, int roomOrd, Integer roomNo, String roomFileRename,
			String roomFileName) {
		this.roomPath = roomPath;
		this.roomImage = roomImage;
		this.roomOrd = roomOrd;
		this.roomNo = roomNo;
		this.roomFileRename = roomFileRename;
		this.roomFileName = roomFileName;
	}
	
}
