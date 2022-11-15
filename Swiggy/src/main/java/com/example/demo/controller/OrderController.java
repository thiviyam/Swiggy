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

import com.example.demo.dao.CartDao;
import com.example.demo.dao.HotelsDao;
import com.example.demo.dao.OrdersDao;
import com.example.demo.dao.ThreadDao;
import com.example.demo.models.Cart;
import com.example.demo.models.Hotels;
import com.example.demo.models.Menus;
import com.example.demo.models.OrderedMenu;
import com.example.demo.models.Orders;
import com.example.demo.models.ThreadUser;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("order")
public class OrderController {

	@Autowired
	OrdersDao odao;
	
	@Autowired
	ThreadDao tdao;
	
	@Autowired
	HotelsDao hdao;
	
	@Autowired
	CartDao cdao;
	
	//note that it has been assign before usage
	long userid = 0;
	
	@GetMapping("/getAllOrders")
	public List<Orders> getAllOrders() {
		
		List<ThreadUser> user = tdao.findAll();		
		
		for (ThreadUser threadUser : user) {
			userid = threadUser.getUserId();
		}
		
		List<Orders> o = odao.getAllOrdersByUserId(userid);
		return o;
		
	}
	
	@PostMapping("/reOrder")
	public void reOrder(@RequestBody String orderId) {
		
		String[] s = orderId.split("=", 8);
		long oID = Long.parseLong(s[0]);
		
		List<Cart> cartExist = cdao.getAllFromCartByPh(userid);
		if(cartExist != null) {
			cdao.deleteCartByUserId(userid);
		}
		
		Orders o = odao.getOrderByUserIdAndOrderId(userid, oID);
		Hotels hotel = hdao.getHotelById(o.getHotelId());
		Set<Menus> menus = hotel.getMenu();
		Set<OrderedMenu> orderMenu = o.getMenu();
		
		
		
		for (OrderedMenu om : orderMenu) {
			System.out.println("1" +om.getMenuId());
			for (Menus m : menus) {
				if(om.getMenuId() == m.getId()) {
					
					Cart cart = new Cart();
					cart.setHid(hotel.getId());
					cart.setUserid(userid);
					cart.setQuantity(om.getQuantity());
					cart.setCartitem(m);
					
					cdao.save(cart);
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
}
