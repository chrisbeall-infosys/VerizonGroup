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

import com.infy.verizon.dao.AirportDAO;
import com.infy.verizon.entity.AirportEntity;
import com.infy.verizon.entity.FlightEntity;
import com.infy.verizon.model.Airport;
import com.infy.verizon.service.AirportService;
import com.infy.verizon.service.AirportServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AirportServiceTest {
	
	@Mock
	private AirportDAO airportDAO;
	
	@InjectMocks
	private AirportService airportService = new AirportServiceImpl();
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	Airport airport;
	
	@Before
	public void init(){
		airport = new Airport();
		airport.setAirportId("TEST");
	}
	@Test
	public void addAirportServiceTestSuccess() throws Exception {
		AirportEntity airportEntity = new AirportEntity();
		airportEntity.setAirportId("TEST");
		Mockito.when(airportDAO.addAirport(airport)).thenReturn(airportEntity);
		String flightId = airportService.addAirport(airport);
	}
	@Test
	public void addAirportServiceTestFail() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AirportService.NULL_FIELD");
		
		AirportEntity airportEntity = new AirportEntity();
		airportEntity.setAirportId("TEST");
		Mockito.when(airportDAO.addAirport(airport)).thenReturn(null);
		String flightId = airportService.addAirport(airport);
	}
	
}
