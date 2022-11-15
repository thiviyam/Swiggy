package com.example.demo.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cart {
	
	@GeneratedValue
	@Id
	int id;
	int hid;
	long userid;
	
	@OneToOne
	@JoinColumn(name = "menu_id")
	Menus cartitem;
	
	int quantity;


	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public Menus getCartitem() {
		return cartitem;
	}
	
	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public void setCartitem(Menus cartitem) {
		this.cartitem = cartitem;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", hid=" + hid + ", userid=" + userid + ", cartitem=" + cartitem + ", quantity="
				+ quantity + "]";
	}
	

}
