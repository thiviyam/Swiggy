package com.example.demo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CartDao;
import com.example.demo.dao.MenuDao;
import com.example.demo.dao.OrderedMenuDao;
import com.example.demo.dao.OrdersDao;
import com.example.demo.dao.ThreadDao;
import com.example.demo.models.Cart;
import com.example.demo.models.Menus;
import com.example.demo.models.OrderedMenu;
import com.example.demo.models.Orders;
import com.example.demo.models.ThreadUser;
import com.example.demo.models.UpdateCart;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("cart")
public class CartController extends LoginController {
	
	@Autowired
	CartDao cdao;
	
	@Autowired
	MenuDao mdao;
	
	@Autowired
	OrdersDao odao;
	
	@Autowired
	OrderedMenuDao omdao;
	
	@Autowired
	ThreadDao tdao;
	
	@GetMapping("/getcartItem/{id}")
	public Cart getcartItem(@PathVariable("id") int menuid) {
		
		List<ThreadUser> user = tdao.findAll();
		long userid = 0;
		
		for (ThreadUser threadUser : user) {
			userid = threadUser.getUserId();
		}
		
		Cart c = cdao.getAllByMenuId(menuid, userid);
		return c;
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int menuid) {
		List<ThreadUser> user = tdao.findAll();
		long userid = 0;
		
		for (ThreadUser threadUser : user) {
			userid = threadUser.getUserId();
		}
		
		Cart c = cdao.getAllByMenuId(menuid, userid);
		cdao.delete(c);
		
	}
	
	@GetMapping("/getCartItem")
	public List<Cart> getCartItem() {
		
		List<ThreadUser> user = tdao.findAll();
		long userid = 0;
		
		for (ThreadUser threadUser : user) {
			userid = threadUser.getUserId();
		}
		
		List<Cart> c = cdao.getAllFromCartByPh(userid);
		return c;
	}
	
	@PostMapping("/ordered")
	public void ordered() {
		List<ThreadUser> user = tdao.findAll();
		long userid = 0;
		
		for (ThreadUser threadUser : user) {
			userid = threadUser.getUserId();
		}
		
		List<Cart> c = cdao.getAllFromCartByPh(userid);
		Set<OrderedMenu> set = new HashSet<OrderedMenu>();
		
		OrderedMenu om[] = new OrderedMenu[c.size()];
		int i = 0, sum=0, hid = 0;
		
		for (Cart cart : c) {
			om[i] = new OrderedMenu();
			om[i].setMenuId(cart.getCartitem().getId());
			om[i].setQuantity(cart.getQuantity());
			
			set.add(om[i]);
			sum += cart.getQuantity() * cart.getCartitem().getPrice();
			hid = cart.getHid();
			
			omdao.save(om[i]);
			++i;
		}
		
		Orders o = new Orders();
		o.setHotelId(hid);
		o.setUserId(userid);
		o.setMenu(set);
		o.setTotalPrice(sum);
		
		odao.save(o);
		cdao.deleteByUserId(userid);
	}

}
