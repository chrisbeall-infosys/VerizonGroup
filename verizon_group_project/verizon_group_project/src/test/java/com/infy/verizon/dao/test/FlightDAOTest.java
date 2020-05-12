package com.infy.verizon.dao.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.infy.verizon.dao.FlightDAO;
import com.infy.verizon.model.Airport;
import com.infy.verizon.model.Flight;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class FlightDAOTest {
	
	@Autowired
	FlightDAO flightDAO;
	
	private Flight flight;
	
	@Before
	public void init(){
		
		flight = new Flight();
		flight.setFlightId(10);
		flight.setFare(5.0);
		flight.setTaxes(1.0);
		
		Airport fromAirport = new Airport();
		fromAirport.setAirportId("FROM");
		flight.setFromAirport(fromAirport);
		
		Airport toAirport = new Airport();
		toAirport.setAirportId("TO");
		flight.setToAirport(toAirport);
		
	}
	
	@Test
	public void addFlightNotNull(){
		Assert.assertNotNull(flightDAO.addFlight(flight));
	}
	@Test
	public void addFlightNull(){
		flight = null;
		Assert.assertNull(flightDAO.addFlight(flight));
	}
	@Test
	public void addFlightIdNull(){
		flight.setFlightId(null);
		Assert.assertNull(flightDAO.addFlight(flight));
	}
	@Test
	public void addFlightFareNull(){
		flight.setFare(null);
		Assert.assertNull(flightDAO.addFlight(flight));
	}
	@Test
	public void addFlightTaxesNull(){
		flight.setTaxes(null);
		Assert.assertNull(flightDAO.addFlight(flight));
	}
	@Test
	public void addFlightFromAirportNull(){
		flight.setFromAirport(null);
		Assert.assertNull(flightDAO.addFlight(flight));
	}
	@Test
	public void addFlightToAirportNull(){
		flight.setToAirport(null);
		Assert.assertNull(flightDAO.addFlight(flight));
	}
//	@Test
//	public void removeFlightPass(){
//		
//	}
	
	
}
