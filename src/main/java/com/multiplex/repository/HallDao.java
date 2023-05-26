package com.multiplex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiplex.entity.Hall;
import com.multiplex.entity.Movies;

public interface HallDao extends JpaRepository<Hall, Integer> {

	Hall findByHallId(Integer hallId);


	
	

	

}