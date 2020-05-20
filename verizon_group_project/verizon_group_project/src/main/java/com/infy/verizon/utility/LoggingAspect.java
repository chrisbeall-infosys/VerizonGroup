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

<<<<<<< HEAD
import com.infy.verizon.model.Admin;
import com.infy.verizon.model.Traveler;
=======
import com.infy.verizon.model.Booking;

>>>>>>> e1e0128c900216af56eec1eeee1755b457f91b29

@Component
@Aspect
public class LoggingAspect {

	Logger logger = LogManager.getLogger(this.getClass());

	//Service logging
	@AfterThrowing(pointcut = "execution(* com.infy.verizon.dao.*Impl.*(..))", throwing = "exception")
	public void logExceptionFromDAO(Exception exception) throws Exception {
		log(exception);
	}

	@AfterThrowing(pointcut = "execution(* com.infy.verizon.service.*Impl.*(..))", throwing = "exception")
	public void logExceptionFromService(Exception exception) throws Exception {
		log(exception);
	}

	// API logging
	@AfterThrowing(pointcut = "execution(* com.infy.verizon.api.*.*(..))", throwing = "exception")
	public void logBeforeFromAPI(Exception exception) throws Exception {
		log(exception);
	}

	@AfterThrowing(pointcut = "execution(* com.infy.verizon.api.*.*(..))", throwing = "exception")
	public void logAfterFromAPI(Exception exception) throws Exception {
		log(exception);
	}

	private void log(Exception exception) {

		if (exception.getMessage() != null
				&& (exception.getMessage().contains("Service") || exception.getMessage().contains("Validator"))) {
			logger.error(exception.getMessage());
		} else {
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

	// Admin register logging
	@Before("execution(* com.infy.verizon.api.AdminAPI.registerAdmin(..)) && args(admin)")
	public void logBeforeRegisterAdmin(JoinPoint joinPoint, Admin admin) {

		logger.info("ADMIN TRYING TO REGISTER. ADMIN LOGIN ID: ", admin.getLoginId());
	}

	@After("execution(* com.infy.verizon.api.AdminAPI.registerAdmin(..)) && args(admin)")
	public void logAfterRegisterAdmin(JoinPoint joinPoint, Admin admin) {
		logger.info("ADMIN REGISTRATION SUCCESSFUL. ADMIN LOGIN ID:", admin.getLoginId());
	}

	// Admin authenticate logging
	@Before("execution(* com.infy.verizon.api.AdminAPI.authenticateAdmin(..)) && args(admin)")
	public void logBeforeAuthenticateAdmin(JoinPoint joinPoint, Admin admin) {
		logger.info("ADMIN TRYING TO LOGIN. ADMIN LOGIN ID: ", admin.getLoginId());
	}

	@After("execution(* com.infy.verizon.api.AdminAPI.authenticateAdmin(..)) && args(admin)")
	public void logAfterAuthenticateAdmin(JoinPoint joinPoint, Admin admin) {
		logger.info("ADMIN LOGIN SUCCESSFUL. ADMIN LOGIN ID: ", admin.getLoginId());
	}

	// Traveler register logging
	@Before("execution(* com.infy.verizon.api.TravelerAPI.registerTraveler(..)) && args(traveler)")
	public void logBeforeRegisterTraveler(JoinPoint joinPoint, Traveler traveler) {
		logger.info("TRAVELER TRYING TO REGISTER. TRAVELER LOGIN ID: ", traveler.getLoginId());
	}

	@After("execution(* com.infy.verizon.api.TravelerAPI.registerTraveler(..)) && args(traveler)")
	public void logAfterRegisterTraveler(JoinPoint joinPoint, Traveler traveler) {
		logger.info("TRAVELER REGISTRATION SUCCESSFUL. TRAVELER LOGIN ID: ", traveler.getLoginId());
	}

	//Traveler authenticate logging
	@Before("execution(* com.infy.verizon.api.TravelerAPI.authenticateTraveler(..)) && args(traveler)")
	public void logBeforeAuthenticateTraveler(JoinPoint joinPoint, Traveler traveler) {
		logger.info("TRAVELER TRYING TO LOGIN. TRAVELER LOGIN ID: ", traveler.getLoginId());
	}

	@After("execution(* com.infy.verizon.api.TravelerAPI.authenticateTraveler(..)) && args(traveler)")
	public void logAfterAuthenticateTraveler(JoinPoint joinPoint, Traveler traveler) {
		logger.info("TRAVELER LOGIN SUCCESSFUL. TRAVELER LOGIN ID: ", traveler.getLoginId());
	}

}
