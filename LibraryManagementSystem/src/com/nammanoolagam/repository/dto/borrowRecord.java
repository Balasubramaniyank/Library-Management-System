package com.nammanoolagam.repository.dto;

public class borrowRecord {

	public String recordId;
	public String userId;
	public String bookId;
	public long borrowDate;
	public long dueDate;
	public String  returnId;
	public  double fineAmount;
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public long getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(long borrowDate) {
		this.borrowDate = borrowDate;
	}
	public long getDueDate() {
		return dueDate;
	}
	public void setDueDate(long dueDate) {
		this.dueDate = dueDate;
	}
	public String getReturnId() {
		return returnId;
	}
	public void setReturnId(String returnId) {
		this.returnId = returnId;
	}
	public double getFineAmount() {
		return fineAmount;
	}
	public void setFineAmount(double fineAmount) {
		this.fineAmount = fineAmount;
	}
	
	
}
