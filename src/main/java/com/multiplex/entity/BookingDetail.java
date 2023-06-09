package com.multiplex.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bookingDetail")
public class BookingDetail {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "noOfSeats")
	private int noOfSeats;

	@OneToOne
	@JoinColumn(name="bookingId")
	private Booking booking;

	@OneToOne
	@JoinColumn(name = "seatTypeId")
	private SeatType seatType;

	public BookingDetail() {
		super();
	}

	public BookingDetail(int id, int noOfSeats, Booking booking, SeatType seatType) {
		super();
		this.id = id;
		this.noOfSeats = noOfSeats;
		this.booking = booking;
		this.seatType = seatType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public SeatType getSeatType() {
		return seatType;
	}

	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}

}