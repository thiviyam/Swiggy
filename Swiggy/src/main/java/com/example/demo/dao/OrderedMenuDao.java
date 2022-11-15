package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.OrderedMenu;

public interface OrderedMenuDao extends JpaRepository<OrderedMenu, Integer>{

}
