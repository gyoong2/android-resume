package com.gary.yoong.model;

import com.google.android.gms.maps.model.LatLng;

public class ContactInfo {
	
	private LatLng coords;
	private String address;
	private String phoneNumber;
	private String postalCode;
	private String province;
	private String country;
	
	public ContactInfo () {
		
	}
	
	public LatLng getCoords() {
		return coords;
	}
	public void setCoords(LatLng coords) {
		this.coords = coords;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
