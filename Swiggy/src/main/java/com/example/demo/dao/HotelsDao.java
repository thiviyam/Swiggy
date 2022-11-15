package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Hotels;
import com.example.demo.models.Menus;

public interface HotelsDao extends JpaRepository<Hotels, Integer> {

	@Query("from Hotels")
	public List<Hotels> getAllHotels();
	
	@Query("from Hotels where id = ?1")
	public Hotels getHotelById(int id);

	@Query("from Hotels where hotelname like %?1%")
	public List<Hotels> searchByHotelNameSugg(String searchText);
	
	@Query("SELECT m FROM Hotels h JOIN h.menu m WHERE h.id = ?2 and m.menuName LIKE %?1%")
	public List<Menus> searchForMenuByHotelIdSugg(String textQuery, int hotelId);
	
	@Query("from Hotels order by ratings desc")
	public List<Hotels> getHotelAccordingToRating();
	
	@Query("from Hotels order by servings")
	public List<Hotels> getHotelAccordingToCostAsc();
	
	@Query("from Hotels order by servings desc")
	public List<Hotels> getHotelAccordingToCostDesc();
}
