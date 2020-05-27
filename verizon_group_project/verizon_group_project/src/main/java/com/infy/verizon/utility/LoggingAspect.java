package com.infy.verizon.utility;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


import com.infy.verizon.model.Airport;
import com.infy.verizon.model.Admin;
import com.infy.verizon.model.Traveler;

import com.infy.verizon.model.Booking;
import com.infy.verizon.model.Flight;


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
	
	// Flight Logs:
	@Before("execution(* com.infy.verizon.api.FlightAPI.addFlight(..)) && args(flight)")
	public void logBeforeAddFlight(JoinPoint jointPoint, Flight flight){
		Logger logger = LogManager.getLogger(this.getClass());
		logger.info("Adding new Flight with ID: {}", flight.getFlightId());
	}
	@After("execution(* com.infy.verizon.api.FlightAPI.addFlight(..)) && args(flight)")
	public void logAfterAddFlight(JoinPoint jointPoint, Flight flight){
		Logger logger = LogManager.getLogger(this.getClass());
		logger.info("Successfully added new Flight with ID: {}", flight.getFlightId());
	}
	
	@Before("execution(* com.infy.verizon.api.FlightAPI.removeFlight(..)) && args(flightId)")
	public void logBeforeRemoveFlight(JoinPoint jointPoint, String flightId){
		Logger logger = LogManager.getLogger(this.getClass());
		logger.info("Removing Flight with ID: {}", flightId);
	}
	@After("execution(* com.infy.verizon.api.FlightAPI.removeFlight(..)) && args(flightId)")
	public void logAfterRemoveFlight(JoinPoint jointPoint, String flightId){
		Logger logger = LogManager.getLogger(this.getClass());
		logger.info("Successfully removed Flight with ID: {}", flightId);
	}
	
	@Before("execution(* com.infy.verizon.api.FlightAPI.getFlights())")
	public void logBeforeGetFlights(JoinPoint jointPoint){
		Logger logger = LogManager.getLogger(this.getClass());
		logger.info("Retrieving Flight list from database");
	}
	@After("execution(* com.infy.verizon.api.FlightAPI.getFlights())")
	public void logAfterGetFlights(JoinPoint jointPoint){
		Logger logger = LogManager.getLogger(this.getClass());
		logger.info("Flight list retrived");
	}
	
	// Airport Logs:
	@Before("execution(* com.infy.verizon.api.AirportAPI.addAirport(..)) && args(airport)")
	public void logBeforeAddAirport(JoinPoint jointPoint, Airport airport){
		Logger logger = LogManager.getLogger(this.getClass());
		logger.info("Adding new Airport with ID: {}", airport.getAirportId());
	}
	@After("execution(* com.infy.verizon.api.AirportAPI.addAirport(..)) && args(airport)")
	public void logAfterAddFlight(JoinPoint jointPoint, Airport airport){
		Logger logger = LogManager.getLogger(this.getClass());
		logger.info("Successfully added new Airport with ID: {}", airport.getAirportId());
	}
	
	@Before("execution(* com.infy.verizon.api.AirportAPI.removeAirport(..)) && args(airportId)")
	public void logBeforeRemoveAirport(JoinPoint jointPoint, String airportId){
		Logger logger = LogManager.getLogger(this.getClass());
		logger.info("Removing Airport with ID: {}", airportId);
	}
	@After("execution(* com.infy.verizon.api.AirportAPI.removeAirport(..)) && args(airportId)")
	public void logAfterRemoveAirport(JoinPoint jointPoint, String airportId){
		Logger logger = LogManager.getLogger(this.getClass());
		logger.info("Successfully removed Airport with ID: {}", airportId);
	}
	
	@Before("execution(* com.infy.verizon.api.AirportAPI.getAirports())")
	public void logBeforeGetAirports(JoinPoint jointPoint){
		Logger logger = LogManager.getLogger(this.getClass());
		logger.info("Retrieving Airport list from database");
	}
	@After("execution(* com.infy.verizon.api.AirportAPI.getAirports())")
	public void logAfterGetAirports(JoinPoint jointPoint){
		Logger logger = LogManager.getLogger(this.getClass());
		logger.info("Airport list retrived");
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
