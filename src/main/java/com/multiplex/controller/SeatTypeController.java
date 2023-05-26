package com.multiplex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiplex.entity.SeatType;
import com.multiplex.entity.User;
import com.multiplex.exception.HallAlreadyExistException;
import com.multiplex.exception.SeatTypeAlreadyExistException;
import com.multiplex.exception.SeatTypeNotFoundException;
import com.multiplex.service.ISeatTypeService;

//RestController annotation is applied to a class to mark it as a request handler, 
//and Spring will do the building and provide the RESTful web service at runtime.
//@RequestMapping the value parameter is used to specify the path.
@RestController
@RequestMapping("/multiplex")
public class SeatTypeController {

	@Autowired
	ISeatTypeService seattypeservice;
	
	
	
	//We fetched data from database

	@GetMapping("/seatTypes")
	public List<SeatType> getAllSeatTypes() {
		return seattypeservice.getAllSeatTypes();
	}

	
	//We Insert Data into database

	@PostMapping("/seatTypes")
	public String addSeatType(@RequestBody SeatType seatType)throws SeatTypeAlreadyExistException {
		
		
		int a = seatType.getAdminId();
		
		if(a!=0) {
			return "SeatType Not Added\nYou are not Admin";
			
		}
		try {
			seattypeservice.addSeatType(seatType);
			return "Seattype Added Successfully";
		}catch(Exception e) {
			return "Seattype Already Exist";
		}
		
	}

	
	//We get particular index data from database
	@GetMapping("/seatTypes/{seatTypeId}")
	public SeatType getSeatType(@PathVariable Integer seatTypeId) throws SeatTypeNotFoundException {
		return seattypeservice.getSeatType(seatTypeId);
	}
	
	
	//We Update the data into database
	@PutMapping("/seatTypes")
	public String updateSeatType(@RequestBody SeatType seatType) {
		
		
		int a = seatType.getAdminId();
		if(a!=0) {
		return "Show Not Updated\\nYou Are Not Admin";
		}
		seattypeservice.updateSeatType(seatType);
		return "Show Updated";
		
	}

	
	//We delete data from database by giving index
	@DeleteMapping("/seatTypes/{seatTypeId}/0/pass@123")
	public String deleteCourse(@PathVariable Integer seatTypeId) throws SeatTypeNotFoundException {
		
		try {
			this.seattypeservice.deleteSeatType(seatTypeId);
			return "SeatType Deleted Successfully";
		}catch (Exception e) {
		return "SeatType Not Found";
	}
		
		
	}

}
