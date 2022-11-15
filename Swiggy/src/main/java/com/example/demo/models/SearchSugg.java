package com.example.demo.models;

public class SearchSugg {

	String tarvalu;
	int hotelID;
	
	public String getTarvalu() {
		return tarvalu;
	}
	public void setTarvalu(String tarvalu) {
		this.tarvalu = tarvalu;
	}
	public int getHotelID() {
		return hotelID;
	}
	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}
	
	@Override
	public String toString() {
		return "SearchSugg [tarvalu=" + tarvalu + ", hotelID=" + hotelID + "]";
	}
	
}
