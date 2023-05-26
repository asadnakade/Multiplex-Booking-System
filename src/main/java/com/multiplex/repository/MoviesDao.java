package com.multiplex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiplex.entity.Movies;

public interface MoviesDao extends JpaRepository<Movies, Integer> {

	public Movies findByMovieName(String movieName);

	public Movies findByMovieId(int movieId);


}