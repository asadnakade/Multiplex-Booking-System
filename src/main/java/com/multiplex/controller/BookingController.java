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

import com.multiplex.entity.Booking;
import com.multiplex.exception.BookingAlreadyExistException;
import com.multiplex.exception.BookingNotFoundException;
import com.multiplex.service.IBookingService;



@RestController

//RestController annotation is applied to a class to mark it as a request handler, 
//and Spring will do the building and provide the RESTful web service at runtime.


@RequestMapping("/multiplex")
//@RequestMapping the value parameter is used to specify the path.
public class BookingController {
	
	@Autowired
	IBookingService bookingService;
	
	
	
//	We fetched data from database
	
	@GetMapping("/bookings")
	public List<Booking> getAllBookings() {
		return bookingService.getAllBookings();
	}
	
	
//	We Insert Data into database
	
	@PostMapping("/bookings")
	public String addBooking(@RequestBody Booking booking) throws BookingAlreadyExistException {
		
		try {
			bookingService.addBooking(booking);
			return "Booking Successfully";
			}catch(Exception e) {
				return "Booking Already Done";
			}		
	}
	
	
//	We Update the data into database
	
	@PutMapping("/bookings")
	public Booking updateBooking(@RequestBody Booking booking) {
		return bookingService.updateBooking(booking);
	}
	

//	We get particular index data from database
	
	@GetMapping("/bookings/{bookingId}")
	public Booking getBookingById(@PathVariable Integer bookingId) throws BookingNotFoundException {
		return bookingService.getBookingById(bookingId);
	}
	
	
//	We delete data from database by giving index
	
	@DeleteMapping("/bookings/{bookingId}")
	public String deleteBookingById(@PathVariable Integer bookingId)
			throws BookingNotFoundException {
		try {
			bookingService.deleteBookingById(bookingId);
			return "Booking Cancel";
		} catch (Exception e) {
			return "Booking Not Found";
		}
	}
}
