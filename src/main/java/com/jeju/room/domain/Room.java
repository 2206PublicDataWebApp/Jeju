
package com.jeju.room.domain;


import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Room {

	private Integer roomNo;
	private String rStatus;
	private String price;
	private String roomName;
	private String delStatus;
	private Integer refPensionNo;
	private Integer maxPersonnel;
	private RoomAttach roomAttach;


}
