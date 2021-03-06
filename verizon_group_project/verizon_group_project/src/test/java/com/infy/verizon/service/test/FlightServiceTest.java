package com.infy.verizon.service.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.infy.verizon.dao.FlightDAO;
import com.infy.verizon.entity.FlightEntity;
import com.infy.verizon.model.Airport;
import com.infy.verizon.model.Flight;
import com.infy.verizon.service.FlightService;
import com.infy.verizon.service.FlightServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightServiceTest {
	
	@Mock
	private FlightDAO flightDAO;
	
	@InjectMocks
	private FlightService flightService = new FlightServiceImpl();
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	private Flight flight;
	
	@Before
	public void init(){
		
		flight = new Flight();
		flight.setFlightId(10);
		flight.setFare(50.0);
		flight.setTaxes(10.0);
		
		Airport fromAirport = new Airport();
		fromAirport.setAirportId("FROM");
		flight.setFromAirport(fromAirport);
		
		Airport toAirport = new Airport();
		toAirport.setAirportId("TO");
		flight.setToAirport(toAirport);
	}
	
	@Test
	public void addFlightServiceSuccess() throws Exception {
		List<Flight> flightListDAO = new ArrayList<Flight>();
		Optional<List<Flight>> optionalFlightListDAO = Optional.ofNullable(flightListDAO);
		Mockito.when(flightDAO.getFlights()).thenReturn(optionalFlightListDAO);
		
		FlightEntity flightEntity = new FlightEntity();
		flightEntity.setFlightId(10);
		
		Optional<FlightEntity> flightEntityOptional = Optional.of(flightEntity);
		
		Mockito.when(flightDAO.addFlight(flight)).thenReturn(flightEntityOptional);
		Optional<Integer> flightId = flightService.addFlight(flight);
	}
	// FlightService.FLIGHT_ID_ALREADY_EXISTS test
	@Test
	public void addFlightServiceDuplicate() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("FlightService.FLIGHT_ID_ALREADY_EXISTS");
		
		List<Flight> flightListDAO = new ArrayList<Flight>();
		flightListDAO.add(flight);
		Optional<List<Flight>> optionalFlightListDAO = Optional.ofNullable(flightListDAO);
		Mockito.when(flightDAO.getFlights()).thenReturn(optionalFlightListDAO);
		
		FlightEntity flightEntity = new FlightEntity();
		flightEntity.setFlightId(10);
		
		Optional<FlightEntity> flightEntityOptional = Optional.of(flightEntity);
		
		Mockito.when(flightDAO.addFlight(flight)).thenReturn(flightEntityOptional);
		Optional<Integer> flightId = flightService.addFlight(flight);
	}
	@Test
	public void addFlightServiceNull() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("FlightService.NULL_FIELD");
		
		List<Flight> flightListDAO = new ArrayList<Flight>();
		Optional<List<Flight>> optionalFlightListDAO = Optional.ofNullable(flightListDAO);
		Mockito.when(flightDAO.getFlights()).thenReturn(optionalFlightListDAO);
		
		FlightEntity flightEntity = new FlightEntity();
		flightEntity.setFlightId(null);
		
		Mockito.when(flightDAO.addFlight(flight)).thenReturn(Optional.empty());
		Optional<Integer> flightId = flightService.addFlight(flight);
	}
	@Test
	public void removeFlightSuccess() throws Exception {
		
		List<Flight> flightListDAO = new ArrayList<Flight>();
		flightListDAO.add(flight);
		Optional<List<Flight>> optionalFlightListDAO = Optional.ofNullable(flightListDAO);
		Mockito.when(flightDAO.getFlights()).thenReturn(optionalFlightListDAO);
		
		FlightEntity flightEntity = new FlightEntity();
		flightEntity.setFlightId(10);
		Optional<Integer> optionalFlightId = Optional.ofNullable(flightEntity.getFlightId());
		
		Mockito.when(flightDAO.removeFlight(flight.getFlightId())).thenReturn(optionalFlightId);
		Optional<Integer> flightId = flightService.removeFlight(flight.getFlightId());
	}
	@Test
	public void removeFlightFail() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("FlightService.FLIGHT_ID_DOES_NOT_EXIST");
		
		List<Flight> flightListDAO = new ArrayList<Flight>();	// List is empty
		Optional<List<Flight>> optionalFlightListDAO = Optional.ofNullable(flightListDAO);
		Mockito.when(flightDAO.getFlights()).thenReturn(optionalFlightListDAO);
		
		FlightEntity flightEntity = new FlightEntity();
		flightEntity.setFlightId(10);
		
		Mockito.when(flightDAO.removeFlight(flight.getFlightId())).thenReturn(null);		// ??????
		Optional<Integer> flightId = flightService.removeFlight(flight.getFlightId());
	}
	@Test
	public void getFlightsSuccess() throws Exception {
		List<Flight> flightListDAO = new ArrayList<Flight>();
		flightListDAO.add(flight);
		Optional<List<Flight>> optionalFlightListDAO = Optional.ofNullable(flightListDAO);
		Mockito.when(flightDAO.getFlights()).thenReturn(optionalFlightListDAO);
		Optional<List<Flight>> flightListService = flightService.getFlights();
	}
	@Test
	public void getFlightsEmpty() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("FlightService.NO_FLIGHTS_IN_TABLE");
		
		List<Flight> flightListDAO = new ArrayList<Flight>();
		Optional<List<Flight>> optionalFlightListDAO = Optional.ofNullable(flightListDAO);
		
		Mockito.when(flightDAO.getFlights()).thenReturn(optionalFlightListDAO);
		Optional<List<Flight>> flightListService = flightService.getFlights();
	}
	@Test
	public void getFlightsNull() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("FlightService.NO_FLIGHTS_IN_TABLE");
		
		Mockito.when(flightDAO.getFlights()).thenReturn(Optional.empty());
		Optional<List<Flight>> flightListService = flightService.getFlights();
	}
	
}
