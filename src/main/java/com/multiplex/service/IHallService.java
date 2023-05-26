package com.multiplex.service;

import java.util.List;

import com.multiplex.entity.Hall;
import com.multiplex.exception.HallAlreadyExistException;
import com.multiplex.exception.HallNotFoundException;



public interface IHallService {

	public Hall addHall(Hall hall) throws Exception;

	public void deleteHall(Integer id) throws HallNotFoundException;

	public Hall updateHall(Hall hall) throws Exception;

	public List<Hall> getHall();

	public Hall getHallById(Integer id) throws HallNotFoundException;

}
