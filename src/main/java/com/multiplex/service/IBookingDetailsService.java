package com.multiplex.service;

import java.util.List;

import com.multiplex.entity.BookingDetail;
import com.multiplex.exception.BookingDetailNotFoundException;


public interface IBookingDetailsService {

	List<BookingDetail> getAllBookingDetails();

	BookingDetail addBookingDetail(BookingDetail bookingDetail);

	BookingDetail getBookingDetail(Integer noOfSeats) throws BookingDetailNotFoundException;

	BookingDetail updateBookingDetail(BookingDetail bookingDetail);

	void deleteBookingDetail(Integer noOfSeats) throws BookingDetailNotFoundException;

}
