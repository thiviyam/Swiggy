package com.example.demo.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.HotelsDao;
import com.example.demo.dao.MenuDao;
import com.example.demo.models.Hotels;
import com.example.demo.models.Menus;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("hotel")
public class HotelController {
	
	@Autowired
	HotelsDao hdao;
	
	@Autowired
	MenuDao mdao;
	
	@PostMapping("/addHotel")
	public String addHotel(@RequestBody Hotels h, Menus menu) {
		
		hdao.save(h);
		return "yeah";
	}
	
	@GetMapping("/displayHotels")
	public List<Hotels> getHotels() {
		
		List<Hotels> allHotel = hdao.getAllHotels();
		
		for (Iterator iterator = allHotel.iterator(); iterator.hasNext();) {
			Hotels hotels = (Hotels) iterator.next();
		}
		
		return allHotel;
	}
	
	@GetMapping("/getHotelsByRatings")
	public List<Hotels> getHotelsByRatings() {
		
		List<Hotels> allHotel = hdao.getHotelAccordingToRating();
		
		for (Iterator iterator = allHotel.iterator(); iterator.hasNext();) {
			Hotels hotels = (Hotels) iterator.next();
		}
		
		return allHotel;
	}
	
	@GetMapping("/getHotelsByCostLowToHigh")
	public List<Hotels> getHotelsByCostLowToHigh() {
		
		List<Hotels> allHotel = hdao.getHotelAccordingToCostAsc();
		
		for (Iterator iterator = allHotel.iterator(); iterator.hasNext();) {
			Hotels hotels = (Hotels) iterator.next();
		}
		
		return allHotel;
	}
	
	@GetMapping("/getHotelsByCostHighToLow")
	public List<Hotels> getHotelsByCostHighToLow() {
		
		List<Hotels> allHotel = hdao.getHotelAccordingToCostDesc();
		
		for (Iterator iterator = allHotel.iterator(); iterator.hasNext();) {
			Hotels hotels = (Hotels) iterator.next();
		}
		
		return allHotel;
	}

}
