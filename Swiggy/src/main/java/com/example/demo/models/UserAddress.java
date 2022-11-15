package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserAddress {
	
	@GeneratedValue
	@Id
	int id;
	String type;
	String plotNo;
	String street;
	String district;
	String state;
	long pincode;
	
	@ManyToOne
	LoginCrenditials user;

	public int getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPlotNo() {
		return plotNo;
	}

	public void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public LoginCrenditials getUser() {
		return user;
	}

	public void setUser(LoginCrenditials user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserAddress [id=" + id + ", type=" + type + ", plotNo=" + plotNo + ", street=" + street + ", district="
				+ district + ", state=" + state + ", pincode=" + pincode + ", user=" + user + "]";
	}

}
