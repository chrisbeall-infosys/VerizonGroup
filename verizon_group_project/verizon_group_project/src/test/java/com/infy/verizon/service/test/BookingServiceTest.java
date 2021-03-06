package com.infy.verizon.service.test;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.infy.verizon.dao.BookingDAO;
import com.infy.verizon.entity.BookingEntity;
import com.infy.verizon.model.Airport;
import com.infy.verizon.model.Booking;
import com.infy.verizon.model.Flight;
import com.infy.verizon.model.Traveler;
import com.infy.verizon.service.BookingService;
import com.infy.verizon.service.BookingServiceImpl;
import java.time.LocalDate;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingServiceTest {

	@Mock
	private BookingDAO bookingDAO;

	@InjectMocks
	private BookingService bookingService = new BookingServiceImpl();

	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	private Booking booking;
	
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
	@Test
	public void testAddNewBookingCorrectly() throws Exception {

		BookingEntity be = new BookingEntity();
		Optional<BookingEntity> optBookingEntity = Optional.of(be);
		be.setBookingId(1);
		Mockito.when(bookingDAO.addNewBooking(booking)).thenReturn(optBookingEntity);
		bookingDAO.addNewBooking(booking);
		

	}
	
	@Test
	public void testAddNewBookingBad() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("BookingService.NULL_FIELD");
		BookingEntity be = new BookingEntity();
		be.setBookingId(1);
		Mockito.when(bookingDAO.addNewBooking(booking)).thenReturn(Optional.empty());
	
		bookingService.addNewBooking(booking);
		
	}

}
