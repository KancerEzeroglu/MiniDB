package com.exam;

import java.util.Date;

public class Record implements Comparable<Record>{
//	 <Username>;<First Name>;<Last Name>;<Department>;<Account End Date>;<Telephone Number>

	String userName;
	String firstName;
	String lastName;
	String department;
	Date endDate;
	String telNum;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getTelNum() {
		return telNum;
	}
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
	@Override
	public int compareTo(Record objectToCompare) {
		// TODO Auto-generated method stub
		Date compareQuantity = ((Record) objectToCompare).getEndDate(); 
		 
		//ascending order
		return this.endDate.compareTo(compareQuantity);
		
	}
	
}
