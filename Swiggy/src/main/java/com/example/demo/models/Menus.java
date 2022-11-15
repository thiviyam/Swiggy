package com.example.demo.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Menus {

	@Id
	@GeneratedValue
	int id;
	String menuName;
	int price;
	String type;
	
	
	@ManyToOne
	@JoinColumn(name = "HotelId")
	Hotels hotel;
	
	@OneToOne
	Cart cart;
	
	public int getId() {
		return id;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Hotels getHotel() {
		return hotel;
	}
	public void setHotel(Hotels hotel) {
		this.hotel = hotel;
	}	
	public Cart getCart() {
		return cart;
	}
	@Override
	public String toString() {
		return "Menus [id=" + id + ", menuName=" + menuName + ", price=" + price + ", type=" + type + ", hotel=" + hotel
				+ ", cart=" + cart + "]";
	}
	
	
	
	
	
	
	
}
