package com.multiplex.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.multiplex.entity.UserLogin;
import com.multiplex.service.IUserLoginService;

//RestController annotation is applied to a class to mark it as a request handler, 
//and Spring will do the building and provide the RESTful web service at runtime.
//@RequestMapping the value parameter is used to specify the path.

@RestController
@RequestMapping("/multiplex")
public class UserLoginController {
	@Autowired
	IUserLoginService userloginservice;

	
	//We fetched data from database

	@GetMapping("/LoginUserss")
	public List<UserLogin> getAllUserLogin(){
		return this.userloginservice.getAllUserLogin();
	}
	//We Insert Data into database

	@PostMapping("/LoginUsers")
	public UserLogin addUserLogin(@RequestBody UserLogin userlogin) {
		return userloginservice.addUserLogin(userlogin);
	}
	//We Update the data into database

	@PutMapping("/LoginUsers")
	public UserLogin updateUserLogin(@RequestBody UserLogin userlogin) {
		return this.userloginservice.updateUserLogin(userlogin);
	}
	
	//We delete data from database by giving index

	@DeleteMapping("/LoginUsers/{userid}")
	public void deleteUserLoginById(@PathVariable Integer val) {
		this.userloginservice.deleteUserLoginById(val);
	}
	//We get particular index data from database

	@GetMapping("/LoginUsers/{id}")
	public UserLogin getUserLoginById(@PathVariable Integer userid) {
		return this.userloginservice.getUserLoginById(userid);
	}
}