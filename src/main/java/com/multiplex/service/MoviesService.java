package com.multiplex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multiplex.entity.Movies;
import com.multiplex.exception.MOvieIdNotFoundException;
import com.multiplex.exception.MovieAlreadyExistException;
import com.multiplex.exception.MovieNotFoundException;
import com.multiplex.repository.MoviesDao;



@Service
public class MoviesService implements IMoviesService {

	@Autowired
	private MoviesDao moviesDao;
	

	@Override
	public Movies addMovies(Movies movies) throws MovieAlreadyExistException {
		
		Movies m = moviesDao.findByMovieName(movies.getMovieName());
		
		if(m != null) {
			throw new MovieAlreadyExistException("Movie name already present in database !! \nPlease try another one");
		}
		
			return moviesDao.save(movies);

	}

	@Override
	public Movies updateMovies(Movies movies) throws Exception {
		
		Movies check= moviesDao.findByMovieId(movies.getMovieId());
		if(check != null) {
			throw new MOvieIdNotFoundException("Movie ID Not Found.");
		}
		moviesDao.save(movies);
		return movies;
	}

	
	@Override
	public List<Movies> getMovies() {
		return moviesDao.findAll();
	}

	@Override
	public void deleteMovies(Integer moviesId) throws MovieNotFoundException {
		try {
			moviesDao.deleteById(moviesId);
		} catch (Exception e) {
			throw new MovieNotFoundException("Movie not found...");
		}
	}

	@Override
	public Movies getMoviesById(Integer moviesId) throws MovieNotFoundException {
		try {
			return moviesDao.findById(moviesId).get();
		} catch (Exception e) {
			throw new MovieNotFoundException("Movie not found...");
		}
	}

}
