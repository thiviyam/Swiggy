package com.example.demo.models;

public class UpdateCart {
	
	int menuid;
	int quantity;
	
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "UpdateCart [menuid=" + menuid + ", quantity=" + quantity + "]";
	}
	
	

}
