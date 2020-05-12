package com.infy.verizon.validator.test;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.infy.verizon.model.Airport;
import com.infy.verizon.model.Booking;
import com.infy.verizon.model.Flight;
import com.infy.verizon.model.Traveler;
import com.infy.verizon.validator.BookingValidator;

public class BookingValidatorTest {
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	public Booking booking;
	@Before 
	public void init(){
		booking = new Booking();
		Traveler traveler = new Traveler();
		traveler.setLoginId("test");
		traveler.setEmail("test@test.com");
		traveler.setName("Test Testman");
		traveler.setPassword("TestPass@1");
		
		Flight flight = new Flight();
		flight.setFare(1.0);
		flight.setFlightId(1);
		Airport airportTo = new Airport();
		airportTo.setAirportId("TST");
		Airport airportFrom = new Airport();
		airportFrom.setAirportId("TFT");
		flight.setFromAirport(airportFrom);
		flight.setToAirport(airportTo);
		flight.setTaxes(1.0);
		
		booking.setFlight(flight);
		booking.setTraveler(traveler);
		booking.setBookingId(1);
		booking.setCost(2.0);
		booking.setNumberOfTravelers(1);
		booking.setDateOfTravel(LocalDate.now());
		booking.setBookingId(1);
	}
	
	@After
	public void remove(){
		booking = null;
	}
	
	@Test 
	public void testValidateBooking() throws Exception{
		BookingValidator.validateBooking(booking);
	}
	
//	@Test 
//	public void testTravelerIsNull(){
//		expectedException.expect(Exception.class);
//		expectedException.expectMessage("BookingValidator.TRAVELER_IS_NULL");
//		booking.setTraveler(null);
//		BookingValidator.checkIfTravelerIsNull(booking);
//	}
//	
//	@Test 
//	public void testFlightIsNull(){
//		expectedException.expect(Exception.class);
//		expectedException.expectMessage("BookingValidator.FLIGHT_IS_NULL");
//		booking.setFlight(null);
//		BookingValidator.checkIfFlightIsNull(booking);
//	}
//	
//	@Test
//	public void testDateIsNull(){
//		expectedException.expect(Exception.class);
//		expectedException.expectMessage("BookingValidator.DATE_IS_NULL");
//		booking.setDateOfTravel(null);
//		BookingValidator.checkIfDateOfTravelIsNull(booking);
//	
//	}
//	
//	@Test
//	public void testNumberOfTravelersIsNull(){
//		expectedException.expect(Exception.class);
//		expectedException.expectMessage("BookingValidator.NUMBER_OF_TRAVELERS_IS_NULL");
//		booking.setNumberOfTravelers(null);
//		BookingValidator.checkIfNumberOfTravelersIsNull(booking);
//	}
	
}
