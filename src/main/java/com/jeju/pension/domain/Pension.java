package com.jeju.pension.domain;

public class Pension {

	private int pensionNo;
	private String memberId;
	private String pensionName;
	private char category;
	private String pensionAddr;
	private String pensionComments;
	private String pensionPrice;
	private int hardness;
	private int latitude;
	private char canclePension;
	private int pensionCheckin;
	private int pensionCheckout;
	private String filePath;
	private char fileImage;
	private String pensionFileName;
	private String pensionFileRename;
	
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
	public char getCategory() {
		return category;
	}
	public void setCategory(char category) {
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
	public char getCanclePension() {
		return canclePension;
	}
	public void setCanclePension(char canclePension) {
		this.canclePension = canclePension;
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
	public char getFileImage() {
		return fileImage;
	}
	public void setFileImage(char fileImage) {
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
	@Override
	public String toString() {
		return "Pension [pensionNo=" + pensionNo + ", memberId=" + memberId + ", pensionName=" + pensionName
				+ ", category=" + category + ", pensionAddr=" + pensionAddr + ", pensionComments=" + pensionComments
				+ ", pensionPrice=" + pensionPrice + ", hardness=" + hardness + ", latitude=" + latitude
				+ ", canclePension=" + canclePension + ", pensionCheckin=" + pensionCheckin + ", pensionCheckout="
				+ pensionCheckout + ", filePath=" + filePath + ", fileImage=" + fileImage + ", pensionFileName="
				+ pensionFileName + ", pensionFileRename=" + pensionFileRename + "]";
	}

	
}
