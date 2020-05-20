package com.infy.verizon.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionController {
	
	private Logger logger = LogManager.getLogger(GlobalExceptionController.class);
	
	
	@ExceptionHandler(value=Exception.class)
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleException(HttpServletRequest request, Exception e) {
		logger.error("Request " + request.getRequestURL() + " Threw an Exception" , e);
		return "application/home";
	}
}
