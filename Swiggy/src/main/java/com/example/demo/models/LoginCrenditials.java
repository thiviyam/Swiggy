package com.example.demo.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class LoginCrenditials {
	
	@GeneratedValue
	int id;
	@Id
	long phoneNumber;
    String cname;
    String email;
    String password;
    
    @OneToMany
    @JoinColumn(name = "user_id")
    Set<UserAddress> address;
    
    @OneToMany
    @JoinColumn(name = "user_fav")
    Set<Favorites> fav;
    
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public Set<UserAddress> getAddress() {
		return address;
	}
	public void setAddress(Set<UserAddress> address) {
		this.address = address;
	}	
	public Set<Favorites> getFav() {
		return fav;
	}
	public void setFav(Set<Favorites> fav) {
		this.fav = fav;
	}
	@Override
	public String toString() {
		return "LoginCrenditials [id=" + id + ", phoneNumber=" + phoneNumber + ", cname=" + cname + ", email=" + email
				+ ", password=" + password + ", address=" + address + ", fav=" + fav + "]";
	}
	
    

}
