package com.nammanoolagam.repository.dto;

import java.util.List;

public class User {
	
	public String userId;
	public String firstName;
	public String lastName ;
	
	public String email;
	public String mobileNumber;
	public String address;
	public String dob;
	public  List<borrowRecord> BorrowedBooks; 
	public  List<feedback>feedbacks;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public List<borrowRecord> getBorrowedBooks() {
		return BorrowedBooks;
	}
	public void setBorrowedBooks(List<borrowRecord> borrowedBooks) {
		BorrowedBooks = borrowedBooks;
	}
	public List<feedback> getFeedbacks() {
		return feedbacks;
	}
	public void setFeedbacks(List<feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}
	
	

}
