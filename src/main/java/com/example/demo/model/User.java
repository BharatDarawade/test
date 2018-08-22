package com.example.demo.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class User implements Serializable{

	
	@Id
	private String userId;
	private String name;
	private String mobileNo;
	private String address;
	private int pincode;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public User(String userId, String name, String mobileNo, String address, int pincode) {
		super();
		this.userId = userId;
		this.name = name;
		this.mobileNo = mobileNo;
		this.address = address;
		this.pincode = pincode;
	}
	

	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
}
