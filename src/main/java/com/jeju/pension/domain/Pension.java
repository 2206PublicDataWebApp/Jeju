package com.jeju.pension.domain;

public class Pension {
	private int pensionNo;
	private String memberId;
	private String pensionName;
	private String category;
	private String pensionAddr;
	private String pensionComments;
	private String pensionPrice;
	private int hardness;
	private int latitude;
	private String cancelPension;
	private int pensionCheckin;
	private int pensionCheckout;
	private String filePath;
	private String fileImage;
	
	public Pension () {}

	public Pension(int pensionNo, String memberId, String pensionName, String category, String pensionAddr,
			String pensionComments, String pensionPrice, int hardness, int latitude, String cancelPension,
			int pensionCheckin, int pensionCheckout, String filePath, String fileImage) {
		this.pensionNo = pensionNo;
		this.memberId = memberId;
		this.pensionName = pensionName;
		this.category = category;
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
	}

	public int getPensionNo() {
		return pensionNo;
	}

	public void setPensionNo(int pensionNo) {
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public int getHardness() {
		return hardness;
	}

	public void setHardness(int hardness) {
		this.hardness = hardness;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
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

	
	

}
