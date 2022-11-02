package com.jeju.pension.domain;

import java.util.ArrayList;
import java.util.List;

public class Pension implements Comparable<Pension>{
	private Integer pensionNo;
	private String memberId;
	private String pensionName;
	private String pensionAddr;
	private String pensionComments;
	private String pensionPrice;
	private String hardness;
	private String latitude;
	private String cancelPension;
	private int pensionCheckin;
	private int pensionCheckout;
	private String filePath;
	private String fileImage;
	private String pensionFileName;
	private String pensionFileRename;
	private Integer reviewCount;
	private Integer jjimCount;

	public Pension() {}

	public Pension(Integer pensionNo, String memberId, String pensionName, String pensionAddr,
			String pensionComments, String pensionPrice, String hardness, String latitude, String cancelPension,
			int pensionCheckin, int pensionCheckout, String filePath, String fileImage, String pensionFileName,
			String pensionFileRename, Integer reviewCount, Integer jjimCount) {
		this.pensionNo = pensionNo;
		this.memberId = memberId;
		this.pensionName = pensionName;
		this.pensionAddr = pensionAddr;
		this.pensionComments = pensionComments;
		this.pensionPrice = pensionPrice;
		this.hardness = hardness;
		this.latitude = latitude;
		this.cancelPension = cancelPension;
		this.pensionCheckin = pensionCheckin;
		this.pensionCheckout = pensionCheckout;
		this.filePath = filePath;
		this.fileImage = fileImage;
		this.pensionFileName = pensionFileName;
		this.pensionFileRename = pensionFileRename;
		this.reviewCount = reviewCount;
		this.jjimCount = jjimCount;
	}


	public Integer getPensionNo() {
		return pensionNo;
	}

	public void setPensionNo(Integer pensionNo) {
		this.pensionNo = pensionNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPensionName() {
		return pensionName;
	}

	public void setPensionName(String pensionName) {
		this.pensionName = pensionName;
	}



	public String getPensionAddr() {
		return pensionAddr;
	}



	public void setPensionAddr(String pensionAddr) {
		this.pensionAddr = pensionAddr;
	}

	public String getPensionComments() {
		return pensionComments;
	}

	public void setPensionComments(String pensionComments) {
		this.pensionComments = pensionComments;
	}

	public String getPensionPrice() {
		return pensionPrice;
	}

	public void setPensionPrice(String pensionPrice) {
		this.pensionPrice = pensionPrice;
	}

	public String getHardness() {
		return hardness;
	}

	public void setHardness(String hardness) {
		this.hardness = hardness;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getCancelPension() {
		return cancelPension;
	}

	public void setCancelPension(String cancelPension) {
		this.cancelPension = cancelPension;
	}

	public int getPensionCheckin() {
		return pensionCheckin;
	}

	public void setPensionCheckin(int pensionCheckin) {
		this.pensionCheckin = pensionCheckin;
	}

	public int getPensionCheckout() {
		return pensionCheckout;
	}

	public void setPensionCheckout(int pensionCheckout) {
		this.pensionCheckout = pensionCheckout;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileImage() {
		return fileImage;
	}

	public void setFileImage(String fileImage) {
		this.fileImage = fileImage;
	}

	public String getPensionFileName() {
		return pensionFileName;
	}

	public void setPensionFileName(String pensionFileName) {
		this.pensionFileName = pensionFileName;
	}

	public String getPensionFileRename() {
		return pensionFileRename;
	}

	public void setPensionFileRename(String pensionFileRename) {
		this.pensionFileRename = pensionFileRename;
	}

	public Integer getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(Integer reviewCount) {
		this.reviewCount = reviewCount;
	}

	public Integer getJjimCount() {
		return jjimCount;
	}

	public void setJjimCount(Integer jjimCount) {
		this.jjimCount = jjimCount;
	}

	@Override
	public int compareTo(Pension pension) {
		if(pension.reviewCount < reviewCount) {
			return 1;
		}else {
			return -1;
		}
	}


}
