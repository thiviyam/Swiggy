package com.example.demo.models;

import java.util.Arrays;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Hotels {

	@Id
	@GeneratedValue
	int id;
	String hotelname;
	String cusines[];
	int ratings;
	int servings;
	
	@OneToMany(cascade = CascadeType.ALL)
	Set<Menus> menu;
	
	public int getId() {
		return id;
	}

	public String getHotelname() {
		return hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}

	public String[] getCusines() {
		return cusines;
	}

	public void setCusines(String[] cusines) {
		this.cusines = cusines;
	}

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	public Set<Menus> getMenu() {
		return menu;
	}

	public int getServings() {
		return servings;
	}

	public void setServings(int servings) {
		this.servings = servings;
	}

	@Override
	public String toString() {
		return "Hotels [id=" + id + ", hotelname=" + hotelname + ", cusines=" + Arrays.toString(cusines) + ", ratings="
				+ ratings + ", servings=" + servings + ", menu=" + menu + "]";
	}

	
	
	
}
