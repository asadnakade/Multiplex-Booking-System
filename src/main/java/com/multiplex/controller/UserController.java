package com.multiplex.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiplex.entity.User;
import com.multiplex.exception.UserNotFoundException;
import com.multiplex.service.IUserService;

//RestController annotation is applied to a class to mark it as a request handler, 
//and Spring will do the building and provide the RESTful web service at runtime.
//@RequestMapping the value parameter is used to specify the path.
@RestController
@RequestMapping("/multiplex")
public class UserController {

	@Autowired
	private IUserService userService;
	
	
	//We Insert Data into database

	@PostMapping("/users")
	public String addUserDetails(@RequestBody User user) throws Exception {
		userService.addUserDetails(user);
		return "Registration Successfully";
	}
	
	
	//We fetched data from database

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	
	//We get particular index data from database

	@GetMapping("/users/{userId}")
	public User showUserDetails(@PathVariable("userId") int userId) throws UserNotFoundException {
		return userService.showUserDetails(userId);
		
	}
	
	
	//We Update the data into database

	@PutMapping("/users")
	public String updateUserDetails(@RequestBody User user) {
		userService.updateUserDetails(user);
		return "User Details Updated Successfully";
	}
	
	
	//We delete data from database by giving index

	@DeleteMapping("/users/{userId}")
	public String deleteUserDetails(@PathVariable("userId") int userId) throws UserNotFoundException {
		
		try {
			this.userService.deleteUserDetails(userId);
			return "Deleted Successfully";
		}catch (Exception e) {
		return "ID Not Found";
	}
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exceptionHandler(Exception ex){
		return ResponseEntity.ok(ex.getMessage());
	}

}
