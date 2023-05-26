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

import com.multiplex.entity.Shows;
import com.multiplex.exception.ShowNotFoundException;
import com.multiplex.service.IShowsService;


@RestController
@RequestMapping("/multiplex")
public class ShowsController {

	@Autowired
	IShowsService showService;
	
	
	//We fetched data from database

	@GetMapping("/shows")
	public List<Shows> getShows() {
		
		return this.showService.getShows();
	}


	
	//We get particular index data from database

	@GetMapping("/shows/{showId}")
	public Shows getShowById(@PathVariable Integer showId) throws ShowNotFoundException {
		return this.showService.getShowById((showId)); // getCourse will call Service method
	}
	
	
	//We Insert Data into database

	@PostMapping("/shows")
	public String addShows(@RequestBody Shows addShow) throws Exception{
		
		int a = addShow.getAdminId();
		
		if( a!=0) {
			return "Show Not Added\nYou Are Not Admin";

		}	
		showService.addShows(addShow);
		return "Show Added Successfully";
		
		
		
		//return new ResponseEntity<>(HttpStatus.OK);	
	}
	
	
	//We Update the data into database

	@PutMapping("/shows")
	public String updateShows(@RequestBody Shows updateShow) throws Exception {
		int a = updateShow.getAdminId();
		if(a!=0) {
		return "Show Not Updated\\nYou Are Not Admin";
		}
		showService.updateShows(updateShow);
		return "Show Updated";

	}
	
	
	//We delete data from database by giving index

	@DeleteMapping("/shows/{showId}/0/pass@123")
	public String deleteShowsById(@PathVariable Integer showId) throws ShowNotFoundException {
		
		
		try {
			this.showService.deleteShowsById(showId);
			return "Show Deleted Successfully";
		}catch (Exception e) {
		return "Show Not Found";
	}
		
		
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exceptionHandler(Exception ex){
		return ResponseEntity.ok(ex.getMessage());
	}
		

}
