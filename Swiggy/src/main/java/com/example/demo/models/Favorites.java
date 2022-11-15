package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Favorites {
	
	@Id
	@GeneratedValue
	int id;
	int hotelId;
	
	@ManyToOne
	LoginCrenditials userId;

	public int getId() {
		return id;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public LoginCrenditials getUserId() {
		return userId;
	}

	public void setUserId(LoginCrenditials userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Favorites [id=" + id + ", hotelId=" + hotelId + ", userId=" + userId + "]";
	}

}
