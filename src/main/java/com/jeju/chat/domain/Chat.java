package com.jeju.chat.domain;
import java.sql.Date;

public class Chat {
	private String room1;
	private String room2;
	private String chatTitle;
	private String chatIndex;
	/**
	 * @return the room1
	 */
	public String getRoom1() {
		return room1;
	}
	/**
	 * @param room1 the room1 to set
	 */
	public void setRoom1(String room1) {
		this.room1 = room1;
	}
	/**
	 * @return the room2
	 */
	public String getRoom2() {
		return room2;
	}
	/**
	 * @param room2 the room2 to set
	 */
	public void setRoom2(String room2) {
		this.room2 = room2;
	}
	/**
	 * @return the chatTitle
	 */
	public String getChatTitle() {
		return chatTitle;
	}
	/**
	 * @param chatTitle the chatTitle to set
	 */
	public void setChatTitle(String chatTitle) {
		this.chatTitle = chatTitle;
	}
	/**
	 * @return the chatIndex
	 */
	public String getChatIndex() {
		return chatIndex;
	}
	/**
	 * @param chatIndex the chatIndex to set
	 */
	public void setChatIndex(String chatIndex) {
		this.chatIndex = chatIndex;
	}
	public Chat(String room1, String room2, String chatTitle, String chatIndex) {
	
		this.room1 = room1;
		this.room2 = room2;
		this.chatTitle = chatTitle;
		this.chatIndex = chatIndex;
	}

	

	
}
