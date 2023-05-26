package com.multiplex.exception;

public class SeatTypeAlreadyExistException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public SeatTypeAlreadyExistException(String message) {
		super(message);
	}

}
