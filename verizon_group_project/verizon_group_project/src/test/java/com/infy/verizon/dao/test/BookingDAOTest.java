package com.infy.verizon.dao.test;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.infy.verizon.dao.BookingDAO;
import com.infy.verizon.model.Booking;
import com.infy.verizon.model.Flight;
import com.infy.verizon.model.Traveler;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class BookingDAOTest {

	@Autowired
	BookingDAO bookingDAO;
	
	private Booking booking;
	
	@Before
	public void init(){
		booking = new Booking();
		Traveler traveler = new Traveler();
		traveler.setLoginId("testtest");

		Flight flight = new Flight();
		
		flight.setFlightId(1);
		
		

		booking.setFlight(flight);
		booking.setTraveler(traveler);
		booking.setCost(2.0);
		booking.setNumberOfTravelers(1);
		booking.setDateOfTravel(LocalDate.now());
	}
	
	@Test
	public void addNewBooking(){
		Assert.assertNotNull(bookingDAO.addNewBooking(booking));
	}
	
	@Test
	public void addNewBookingTravelerNull(){
		booking.setTraveler(null);
		Assert.assertNull(bookingDAO.addNewBooking(booking));
	}
	@Test 
	public void addNewBookingFlightNull(){
		booking.setFlight(null);
		Assert.assertNull(bookingDAO.addNewBooking(booking));
	}
	
	@Test
	public void addNewBookingCostNull(){
		booking.setCost(null);
		Assert.assertNull(bookingDAO.addNewBooking(booking));
	}
	
	@Test
	public void addNewBookingNumberOfTravelersNull(){
		booking.setNumberOfTravelers(null);
		Assert.assertNull(bookingDAO.addNewBooking(booking));
	}
	
	@Test
	public void addNewBookingDateNull(){
		booking.setDateOfTravel(null);
		Assert.assertNull(bookingDAO.addNewBooking(booking));
	}

}
