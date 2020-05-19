package com.infy.verizon.utility;

import java.util.Formatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.infy.verizon.model.Booking;


@Component
@Aspect
public class LoggingAspect {

	@AfterThrowing(pointcut = "execution(* com.infy.verizon.dao.*Impl.*(..))", throwing = "exception")	
	public void logExceptionFromDAO(Exception exception) throws Exception {
		log(exception);
	}
	
	@AfterThrowing(pointcut = "execution(* com.infy.verizon.service.*Impl.*(..))", throwing = "exception")	
	public void logExceptionFromService(Exception exception) throws Exception {
			log(exception);
	}
	
	
	private void log(Exception exception) {
		Logger logger = LogManager.getLogger(this.getClass());
		if(exception.getMessage()!=null && 
				(exception.getMessage().contains("Service") || exception.getMessage().contains("Validator"))){
			logger.error(exception.getMessage());
		}
		else{
			logger.error(exception.getMessage(), exception);
		}
	}
	@Before("execution(* com.infy.verizon.api.BookingAPI.addNewBooking(..)) && args(booking)")
	public void logBeforeNewBooking(JoinPoint joinPoint, Booking booking){
		Logger logger = LogManager.getLogger(this.getClass());
		logger.info("A new booking is being attempted by traveler: {}", booking.getTraveler().getLoginId());
	}
	
	@After("execution(* com.infy.verizon.api.BookingAPI.addNewBooking(..)) && args(booking)")
	public void logAfterNewBooking(JoinPoint joinPoint, Booking booking){
		Logger logger = LogManager.getLogger(this.getClass());
		logger.info("Booking was successfuly made by: {}", booking.getTraveler().getLoginId());
	}

}
