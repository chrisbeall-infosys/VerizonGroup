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

import com.infy.verizon.dao.AirportDAO;
import com.infy.verizon.model.Airport;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class AirportDAOTest {
	
	@Autowired
	AirportDAO airportDAO;
	
	private Airport airport1;
	private Airport airport2;
	private int airportCount;
	
	@Before
	public void init(){
		airport1 = new Airport();
		airport1.setAirportId("TEST");
		
		airport2 = new Airport();
		airport2.setAirportId("T2");
		
		airportCount = airportDAO.getAirports().size();
	}
	@Test
	public void addAirportNotNull(){
		Assert.assertNotNull(airportDAO.addAirport(airport1));
	}
	@Test
	public void addAirportNull(){
		airport1 = null;
		Assert.assertNull(airportDAO.addAirport(airport1));
	}
	@Test
	public void addAirportIdNull(){
		airport1.setAirportId(null);
		Assert.assertNull(airportDAO.addAirport(airport1));
	}
	@Test
	public void removeAirportSuccess(){
		airportDAO.addAirport(airport1);
		Assert.assertNotNull(airportDAO.removeAirport(airport1.getAirportId()));
	}
	@Test
	public void removeAirportFail(){
		airport1.setAirportId(null);
		Assert.assertNull(airportDAO.removeAirport(airport1.getAirportId()));
	}
	@Test
	public void getAirportPass1(){
		Assert.assertEquals(airportCount, airportDAO.getAirports().size());
	}
	@Test
	public void getAirportPass2(){
		airportDAO.addAirport(airport1);
		Assert.assertEquals(airportCount + 1, airportDAO.getAirports().size());
		airportDAO.removeAirport(airport1.getAirportId());
	}
	@Test
	public void getAirportPass3(){
		airportDAO.addAirport(airport1);
		airportDAO.addAirport(airport2);
		Assert.assertEquals(airportCount + 2, airportDAO.getAirports().size());
		airportDAO.removeAirport(airport1.getAirportId());
		airportDAO.removeAirport(airport2.getAirportId());
	}
}
