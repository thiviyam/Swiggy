package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.ThreadUser;

public interface ThreadDao extends JpaRepository<ThreadUser, Integer>{

	@Query("from ThreadUser")
	public List<ThreadUser> getAllActiveUser();
}
