package com.multiplex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiplex.entity.Movies;
import com.multiplex.entity.User;
import com.multiplex.exception.MovieAlreadyExistException;
import com.multiplex.exception.MovieNotFoundException;
import com.multiplex.repository.MoviesDao;
import com.multiplex.service.IMoviesService;

//RestController annotation is applied to a class to mark it as a request handler, 
//and Spring will do the building and provide the RESTful web service at runtime.
//@RequestMapping the value parameter is used to specify the path.

@RestController
@RequestMapping("/multiplex")
public class MoviesController {
	@Autowired
	private IMoviesService imoviesservice;
	
	//We Insert Data into database
	@PostMapping("/movies")
	public String addMovies(@RequestBody Movies movies) throws MovieAlreadyExistException{
		
		int a = movies.getAdminId();
			
		if(a!=0) {
			return "Movie Not Added\nYou are not Admin";
			
		}
			imoviesservice.addMovies(movies);
			return "Movie Added Successfully";

	}
		
		
	

	//We fetched data from database

	@GetMapping("/movies")
	public List<Movies> getMovies() {
		return imoviesservice.getMovies();
	}
	

	//We Update the data into database

	@PutMapping("/movies/{id}")
	
	public String updateMovies(@RequestBody Movies movies)throws Exception{
		int a = movies.getAdminId();
		
		if(a==0) {
		imoviesservice.updateMovies(movies);
		return "Movie Updated Successful";
		}
		return "Movie not Updated\nYou are not Admin";

		
	}
	
	
	//We delete data from database by giving index

	@DeleteMapping("/movies/{moviesId}/0/pass@123")
	public String deleteMovies(@PathVariable Integer moviesId ) throws MovieNotFoundException {
		try {

			this.imoviesservice.deleteMovies(moviesId);
			return "Movie Deleted Successfully";
		}catch (Exception e) {
		return "Movie Not Found";
	}
	}
	
	
	//We get particular index data from database

	@GetMapping("/movies/{moviesId}")
	public Movies getMoviesById(@PathVariable Integer moviesId) throws MovieNotFoundException {
		return imoviesservice.getMoviesById(moviesId);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exceptionHandler(Exception ex){
		return ResponseEntity.ok(ex.getMessage());
	}
}
