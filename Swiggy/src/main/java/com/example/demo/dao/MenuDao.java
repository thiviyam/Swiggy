package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Menus;

public interface MenuDao extends JpaRepository<Menus, Integer> {
	
	@Query("from Menus where hotelId = ?1")
	public List<Menus> getAllMenuFromHotelId(int hotelId);
	
	@Query("from Menus where id = ?1")
	public Menus getMenuById(int menuid);

	@Query("from Menus where menuName like %?1%")
	public List<Menus> searchByMenuNameSugg(String textQuery);
	
	@Query("from Menus where hotelId = ?2 and menuName like %?1%")
	public List<Menus> searchForMenuByHotelIdSugg(String textQuery, int hotelId);
}
