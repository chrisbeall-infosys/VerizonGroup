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
	
	Airport airport;
	
	@Before
	public void init(){
		airport = new Airport();
		airport.setAirportId("TEST");
	}
	@Test
	public void addAirportNotNull(){
		Assert.assertNotNull(airportDAO.addAirport(airport));
	}
	@Test
	public void addAirportNull(){
		airport = null;
		Assert.assertNull(airportDAO.addAirport(airport));
	}
	@Test
	public void addAirportIdNull(){
		airport.setAirportId(null);
		Assert.assertNull(airportDAO.addAirport(airport));
	}
	
}
