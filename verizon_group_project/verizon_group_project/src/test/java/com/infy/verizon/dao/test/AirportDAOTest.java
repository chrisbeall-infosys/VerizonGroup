package com.infy.verizon.dao.test;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	private Airport airport1;
	private Airport airport2;
	private int airportCount;
	
	@Before
	public void init(){
		airport1 = new Airport();
		airport1.setAirportId("TEST");
		
		airport2 = new Airport();
		airport2.setAirportId("T2");
		
		airportCount = airportDAO.getAirports().get().size();
	}
	@Test
	public void addAirportNotNull(){
		Assert.assertEquals(true, airportDAO.addAirport(airport1).isPresent());
		airportDAO.removeAirport(airport1.getAirportId());
	}
	@Test
	public void addAirportNull(){
		airport1 = null;
		Assert.assertEquals(Optional.empty(), airportDAO.addAirport(airport1));
	}
	@Test
	public void addAirportIdNull(){
		airport1.setAirportId(null);
		Assert.assertEquals(Optional.empty(), airportDAO.addAirport(airport1));
	}
	@Test
	public void removeAirportSuccess(){
		airportDAO.addAirport(airport1);
		Assert.assertEquals(airport1.getAirportId(), airportDAO.removeAirport(airport1.getAirportId()).get());
	}
	@Test
	public void removeAirportFail(){
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("AirportDAO.AIRPORT_ID_DOES_NOT_EXIST");
		
		airport1.setAirportId(null);
		airportDAO.removeAirport(airport1.getAirportId());
	}
	@Test
	public void getAirportPass1(){
		Assert.assertEquals(airportCount, airportDAO.getAirports().get().size());
	}
	@Test
	public void getAirportPass2(){
		airportDAO.addAirport(airport1);
		Assert.assertEquals(airportCount + 1, airportDAO.getAirports().get().size());
		//airportDAO.removeAirport(airport1.getAirportId());
	}
	@Test
	public void getAirportPass3(){
		airportDAO.addAirport(airport1);
		airportDAO.addAirport(airport2);
		Assert.assertEquals(airportCount + 2, airportDAO.getAirports().get().size());
		airportDAO.removeAirport(airport1.getAirportId());
		airportDAO.removeAirport(airport2.getAirportId());
	}
}
