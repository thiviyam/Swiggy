package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Cart;
import com.example.demo.models.Menus;

@Transactional
public interface CartDao extends JpaRepository<Cart, Integer> {
	
	@Query("from Cart where menu_id = ?1 and userid = ?2")
	public Cart getAllByMenuId(int id, long userid);
	
	@Query("from Cart where userid = ?1")
	public List<Cart> getAllFromCartByPh(long ph);
	
	@Modifying
	@Query("delete from Cart where userid = ?1")
	public void deleteByUserId(long ui);
	
	@Query("from Cart where menu_id = ?1 and userid = ?2")
	public Cart getCartForUpdate(int menuid, long ph);

	@Modifying
	@Query("delete from Cart where userid = ?1")
	public void deleteCartByUserId(long ph);
	
	

}
