package com.multiplex.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "movies")
public class Movies {

	@Id
	@Column(name = "movieId")
	private int movieId;

	@Column(name="AdminId")
	private int adminId;
	

	
	@Column(name = "movieName")
	private String movieName;
	


	public Movies() {
		super();
	}

	public Movies(int movieId,int adminId, String movieName, String password) {
		super();
		this.movieId = movieId;
		this.adminId = adminId;
		this.movieName = movieName;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}




}
