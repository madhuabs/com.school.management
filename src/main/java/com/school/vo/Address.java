package com.school.vo;

public class Address extends ValueObject {
	private String addressType;
	private String doorNo;
	private String houseNo;
	private String street;
	private String state;
	private String district;
	private String village;
	private String mandal;
	private String postalCode;
	private String city;
	private String country;

	public String getDoorNo() {
		return doorNo;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public String getStreet() {
		return street;
	}

	public String getState() {
		return state;
	}

	public String getDistrict() {
		return district;
	}

	public String getVillage() {
		return village;
	}

	public String getMandal() {
		return mandal;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public void setMandal(String mandal) {
		this.mandal = mandal;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
