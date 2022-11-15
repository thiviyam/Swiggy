package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Orders;

public interface OrdersDao extends JpaRepository<Orders, Long>{

	@Query("from Orders where userId = ?1")
	public List<Orders> getAllOrdersByUserId(long userid);

	@Query("from Orders where userId = ?1 and id = ?2")
	public Orders getOrderByUserIdAndOrderId(long userid, long oID);
	
	
}
