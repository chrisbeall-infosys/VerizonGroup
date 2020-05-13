package com.infy.verizon.dao.test;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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
	
	@Mock
	EntityManager entityManager;
	
	private Flight flight1;
	private Flight flight2;
	private int flightCount;
	
	@Before
	public void init(){
		
		flight1 = new Flight();
		flight1.setFlightId(100);
		flight1.setFare(5.0);
		flight1.setTaxes(1.0);
		
		Airport fromAirport1 = new Airport();
		fromAirport1.setAirportId("FR_1");
		flight1.setFromAirport(fromAirport1);
		
		Airport toAirport1 = new Airport();
		toAirport1.setAirportId("TO_1");
		flight1.setToAirport(toAirport1);
		
		flight2 = new Flight();
		flight2.setFlightId(101);
		flight2.setFare(6.0);
		flight2.setTaxes(2.0);
		
		Airport fromAirport2 = new Airport();
		fromAirport2.setAirportId("FR_2");
		flight2.setFromAirport(fromAirport2);
		
		Airport toAirport2 = new Airport();
		toAirport2.setAirportId("TO_2");
		flight2.setToAirport(toAirport2);
		
		flightCount = flightDAO.getFlights().size();
	}
	
	@Test
	public void addFlightNotNull(){
		Assert.assertNotNull(flightDAO.addFlight(flight1));
		// flight will successfully get added so needs to be removed for other tests.
		flightDAO.removeFlight(flight1.getFlightId());
	}
	@Test
	public void addFlightNull(){
		flight1 = null;
		Assert.assertNull(flightDAO.addFlight(flight1));
	}
	@Test
	public void addFlightIdNull(){
		flight1.setFlightId(null);
		Assert.assertNull(flightDAO.addFlight(flight1));
	}
	@Test
	public void addFlightFareNull(){
		flight1.setFare(null);
		Assert.assertNull(flightDAO.addFlight(flight1));
	}
	@Test
	public void addFlightTaxesNull(){
		flight1.setTaxes(null);
		Assert.assertNull(flightDAO.addFlight(flight1));
	}
	@Test
	public void addFlightFromAirportNull(){
		flight1.setFromAirport(null);
		Assert.assertNull(flightDAO.addFlight(flight1));
	}
	@Test
	public void addFlightToAirportNull(){
		flight1.setToAirport(null);
		Assert.assertNull(flightDAO.addFlight(flight1));
	}
	@Test
	public void removeFlightPass(){
		flightDAO.addFlight(flight1);
		//Assert.assertNull(flightDAO.removeFlight(flight.getFlightId()));
		Assert.assertNotNull(flightDAO.removeFlight(flight1.getFlightId()));
	}
	@Test
	public void removeFlightFail(){
		flight1.setFlightId(null);
		//flightDAO.addFlight(flight1);
		//Assert.assertNotNull(flightDAO.removeFlight(flight.getFlightId()));
		Assert.assertNull(flightDAO.removeFlight(flight1.getFlightId()));
	}
	@Test
	public void getFlightsPass1(){
		Assert.assertEquals(flightCount, flightDAO.getFlights().size());
	}
	@Test
	public void getFlightsPass2(){
		flightDAO.addFlight(flight1);
		Assert.assertEquals(flightCount + 1, flightDAO.getFlights().size());
		flightDAO.removeFlight(flight1.getFlightId());
	}
	@Test
	public void getFlightPass3(){
		flightDAO.addFlight(flight1);
		flightDAO.addFlight(flight2);
		Assert.assertEquals(flightCount + 2, flightDAO.getFlights().size());
		flightDAO.removeFlight(flight1.getFlightId());
		flightDAO.removeFlight(flight2.getFlightId());
	}
//	@Test
//	public void getFlightFail(){
//		
//	}
	
}
