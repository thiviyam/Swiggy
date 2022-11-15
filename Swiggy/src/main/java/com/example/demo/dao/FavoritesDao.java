package com.example.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Favorites;

@Transactional
public interface FavoritesDao extends JpaRepository<Favorites, Integer> {
	
	@Modifying
	@Query("delete from Favorites where hotelId = ?1")
	public void deleteUserFavRestaurent(int hotelId);

}
