package com.multiplex.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "seatType")
public class SeatType {

	@Id
	@Column(name = "seatTypeId")
	private int seatTypeId;
	
	@Column(name = "AdminId")
	private int adminId;
	
	
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}


	@Column(name = "seatTypeDesc")
	private String seatTypeDesc;
	
	@Column(name = "seatFare")
	private float seatFare;

	public SeatType() {
		super();
	}

	public SeatType(int seatTypeId,int adminId,String password, String seatTypeDesc, float seatFare) {
		super();
		this.adminId= adminId;
		this.seatTypeId = seatTypeId;
		this.seatTypeDesc = seatTypeDesc;
		this.seatFare = seatFare;
	}

	public int getSeatTypeId() {
		return seatTypeId;
	}

	public void setSeatTypeId(int seatTypeId) {
		this.seatTypeId = seatTypeId;
	}

	public String getSeatTypeDesc() {
		return seatTypeDesc;
	}

	public void setSeatTypeDesc(String seatTypeDesc) {
		this.seatTypeDesc = seatTypeDesc;
	}

	public float getSeatFare() {
		return seatFare;
	}

	public void setSeatFare(float seatFare) {
		this.seatFare = seatFare;
	}
	
}