package com.jeju.room.domain;

public class RoomAttach {
	private String roomPath;
	private char roomImage;
	private int roomOrd;
	private int roomNo;
	private String roomFileRename;
	private String roomFileName;
	
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
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
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
	
}
