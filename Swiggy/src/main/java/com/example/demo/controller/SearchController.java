package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.HotelsDao;
import com.example.demo.dao.MenuDao;
import com.example.demo.models.Hotels;
import com.example.demo.models.Menus;
import com.example.demo.models.SearchSugg;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("search")
public class SearchController {

	@Autowired
	HotelsDao hdao;
	
	@Autowired
	MenuDao mdao;
	
	@PostMapping("/hotelSugg")
	public List<Hotels> hotelSugg(@RequestBody String tarvalu) {
		
		String[] text = tarvalu.split("=", 20);
		
		if(text[0] != "=" && text[0] != " ") {
			List<Hotels> hotelSuggestions = hdao.searchByHotelNameSugg(text[0]);
			return hotelSuggestions;
		}else {
			return null;
		}
	}
	
	@PostMapping("/menuSugg")
	public List<Menus> menuSugg(@RequestBody String tarvalu) {
		
		String[] text = tarvalu.split("=", 20);
		
		if(text[0] != "=" && text[0] != " ") {
			List<Menus> menuSuggestions = mdao.searchByMenuNameSugg(text[0]);
			return menuSuggestions;
		}else {		
			return null;
		}
	}
	
	@PostMapping("/menuSugginsideHotel")
	public List<Menus> menuSugginsideHotel(@RequestBody SearchSugg srch) {
		
//		String[] text = tarvalu.split("=", 20);
//		
//		if(text[0] != "=" && text[0] != " ") {
//			List<Menus> menuSuggestions = mdao.searchForMenuByHotelIdSugg(tarvalu, 0);
//			return menuSuggestions;
//		}else {		
//			return null;
//		}
		System.out.println(srch);
		List<Menus> menuSuggestions = hdao.searchForMenuByHotelIdSugg(srch.getTarvalu(), srch.getHotelID());
		for (Menus menus : menuSuggestions) {
			System.out.println(menus);
		}
		return menuSuggestions;
	}
}
