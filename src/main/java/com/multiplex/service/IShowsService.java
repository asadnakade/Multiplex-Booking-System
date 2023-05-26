package com.multiplex.service;

import java.util.List;

import com.multiplex.entity.Shows;
import com.multiplex.exception.ShowAlreadyExistException;
import com.multiplex.exception.ShowNotFoundException;



public interface IShowsService {

	public List<Shows> getShows();

	public Shows addShows(Shows addshow) throws Exception;

	public Shows updateShows(Shows updateshow) throws Exception;

	public void deleteShowsById(Integer showid) throws ShowNotFoundException;

	public Shows getShowById(Integer showid) throws ShowNotFoundException;

}
