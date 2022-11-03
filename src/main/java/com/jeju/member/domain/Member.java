package com.jeju.member.domain;
import java.sql.Date;
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
	
	public Member () {}

	public Member(String memberId, String memberPwd, String memberEmail, String adminCheck, String memberName,
			String memberPhone, String memberAddr, String phone2, String phone3, String authEmail, String authToken,
			Date enrollDate, Date updateDate, String useCount, String gender, Date birthDate, String mStatus,
			int memberNo, int couponCount) {
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
		this.memberNo = memberNo;
		this.couponCount = couponCount;
	}

	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	/**
	 * @return the memberPwd
	 */
	public String getMemberPwd() {
		return memberPwd;
	}

	/**
	 * @param memberPwd the memberPwd to set
	 */
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	/**
	 * @return the memberEmail
	 */
	public String getMemberEmail() {
		return memberEmail;
	}

	/**
	 * @param memberEmail the memberEmail to set
	 */
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	/**
	 * @return the adminCheck
	 */
	public String getAdminCheck() {
		return adminCheck;
	}

	/**
	 * @param adminCheck the adminCheck to set
	 */
	public void setAdminCheck(String adminCheck) {
		this.adminCheck = adminCheck;
	}

	/**
	 * @return the memberName
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * @param memberName the memberName to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * @return the memberPhone
	 */
	public String getMemberPhone() {
		return memberPhone;
	}

	/**
	 * @param memberPhone the memberPhone to set
	 */
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	/**
	 * @return the memberAddr
	 */
	public String getMemberAddr() {
		return memberAddr;
	}

	/**
	 * @param memberAddr the memberAddr to set
	 */
	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}

	/**
	 * @return the phone2
	 */
	public String getPhone2() {
		return phone2;
	}

	/**
	 * @param phone2 the phone2 to set
	 */
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	/**
	 * @return the phone3
	 */
	public String getPhone3() {
		return phone3;
	}

	/**
	 * @param phone3 the phone3 to set
	 */
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	/**
	 * @return the authEmail
	 */
	public String getAuthEmail() {
		return authEmail;
	}

	/**
	 * @param authEmail the authEmail to set
	 */
	public void setAuthEmail(String authEmail) {
		this.authEmail = authEmail;
	}

	/**
	 * @return the authToken
	 */
	public String getAuthToken() {
		return authToken;
	}

	/**
	 * @param authToken the authToken to set
	 */
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	/**
	 * @return the enrollDate
	 */
	public Date getEnrollDate() {
		return enrollDate;
	}

	/**
	 * @param enrollDate the enrollDate to set
	 */
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the useCount
	 */
	public String getUseCount() {
		return useCount;
	}

	/**
	 * @param useCount the useCount to set
	 */
	public void setUseCount(String useCount) {
		this.useCount = useCount;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the mStatus
	 */
	public String getmStatus() {
		return mStatus;
	}

	/**
	 * @param mStatus the mStatus to set
	 */
	public void setmStatus(String mStatus) {
		this.mStatus = mStatus;
	}

	/**
	 * @return the memberNo
	 */
	public int getMemberNo() {
		return memberNo;
	}

	/**
	 * @param memberNo the memberNo to set
	 */
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	/**
	 * @return the couponCount
	 */
	public int getCouponCount() {
		return couponCount;
	}

	/**
	 * @param couponCount the couponCount to set
	 */
	public void setCouponCount(int couponCount) {
		this.couponCount = couponCount;
	}
	
	

}