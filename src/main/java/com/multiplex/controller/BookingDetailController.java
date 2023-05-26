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

import com.multiplex.entity.BookingDetail;
import com.multiplex.exception.BookingDetailNotFoundException;
import com.multiplex.service.IBookingDetailsService;

//RestController annotation is applied to a class to mark it as a request handler, 
//and Spring will do the building and provide the RESTful web service at runtime.
//@RequestMapping the value parameter is used to specify the path.

@RestController
@RequestMapping("/multiplex")
public class BookingDetailController {
	@Autowired
	IBookingDetailsService bookingDetailService;


	
//	We fetched data from database

	@GetMapping("/bookingDetails")
	public List<BookingDetail> getAllBookingDetails() {
		
		return bookingDetailService.getAllBookingDetails();
	}

	
//	We Insert Data into database

	@PostMapping("/bookingDetails")
	public BookingDetail addBookingDetail(@RequestBody BookingDetail bookingDetail) {
		return bookingDetailService.addBookingDetail(bookingDetail);
		
		
	}

	
//	We get particular index data from database

	@GetMapping("/bookingDetail/{noOfSeats}")
	public BookingDetail getBookingDetail(@PathVariable Integer noOfSeats) throws BookingDetailNotFoundException {

		return bookingDetailService.getBookingDetail(noOfSeats);
	}

	
//	We Update the data into database

	@PutMapping("/bookingDetails")
	public String updateBookingDetail(@RequestBody BookingDetail bookingDetail) {
		bookingDetailService.updateBookingDetail(bookingDetail);
		return "Bookind Details updated";
	}

//	We delete data from database by giving index
	
	@DeleteMapping("/bookingDetails/{noOfSeats}")
	public String deleteBookingDetail(@PathVariable Integer noOfSeats) throws BookingDetailNotFoundException{
		try {
			bookingDetailService.deleteBookingDetail(noOfSeats);
			return "Booking Details Deleted";
		} catch (Exception e) {
			return "Booking Details Not Found";
		}
	}
}