package com.multiplex.service;

import java.util.List;

import com.multiplex.entity.Movies;
import com.multiplex.exception.MovieAlreadyExistException;
import com.multiplex.exception.MovieNotFoundException;


public interface IMoviesService {
	public Movies addMovies(Movies movies) throws MovieAlreadyExistException;

	public void deleteMovies(Integer id) throws MovieNotFoundException;

	public Movies updateMovies(Movies movies) throws Exception;

	public List<Movies> getMovies();

	public Movies getMoviesById(Integer id) throws MovieNotFoundException;

}
