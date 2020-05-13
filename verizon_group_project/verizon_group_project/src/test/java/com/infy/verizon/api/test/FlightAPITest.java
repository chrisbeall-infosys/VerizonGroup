package com.infy.verizon.api.test;

import java.util.List;

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

import com.infy.verizon.api.FlightAPI;
import com.infy.verizon.model.Airport;
import com.infy.verizon.model.Flight;
import com.infy.verizon.service.FlightService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightAPITest {
	
	@Mock
	private FlightService flightService;
	
	@Mock
	private Environment environment;
	
	@InjectMocks
	private FlightAPI flightAPI = new FlightAPI();
	
	@Rule 
	public ExpectedException ee = ExpectedException.none();
	
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
	public void addFlightAPITest() throws Exception {
		Integer flightId = 10;
		Mockito.when(flightService.addFlight(flight)).thenReturn(flightId);
		Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("success");
		
		ResponseEntity<String> response = flightAPI.addFlight(flight);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	@Test
	public void removeFlightAPITest() throws Exception {
		Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("success");
		
		ResponseEntity<String> response = flightAPI.removeFlight(Integer.toString(flight.getFlightId()));
		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	@Test
	public void getFlightsAPITest() throws Exception {
		Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("success");
		
		ResponseEntity<List<Flight>> response = flightAPI.getFlights();
		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
}
