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

import com.infy.verizon.api.AirportAPI;
import com.infy.verizon.model.Airport;
import com.infy.verizon.service.AirportService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AirportAPITest {
	
	@Mock
	private AirportService airportService;
	
	@Mock
	private Environment environment;
	
	@InjectMocks
	private AirportAPI airportAPI = new AirportAPI();
	
	@Rule 
	public ExpectedException ee = ExpectedException.none();
	
	private Airport airport;
	
	@Before
	public void init(){
		airport = new Airport();
		airport.setAirportId("TEST");
	}
	
	@Test
	public void addAirportAPITest() throws Exception {
		String airportId = "TEST";
		Mockito.when(airportService.addAirport(airport)).thenReturn(airportId);
		Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("success");
		
		ResponseEntity<String> response = airportAPI.addAirport(airport);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	@Test
	public void removeAirportAPITest() throws Exception {
		Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("success");
		
		ResponseEntity<String> response = airportAPI.removeAirport(airport.getAirportId());
		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	@Test
	public void getAirportsAPITest() throws Exception {
		Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("success");
		
		ResponseEntity<List<Airport>> response = airportAPI.getAirports();
		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
}
