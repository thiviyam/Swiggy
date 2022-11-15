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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CartDao;
import com.example.demo.dao.FavoritesDao;
import com.example.demo.dao.ThreadDao;
import com.example.demo.dao.UserAddrDao;
import com.example.demo.dao.UserDetails;
import com.example.demo.models.Cart;
import com.example.demo.models.Favorites;
import com.example.demo.models.LoginCrenditials;
import com.example.demo.models.ThreadUser;
import com.example.demo.models.UpdateCart;
import com.example.demo.models.UserAddress;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("login")
public class LoginController {
	
	String user = "";
	long ph = 0;
	
	@Autowired
	UserDetails udao;
	
	@Autowired
	UserAddrDao uadao;
	
	@Autowired
	FavoritesDao fdao;
	
	@Autowired
	CartDao cdao;
	
	@Autowired
	ThreadDao tdao;
	
	@PostMapping("/signup")
	public String signup(@RequestBody LoginCrenditials l) {
		
		udao.save(l);
		
		ph = l.getPhoneNumber();
		user = l.getCname();
		
		int userGenId = 0;
		Boolean userAvailable = true;

		List<ThreadUser> activeUsers =  tdao.getAllActiveUser();

		for (ThreadUser threadUser : activeUsers) {
			if(threadUser.getUserId() == ph) {
				userAvailable = false;
				break;
			}
		}

		if(userAvailable) {
			ThreadUser tu = new ThreadUser();
			tu.setUserId(ph);
			tu.setUserName(user);

			ThreadUser t = tdao.save(tu);
			userGenId = t.getId();
		}
		
		return l.getCname();
	}
	
	@PostMapping("/loginn")
	public String login(@RequestBody LoginCrenditials l) {
		
		String cname = udao.userExistByPhno(l.getPhoneNumber());
		
		if(cname != null) {
		   user = cname;
		   ph = l.getPhoneNumber();
		   int userGenId = 0;
		   Boolean userAvailable = true;
		   
		   List<ThreadUser> activeUsers =  tdao.getAllActiveUser();
		   
		   for (ThreadUser threadUser : activeUsers) {
			   if(threadUser.getUserId() == ph) {
				   userAvailable = false;
				   break;
			   }
		   }
		   
		   if(userAvailable) {
			   ThreadUser tu = new ThreadUser();
			   tu.setUserId(ph);
			   tu.setUserName(user);

			   ThreadUser t = tdao.save(tu);
			   userGenId = t.getId();
		   }
			
		    return cname;
		    
		}else {
			return null;
		}
	}

	@GetMapping("/user")
	public String user() {		
		return user;
	}
	
	@GetMapping("/getCart")
	public List<Cart> getCart() {
		
		List<Cart> c = cdao.getAllFromCartByPh(ph);
		return c;
	}
	
	@PostMapping("/signout")
	public String signout(String cname) {
		user = cname;
		ph = 0;
		
		tdao.deleteAll();
		cdao.deleteByUserId(0);
		return user;
	}
	
	@GetMapping("/userInfo")
	public List<LoginCrenditials> userInfo() {
		
		List<LoginCrenditials> userinfo = udao.getUserDetails(ph);
		return userinfo;
	}
	
	@PostMapping("/update")
	public String update(@RequestBody LoginCrenditials l) {
		udao.save(l);
		return "yes";
	}
	
	@PostMapping("/addToCart")
	public int addToCart(@RequestBody Cart cart) {
		
		cart.setUserid(ph);
		Cart c = cdao.save(cart);
				
		int id = c.getId();
		
		return id;
	}
	
	@PostMapping("/updateToCart")
	public void updateToCart(@RequestBody UpdateCart up) {
		
		Cart c = cdao.getCartForUpdate(up.getMenuid(), ph);		
		c.setQuantity(up.getQuantity());
		
		cdao.save(c);		
	}
	
	@DeleteMapping("/clearCart")
	public void clearCart() {
		cdao.deleteCartByUserId(ph);
	}
	
	public String getUser() {
		return user;
	}

	public long getPh() {
	    System.out.println(ph);
		return ph;
	}
	
	@PostMapping("/saveUserAddress")
	public void saveUserAddress(@RequestBody UserAddress ud) {
		
		
		List<LoginCrenditials> userLogin = udao.getUserDetails(ph);
		
		for (LoginCrenditials loginCrenditials : userLogin) {
			
			if(loginCrenditials.getAddress() != null) {
				
				Set<UserAddress> udSet = loginCrenditials.getAddress();
				udSet.add(ud);
				loginCrenditials.setAddress(udSet);
				
				uadao.save(ud);
				udao.save(loginCrenditials);
				
				System.out.println(loginCrenditials);
				
			}else {
				
				Set<UserAddress> udSet = new HashSet<UserAddress>();
				udSet.add(ud);
				loginCrenditials.setAddress(udSet);
				
				uadao.save(ud);
				udao.save(loginCrenditials);
				
				System.out.println(loginCrenditials);
			}
		}
		
		
	}
	
	@PostMapping("/addUserFavRestaurent")
	public void addUserFavRestaurent(@RequestBody Favorites fav) {
		
        List<LoginCrenditials> userLogin = udao.getUserDetails(ph);
		
		for (LoginCrenditials loginCrenditials : userLogin) {
			
			if(loginCrenditials.getFav() != null) {
				
				Set<Favorites> udSet = loginCrenditials.getFav();
				udSet.add(fav);
				loginCrenditials.setFav(udSet);
				
				fdao.save(fav);
				udao.save(loginCrenditials);
				
				System.out.println(loginCrenditials);
				
			}else {
				
				Set<Favorites> udSet = new HashSet<Favorites>();
				udSet.add(fav);
				loginCrenditials.setFav(udSet);
				
				fdao.save(fav);
				udao.save(loginCrenditials);
				
				System.out.println(loginCrenditials);
			}
		}
	}
	
	@GetMapping("/getUserFav")
	public List<LoginCrenditials> getUserFav() {
		
        List<LoginCrenditials> userLogin = udao.getUserDetails(ph);
        return userLogin;
	}
	
	@DeleteMapping("/userFavRestaurentNolongerFavAnymore/{hOtelId}")
	public void userFavRestaurentNolongerFavAnymore(@PathVariable ("hOtelId") int hOtelId) {
		
		fdao.deleteUserFavRestaurent(hOtelId);
		
	}

}
