package com.example.demo.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Orders {
	
	@GeneratedValue
	@Id
	long id;
	long userId;
	int hotelId;
	
	@OneToMany
	@JoinColumn(name = "menus")
	Set<OrderedMenu> menu;
	
	int totalPrice;

	public long getId() {
		return id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public Set<OrderedMenu> getMenu() {
		return menu;
	}

	public void setMenu(Set<OrderedMenu> menu) {
		this.menu = menu;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", userId=" + userId + ", hotelId=" + hotelId + ", menu=" + menu + ", totalPrice="
				+ totalPrice + "]";
	}
	
	

}
