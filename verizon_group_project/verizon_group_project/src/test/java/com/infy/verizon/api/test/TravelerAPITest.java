package com.infy.verizon.api.test;

import java.util.Optional;

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

import com.infy.verizon.api.TravelerAPI;

import com.infy.verizon.exception.TravelerAPIException;

import com.infy.verizon.model.Traveler;

import com.infy.verizon.service.TravelerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TravelerAPITest {
	@Rule 
	public ExpectedException ee = ExpectedException.none();
	
	@Mock
	private TravelerService travelerService;
	
	@Mock
	private Environment environment;
	
	@InjectMocks
	private TravelerAPI travelerAPI = new TravelerAPI();
	
	private Traveler traveler = new Traveler();
	
	@Before
	public void setup() {
		
		traveler.setEmail("thu123@info.com");
		traveler.setLoginId("thu123");
		traveler.setName("thu");
		traveler.setPassword("Abc123#");
	}
	
	@Test
	public void testRegisterTravelerValid() throws Exception {
		
		Optional<Traveler> travelerOp = Optional.of(traveler);
		
		Mockito.when(travelerService.registerNewTraveler(Mockito.any())).thenReturn(travelerOp);
		Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("success");
		
		ResponseEntity<String> response = travelerAPI.registerTraveler(traveler);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void testRegisterTravelerInValid() throws Exception {
		traveler.setLoginId("thu123");
		ee.expect(TravelerAPIException.class);
		ee.expectMessage("TravelerService.LOGIN_ID_ALREADY_IN_USE");
		
		travelerAPI.registerTraveler(traveler);
	
	}
	
	@Test
	public void testAuthenticateTravelerValid() throws Exception {
		
		Optional<Traveler> travelerOp = Optional.of(traveler);
		System.out.println("AdminOp is null? " + travelerOp.isPresent());
		Mockito.when(travelerService.authenticateTraveler(traveler.getLoginId(), traveler.getPassword())).thenReturn(travelerOp);
		Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("success");
		
		ResponseEntity<Traveler> response = travelerAPI.authenticateTraveler(traveler);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	
	@Test
	public void testAuthenticateTravelerInValid() throws Exception {
		traveler.setLoginId("thu124");
		ee.expect(TravelerAPIException.class);
		ee.expectMessage("TravelerService.INVALID_CREDENTIALS");
		
		travelerAPI.authenticateTraveler(traveler);
	
	}
	
	
}
