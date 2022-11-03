package com.jeju.member.domain;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {
	private String memberId;
	private String memberPwd;
	private String memberEmail;
	private String adminCheck;
	private String memberName;
	private String memberPhone;
	private String memberAddr;
	private String phone2;
	private String phone3;
	private String authEmail;
	private String authToken;
	private Date enrollDate;
	private Date updateDate;
	private String useCount;
	private String gender;
	private Date birthDate;
	private String mStatus;
	private int memberNo;
	private int couponCount;


	public String setAddressBySize(int size){
		String address = getMemberAddr();
		address.substring(0,size);
		address = address + "...";
		return address;
	}
}