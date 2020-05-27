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
	
	private Airport airport;
	
	@Before
	public void init(){
		airport = new Airport();
		airport.setAirportId("TEST");
	}
	@Test
	public void addAirportServiceSuccess() throws Exception {
		List<Airport> airportList = new ArrayList<Airport>();
		Optional<List<Airport>> optionalAirportList = Optional.ofNullable(airportList);
		Mockito.when(airportDAO.getAirports()).thenReturn(optionalAirportList);
		
		AirportEntity airportEntity = new AirportEntity();
		airportEntity.setAirportId("TEST");
		Optional<AirportEntity> optionalAirportEntity = Optional.ofNullable(airportEntity);
		
		Mockito.when(airportDAO.addAirport(airport)).thenReturn(optionalAirportEntity);
		Optional<String> flightId = airportService.addAirport(airport);
	}
	@Test
	public void addAirportServiceDuplicate() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AirprotService.AIRPORT_ID_ALREADY_EXISTS");
		
		List<Airport> airportList = new ArrayList<Airport>();
		airportList.add(airport);
		Optional<List<Airport>> optionalAirportList = Optional.ofNullable(airportList);
		Mockito.when(airportDAO.getAirports()).thenReturn(optionalAirportList);
		
		AirportEntity airportEntity = new AirportEntity();
		airportEntity.setAirportId("TEST");
		Optional<AirportEntity> optionalAirportEntity = Optional.ofNullable(airportEntity);
		
		Mockito.when(airportDAO.addAirport(airport)).thenReturn(optionalAirportEntity);
		Optional<String> flightId = airportService.addAirport(airport);
	}
	@Test
	public void addAirportServiceNull() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AirportService.NULL_FIELD");
		
		List<Airport> airportList = new ArrayList<Airport>();
		Optional<List<Airport>> optionalAirportList = Optional.ofNullable(airportList);
		Mockito.when(airportDAO.getAirports()).thenReturn(optionalAirportList);
		
		AirportEntity airportEntity = new AirportEntity();
		airportEntity.setAirportId(null);
		Optional<AirportEntity> optionalAirportEntity = Optional.ofNullable(airportEntity);
		
		Mockito.when(airportDAO.addAirport(airport)).thenReturn(Optional.empty());
		Optional<String> flightId = airportService.addAirport(airport);
	}
	@Test
	public void removeAirportSuccess() throws Exception {
		List<Airport> airportList = new ArrayList<Airport>();
		airportList.add(airport);
		Optional<List<Airport>> optionalAirportList = Optional.ofNullable(airportList);
		Mockito.when(airportDAO.getAirports()).thenReturn(optionalAirportList);
		
		AirportEntity airportEntity = new AirportEntity();
		airportEntity.setAirportId("TEST");
		Optional<String> optionalAirportId = Optional.ofNullable(airportEntity.getAirportId());
		
		Mockito.when(airportDAO.removeAirport(airport.getAirportId())).thenReturn(optionalAirportId);
		Optional<String> airportId = airportService.removeAirport(airport.getAirportId());
	}
	@Test
	public void removeAirportFail() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AirportService.AIRPORT_ID_DOES_NOT_EXIST");
		
		List<Airport> airportList = new ArrayList<Airport>();
		Optional<List<Airport>> optionalAirportList = Optional.ofNullable(airportList);
		Mockito.when(airportDAO.getAirports()).thenReturn(optionalAirportList);
		
		AirportEntity airportEntity = new AirportEntity();
		airportEntity.setAirportId("TEST");
		Optional<String> optionalAirportId = Optional.ofNullable(airportEntity.getAirportId());
		
		Mockito.when(airportDAO.removeAirport(airport.getAirportId())).thenReturn(optionalAirportId);
		Optional<String> airportId = airportService.removeAirport(airport.getAirportId());
	}
	@Test
	public void getAirportSuccess() throws Exception {
		List<Airport> airportListDAO = new ArrayList<Airport>();
		airportListDAO.add(airport);
		Optional<List<Airport>> optionalAirportListDAO = Optional.ofNullable(airportListDAO);
		
		Mockito.when(airportDAO.getAirports()).thenReturn(optionalAirportListDAO);
		Optional<List<Airport>> airportListService = airportService.getAirports();
	}
	@Test
	public void getAirportEmpty() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AirportService.NO_AIRPORTS_IN_TABLE");
		
		List<Airport> airportListDAO = new ArrayList<Airport>();
		Optional<List<Airport>> optionalAirportListDAO = Optional.ofNullable(airportListDAO);
		
		Mockito.when(airportDAO.getAirports()).thenReturn(optionalAirportListDAO);
		Optional<List<Airport>> airportListService = airportService.getAirports();
	}
	@Test
	public void getAirportNull() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AirportService.NO_AIRPORTS_IN_TABLE");
		
		Mockito.when(airportDAO.getAirports()).thenReturn(Optional.empty());
		Optional<List<Airport>> airportListService = airportService.getAirports();
	}
}
