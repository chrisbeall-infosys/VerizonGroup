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
	public void addFlightServiceTestSuccess() throws Exception {
		FlightEntity flightEntity = new FlightEntity();
		flightEntity.setFlightId(10);
		Mockito.when(flightDAO.addFlight(flight)).thenReturn(flightEntity);
		Integer flightId = flightService.addFlight(flight);
	}
	@Test
	public void addFlightServiceTestFail() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("FlightService.NULL_FIELD");
		
		FlightEntity flightEntity = new FlightEntity();
		flightEntity.setFlightId(10);
		Mockito.when(flightDAO.addFlight(flight)).thenReturn(null);
		Integer flightId = flightService.addFlight(flight);
	}
	
}
