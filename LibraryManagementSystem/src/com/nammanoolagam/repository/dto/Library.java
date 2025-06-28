package com.nammanoolagam.repository.dto;

public class Library {

	
	public int id;
	public String name;
	public String incharge;
	public  Integer capacity;
	public String phoneNo;
	StorageStructure StorageStructure;
	public String address;	
	public String  wifiPassword;
	public String emailId;
	public Long openingTime;
	public Long closingTime;
	public Integer noAvailableDays;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIncharge() {
		return incharge;
	}
	public void setIncharge(String incharge) {
		this.incharge = incharge;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWifiPassword() {
		return wifiPassword;
	}
	public void setWifiPassword(String wifiPassword) {
		this.wifiPassword = wifiPassword;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Long getOpeningTime() {
		return openingTime;
	}
	public void setOpeningTime(long openingTime) {
		this.openingTime = openingTime;
	}
	public Long getClosingTime() {
		return closingTime;
	}
	public void setClosingTime(long closingTime) {
		this.closingTime = closingTime;
	}
	public 	Integer getNoAvailableDays() {
		return noAvailableDays;
	}
	public void setNoAvailableDays(int noAvailableDays) {
		this.noAvailableDays = noAvailableDays;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
	
	
	
	
	
}
