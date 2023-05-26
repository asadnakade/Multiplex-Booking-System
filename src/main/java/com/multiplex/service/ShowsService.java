package com.multiplex.service;

import com.multiplex.entity.Shows;
import com.multiplex.exception.ShowAlreadyExistException;
import com.multiplex.exception.ShowIdExistException;
import com.multiplex.exception.ShowIdNotFoundException;
import com.multiplex.exception.ShowNotFoundException;
import com.multiplex.exception.SlotUnavailavleException;
import com.multiplex.exception.SlottPresentException;
import com.multiplex.repository.ShowsDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ShowsService implements IShowsService {

	@Autowired
	ShowsDao showsdao;

	// get
	@Override
	public List<Shows> getShows() {
		return showsdao.findAll();
	}

	// searchById
	@Override
	public Shows getShowById(Integer showid) throws ShowNotFoundException {
		try {
			return showsdao.findById(showid).get();
		} catch (Exception e) {
			throw new ShowNotFoundException("Show not found...");
		}
	}

	// post
	@Override
	public Shows addShows(Shows addshow) throws Exception {
		
		Shows check = showsdao.findBySlotNo(addshow.getSlotNo());
		
		Shows id = showsdao.findByShowId(addshow.getShowId());
		
		int val = addshow.getSlotNo();
		if(id!=null) {
			throw new ShowIdExistException("Show ID Already Exist");
		}
		
		if(val > 4) {
			throw new SlotUnavailavleException("Slot Unavialable");
		}
		
		
		if(check != null) {
			throw new SlottPresentException("Slot Already Exist");
		}
		
		List<Shows> list = showsdao.findAll();
		for (Shows s : list) {
			if (s.getShowId() == addshow.getShowId()) {
				throw new ShowAlreadyExistException("Show already exists...");
			}
		}
		return showsdao.save(addshow);
	}

	// put
	@Override
	public Shows updateShows(Shows updateshow) throws Exception {
		Shows id = showsdao.findByShowId(updateshow.getShowId());
		if(id == null) {
			throw new ShowIdNotFoundException("Show ID Not Found");
		}

		showsdao.save(updateshow);
		return updateshow;
	}

	// delete
	@Override
	public void deleteShowsById(Integer showid) throws ShowNotFoundException {
		try {
			showsdao.deleteById(showid);
		} catch (Exception e) {
			throw new ShowNotFoundException("Show not found...");
		}
	}
}
