package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.UserAddress;

public interface UserAddrDao extends JpaRepository<UserAddress, Integer>{

}
