package com.multiplex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.multiplex.entity.Hall;
import com.multiplex.exception.HallNotFoundException;
import com.multiplex.service.IHallService;

//RestController annotation is applied to a class to mark it as a request handler, 
//and Spring will do the building and provide the RESTful web service at runtime.
//@RequestMapping the value parameter is used to specify the path.
@RestController
@RequestMapping("/multiplex")
public class HallController {

	@Autowired
	private IHallService ihallservice;
	
	
	
	//We Insert Data into database

	@PostMapping("/halls")
	public String addHall(@RequestBody Hall hall) throws Exception {
		
		int a = hall.getAdminId();
		
		if(a!=0) {
			return "Hall Not Added\nYou are not Admin";
			
		}
			ihallservice.addHall(hall);
			return "Hall Added Successfully";
	
		
		
		
		
		
	}
	
	
	//We fetched data from database

	@GetMapping("/halls")
	public List<Hall> getHall() {
		return this.ihallservice.getHall();
	}
	
	//We Update the data into database
	
	@PutMapping("/halls")
	public String updateHall(@RequestBody Hall hall) throws Exception {
		int a = hall.getAdminId();
		if(a!=0) {
			return "Hall Not Updated\nYou Are Not Admin";
		}
		ihallservice.updateHall(hall);
		return "Hall Updated Successfully";
	}
	
	//We delete data from database by giving index

	@DeleteMapping("/halls/{hallId}/0/pass@123")
	public String deleteHall(@PathVariable Integer hallId) throws HallNotFoundException {
		try {

				this.ihallservice.deleteHall(hallId);
				return "Hall Deleted Successfully";
			}catch (Exception e) {
			return "Hall Not Found";
		}
	}
	
	
	//We get particular index data from database
	@GetMapping("/halls/{hallId}")
	public Hall getHallById(@PathVariable Integer hallId) throws HallNotFoundException {
		return ihallservice.getHallById(hallId);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exceptionHandler(Exception ex){
		return ResponseEntity.ok(ex.getMessage());
	}
}
