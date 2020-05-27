package com.infy.verizon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AirportDAOException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public AirportDAOException(String message){
		super(message);
	}
	
}
