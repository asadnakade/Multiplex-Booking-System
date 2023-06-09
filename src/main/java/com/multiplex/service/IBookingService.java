package com.multiplex.service;

import java.util.List;

import com.multiplex.entity.Booking;
import com.multiplex.exception.BookingAlreadyExistException;
import com.multiplex.exception.BookingNotFoundException;



public interface IBookingService {

	public List<Booking> getAllBookings();

	public Booking addBooking(Booking booking) throws BookingAlreadyExistException;

	public Booking updateBooking(Booking booking);

	public Booking getBookingById(Integer bookingId) throws BookingNotFoundException;

	public void deleteBookingById(Integer bookingId) throws BookingNotFoundException;

}
