package com.infy.verizon.service.test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;

import com.infy.verizon.dao.BookingDAO;
import com.infy.verizon.entity.BookingEntity;
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
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void testAddNewBookingCorrectly() throws Exception {
		Booking booking = new Booking();
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

		BookingEntity be = new BookingEntity();
		be.setBookingId(1);
		when(bookingDAO.addNewBooking(booking)).thenReturn(be);
		
		Integer value = bookingService.addNewBooking(booking);
		System.out.println(value);


	}

}
