package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.LoginCrenditials;

public interface UserDetails extends JpaRepository<LoginCrenditials, Long> {

	@Query("select cname from LoginCrenditials where phoneNumber = ?1")
	public String userExistByPhno(long phoneNumber);
	
	@Query(" from LoginCrenditials where phoneNumber = ?1")
	public List<LoginCrenditials> getUserDetails(long phoneNumber);
}
