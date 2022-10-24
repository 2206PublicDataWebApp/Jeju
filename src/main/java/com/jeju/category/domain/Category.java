package com.jeju.category.domain;

public class Category {

	private int pensionNo;
	private int swimming;
	private int barbecue;
	private int sing;
	private int park;
	private int convenienceStore;
	private int smokingRoom;
	private int dog;
	private int handicapPerson;
	private int cook;
	private int breakfast;
	private int wifi;
	private int aircon;
	private int refrigerator;
	private int bathtub;
	private int dry;
	private int tv;
	private String cStatus;
	
	public int getPensionNo() {
		return pensionNo;
	}
	public void setPensionNo(int pensionNo) {
		this.pensionNo = pensionNo;
	}
	public int getSwimming() {
		return swimming;
	}
	public void setSwimming(int swimming) {
		this.swimming = swimming;
	}
	public int getBarbecue() {
		return barbecue;
	}
	public void setBarbecue(int barbecue) {
		this.barbecue = barbecue;
	}
	public int getSing() {
		return sing;
	}
	public void setSing(int sing) {
		this.sing = sing;
	}
	public int getPark() {
		return park;
	}
	public void setPark(int park) {
		this.park = park;
	}
	public int getConvenienceStore() {
		return convenienceStore;
	}
	public void setConvenienceStore(int convenienceStore) {
		this.convenienceStore = convenienceStore;
	}
	public int getSmokingRoom() {
		return smokingRoom;
	}
	public void setSmokingRoom(int smokingRoom) {
		this.smokingRoom = smokingRoom;
	}
	public int getDog() {
		return dog;
	}
	public void setDog(int dog) {
		this.dog = dog;
	}
	public int getHandicapPerson() {
		return handicapPerson;
	}
	public void setHandicapPerson(int handicapPerson) {
		this.handicapPerson = handicapPerson;
	}
	public int getCook() {
		return cook;
	}
	public void setCook(int cook) {
		this.cook = cook;
	}
	public int getBreakfast() {
		return breakfast;
	}
	public void setBreakfast(int breakfast) {
		this.breakfast = breakfast;
	}
	public int getWifi() {
		return wifi;
	}
	public void setWifi(int wifi) {
		this.wifi = wifi;
	}
	public int getAircon() {
		return aircon;
	}
	public void setAircon(int aircon) {
		this.aircon = aircon;
	}
	public int getRefrigerator() {
		return refrigerator;
	}
	public void setRefrigerator(int refrigerator) {
		this.refrigerator = refrigerator;
	}
	public int getBathtub() {
		return bathtub;
	}
	public void setBathtub(int bathtub) {
		this.bathtub = bathtub;
	}
	public int getDry() {
		return dry;
	}
	public void setDry(int dry) {
		this.dry = dry;
	}
	public int getTv() {
		return tv;
	}
	public void setTv(int tv) {
		this.tv = tv;
	}
	public String getcStatus() {
		return cStatus;
	}
	public void setcStatus(String cStatus) {
		this.cStatus = cStatus;
	}
	@Override
	public String toString() {
		return "Category [pensionNo=" + pensionNo + ", swimming=" + swimming + ", barbecue=" + barbecue + ", sing="
				+ sing + ", park=" + park + ", convenienceStore=" + convenienceStore + ", smokingRoom=" + smokingRoom
				+ ", dog=" + dog + ", handicapPerson=" + handicapPerson + ", cook=" + cook + ", breakfast=" + breakfast
				+ ", wifi=" + wifi + ", aircon=" + aircon + ", refrigerator=" + refrigerator + ", bathtub=" + bathtub
				+ ", dry=" + dry + ", tv=" + tv + ", cStatus=" + cStatus + "]";
	}
	
}
