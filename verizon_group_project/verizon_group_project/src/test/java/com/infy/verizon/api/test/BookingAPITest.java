package com.infy.verizon.api.test;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import com.infy.verizon.api.BookingAPI;
import com.infy.verizon.entity.BookingEntity;
import com.infy.verizon.exception.BookingAPIException;
import com.infy.verizon.model.Airport;
import com.infy.verizon.model.Booking;
import com.infy.verizon.model.Flight;
import com.infy.verizon.model.Traveler;
import com.infy.verizon.service.BookingService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingAPITest {
	
	@Mock
	private BookingService bookingService;
	
	@Mock
	private Environment environment;
	@InjectMocks
	private BookingAPI bookingAPI = new BookingAPI();
	
	@Rule 
	public ExpectedException ee = ExpectedException.none();
	
	private Booking booking;
	
	@Before
	public void initialize(){
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
		
	}
	
	@Test
	public void testBookingAPIAddNewBooking() throws Exception{
		BookingEntity be = new BookingEntity();
		be.setBookingId(1);
		Optional<BookingEntity> value = Optional.of(be);
		Mockito.when(bookingService.addNewBooking(Mockito.any())).thenReturn(value);
		Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("success");
		
		ResponseEntity<String> response = bookingAPI.addNewBooking(booking);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void testBookingAPIthrowsValidatorException() throws Exception{
		ee.expect(BookingAPIException.class);
		Mockito.when(bookingService.addNewBooking(Mockito.any())).thenThrow(new BookingAPIException("test exception"));
		ResponseEntity<String> response = bookingAPI.addNewBooking(booking);
	}
}
