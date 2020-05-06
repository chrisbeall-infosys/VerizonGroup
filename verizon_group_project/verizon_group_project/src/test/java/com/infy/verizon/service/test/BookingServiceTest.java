package com.infy.verizon.service.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;

import com.infy.verizon.dao.BookingDAO;
import com.infy.verizon.model.Airport;
import com.infy.verizon.model.Booking;
import com.infy.verizon.model.Flight;
import com.infy.verizon.model.Traveler;
import com.infy.verizon.service.BookingService;
import com.infy.verizon.service.BookingServiceImpl;
import java.time.LocalDate;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingServiceTest {
	
	@Mock
	private BookingDAO bookingDAO;
	
	
	@InjectMocks
	private BookingService bookingService = new BookingServiceImpl();
	
	@Rule
	public ExpectedException expectedException=ExpectedException.none();
	
	public Booking booking;
	
	@Before
	public void setupBooking(){
		this.booking = new Booking();
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
		
		this.booking.setFlight(flight);
		this.booking.setTraveler(traveler);
		this.booking.setBookingId(1);
		this.booking.setCost(2.0);
		this.booking.setNumberOfTravelers(1);
		this.booking.setDateOfTravel(LocalDate.now());
		
	}
	
	
	@Test 
	public void testAddNewBookingCorrectly() throws Exception{
		
		
		
		Mockito.when(this.bookingDAO.addNewBooking(this.booking)).thenReturn(1);
		Integer test = bookingDAO.addNewBooking(this.booking);
		
		Assert.assertNotNull(this.bookingService.addNewBooking(this.booking));
	}
	
	@Test 
	public void testAddNewBookingNullTraveler() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("BookingValidator.TRAVELER_IS_NULL");
		
		booking.setTraveler(null);
		bookingService.addNewBooking(booking);
	}
}
