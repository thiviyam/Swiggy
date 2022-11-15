package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderedMenu {
	
	@GeneratedValue
	@Id
	int id;
	int menuId;
	int quantity;
	
	@ManyToOne
	Orders order;

	public int getId() {
		return id;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderedMenu [id=" + id + ", menuId=" + menuId + ", quantity=" + quantity + ", order=" + order + "]";
	}

}
