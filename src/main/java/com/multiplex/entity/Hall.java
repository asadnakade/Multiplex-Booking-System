package com.multiplex.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "hall")
public class Hall {

	@Id
	@Column(name = "hallId")
	private Integer hallId;
	@Column(name = "hallDesc")
	private String hallDesc;
	@Column(name="AdminId")
	private int adminId;
	@Column(name = "totalCapacity")
	private Integer totalCapacity;

	public Hall() {
		super();
	}

	public Hall(Integer hallId,int adminId, String hallDesc, Integer totalCapacity,String password) {
		super();
		this.hallId = hallId;
		this.adminId=adminId;
		this.hallDesc = hallDesc;
		this.totalCapacity = totalCapacity;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public Integer getHallId() {
		return hallId;
	}

	public void setHallId(Integer hallId) {
		this.hallId = hallId;
	}

	public String getHallDesc() {
		return hallDesc;
	}

	public void setHallDesc(String hallDesc) {
		this.hallDesc = hallDesc;
	}

	public Integer getTotalCapacity() {
		return totalCapacity;
	}

	public void setTotalCapacity(Integer totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

	
}
