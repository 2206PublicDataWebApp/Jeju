package com.jeju.member.domain;
import java.sql.Date;

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
	
	public Member () {}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getAdminCheck() {
		return adminCheck;
	}
	public void setAdminCheck(String adminCheck) {
		this.adminCheck = adminCheck;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberAddr() {
		return memberAddr;
	}
	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone3() {
		return phone3;
	}
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	public String getAuthEmail() {
		return authEmail;
	}
	public void setAuthEmail(String authEmail) {
		this.authEmail = authEmail;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getUseCount() {
		return useCount;
	}
	public void setUseCount(String useCount) {
		this.useCount = useCount;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getmStatus() {
		return mStatus;
	}
	public void setmStatus(String mStatus) {
		this.mStatus = mStatus;
	}
	public Member(String memberId, String memberPwd, String memberEmail, String adminCheck, String memberName,
			String memberPhone, String memberAddr, String phone2, String phone3, String authEmail, String authToken,
			Date enrollDate, Date updateDate, String useCount, String gender, Date birthDate, String mStatus) {
	
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberEmail = memberEmail;
		this.adminCheck = adminCheck;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberAddr = memberAddr;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.authEmail = authEmail;
		this.authToken = authToken;
		this.enrollDate = enrollDate;
		this.updateDate = updateDate;
		this.useCount = useCount;
		this.gender = gender;
		this.birthDate = birthDate;
		this.mStatus = mStatus;
	}

}