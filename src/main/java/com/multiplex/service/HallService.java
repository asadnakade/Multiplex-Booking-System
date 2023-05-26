package com.multiplex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.entity.Hall;
import com.multiplex.entity.Movies;
import com.multiplex.exception.HallAlreadyExistException;
import com.multiplex.exception.HallIdNotFoundException;
import com.multiplex.exception.HallLimitExceedException;
import com.multiplex.exception.HallNotFoundException;
import com.multiplex.exception.MOvieIdNotFoundException;
import com.multiplex.repository.HallDao;


@Service
public class HallService implements IHallService {

	@Autowired
	private HallDao halldao;

	@Override
	public Hall addHall(Hall hall) throws Exception {
		
		int id = hall.getHallId();
		if(id > 4) {
			throw new HallLimitExceedException("No Hall Available");
		}
		
		List<Hall> list = halldao.findAll();
		for (Hall h : list) {
			if (h.getHallId() == hall.getHallId()) {
				throw new HallAlreadyExistException("Hall already exists...");
			}
		}
		return halldao.save(hall);
	}

	@Override
	public Hall updateHall(Hall hall) throws Exception {
		Hall check= halldao.findByHallId(hall.getHallId());
		if(check != null) {
			throw new HallIdNotFoundException("Movie ID Not Found.");
		}
		halldao.save(hall);
		return hall;
	}

	@Override
	public List<Hall> getHall() {
		return halldao.findAll();
	}

	@Override
	public void deleteHall(Integer hallId) throws HallNotFoundException {
		try {
			halldao.deleteById(hallId);
		} catch (Exception e) {
			throw new HallNotFoundException("Hall not found...");
		}
	}

	@Override
	public Hall getHallById(Integer hallId) throws HallNotFoundException {
		try {
			return halldao.findById(hallId).get();
		} catch (Exception e) {
			throw new HallNotFoundException("Hall not found...");
		}
	}
}
