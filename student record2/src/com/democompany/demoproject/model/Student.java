package com.democompany.demoproject.model;
public class Student {
	String rollNo, firstName, lastName;
	public void setRollNo(String rollNo)
	{
		this.rollNo = rollNo;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRollNo() {
		return this.rollNo;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
}