package com.jeju.category.domain;

public class Category {

	private Integer refPensionNumber;
	private Integer swimming;
	private Integer barbecue;
	private Integer sing;
	private Integer park;
	private Integer convenienceStore;
	private Integer smokingRoom;
	private Integer dog;
	private Integer handicapPerson;
	private Integer cook;
	private Integer breakfast;
	private Integer wifi;
	private Integer aircon;
	private Integer refrigerator;
	private Integer bathtub;
	private Integer dry;
	private Integer tv;
	private String cStatus;
	@Override
	public String toString() {
		return "Category [refPensionNumber=" + refPensionNumber + ", swimming=" + swimming + ", barbecue=" + barbecue
				+ ", sing=" + sing + ", park=" + park + ", convenienceStore=" + convenienceStore + ", smokingRoom="
				+ smokingRoom + ", dog=" + dog + ", handicapPerson=" + handicapPerson + ", cook=" + cook
				+ ", breakfast=" + breakfast + ", wifi=" + wifi + ", aircon=" + aircon + ", refrigerator="
				+ refrigerator + ", bathtub=" + bathtub + ", dry=" + dry + ", tv=" + tv + ", cStatus=" + cStatus + "]";
	}
	public Category(Integer refPensionNumber, Integer swimming, Integer barbecue, Integer sing, Integer park,
			Integer convenienceStore, Integer smokingRoom, Integer dog, Integer handicapPerson, Integer cook,
			Integer breakfast, Integer wifi, Integer aircon, Integer refrigerator, Integer bathtub, Integer dry,
			Integer tv, String cStatus) {
		this.refPensionNumber = refPensionNumber;
		this.swimming = swimming;
		this.barbecue = barbecue;
		this.sing = sing;
		this.park = park;
		this.convenienceStore = convenienceStore;
		this.smokingRoom = smokingRoom;
		this.dog = dog;
		this.handicapPerson = handicapPerson;
		this.cook = cook;
		this.breakfast = breakfast;
		this.wifi = wifi;
		this.aircon = aircon;
		this.refrigerator = refrigerator;
		this.bathtub = bathtub;
		this.dry = dry;
		this.tv = tv;
		this.cStatus = cStatus;
	}
	public Integer getRefPensionNumber() {
		return refPensionNumber;
	}
	public void setRefPensionNumber(Integer refPensionNumber) {
		this.refPensionNumber = refPensionNumber;
	}
	public Integer getSwimming() {
		return swimming;
	}
	public void setSwimming(Integer swimming) {
		this.swimming = swimming;
	}
	public Integer getBarbecue() {
		return barbecue;
	}
	public void setBarbecue(Integer barbecue) {
		this.barbecue = barbecue;
	}
	public Integer getSing() {
		return sing;
	}
	public void setSing(Integer sing) {
		this.sing = sing;
	}
	public Integer getPark() {
		return park;
	}
	public void setPark(Integer park) {
		this.park = park;
	}
	public Integer getConvenienceStore() {
		return convenienceStore;
	}
	public void setConvenienceStore(Integer convenienceStore) {
		this.convenienceStore = convenienceStore;
	}
	public Integer getSmokingRoom() {
		return smokingRoom;
	}
	public void setSmokingRoom(Integer smokingRoom) {
		this.smokingRoom = smokingRoom;
	}
	public Integer getDog() {
		return dog;
	}
	public void setDog(Integer dog) {
		this.dog = dog;
	}
	public Integer getHandicapPerson() {
		return handicapPerson;
	}
	public void setHandicapPerson(Integer handicapPerson) {
		this.handicapPerson = handicapPerson;
	}
	public Integer getCook() {
		return cook;
	}
	public void setCook(Integer cook) {
		this.cook = cook;
	}
	public Integer getBreakfast() {
		return breakfast;
	}
	public void setBreakfast(Integer breakfast) {
		this.breakfast = breakfast;
	}
	public Integer getWifi() {
		return wifi;
	}
	public void setWifi(Integer wifi) {
		this.wifi = wifi;
	}
	public Integer getAircon() {
		return aircon;
	}
	public void setAircon(Integer aircon) {
		this.aircon = aircon;
	}
	public Integer getRefrigerator() {
		return refrigerator;
	}
	public void setRefrigerator(Integer refrigerator) {
		this.refrigerator = refrigerator;
	}
	public Integer getBathtub() {
		return bathtub;
	}
	public void setBathtub(Integer bathtub) {
		this.bathtub = bathtub;
	}
	public Integer getDry() {
		return dry;
	}
	public void setDry(Integer dry) {
		this.dry = dry;
	}
	public Integer getTv() {
		return tv;
	}
	public void setTv(Integer tv) {
		this.tv = tv;
	}
	public String getcStatus() {
		return cStatus;
	}
	public void setcStatus(String cStatus) {
		this.cStatus = cStatus;
	}
	
	
	
}
