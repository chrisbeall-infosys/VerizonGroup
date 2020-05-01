package com.infy.verizon.service.test;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.infy.verizon.dao.TravelerDAO;
import com.infy.verizon.model.Traveler;
import com.infy.verizon.service.TravelerService;
import com.infy.verizon.service.TravelerServiceImpl;
import com.infy.verizon.utility.HashingUtility;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TravelerServiceTest {

	@Mock
	private TravelerDAO travelerDAO;
	
	@InjectMocks
	private TravelerService travelerService=new TravelerServiceImpl();
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	
	@Test
	public void authenticateTravelerInValidDetails() throws Exception {
	
		String password = "Tom@123";
		Mockito.when(travelerDAO.getPasswordOfTraveler(Mockito.anyString())).thenReturn(null);
		expectedException.expect(Exception.class);
		expectedException.expectMessage("TravelerService.INVALID_CREDENTIALS");
		travelerService.authenticateTraveler("Toinfosys.com", password);
	}
	
	
	@Test
	public void authenticateTravelerInValidDetails1() throws Exception {
		
		String password = "Tom23";
		String hashPassword = HashingUtility.getHashValue(password)+" ";
		Mockito.when(travelerDAO.getPasswordOfTraveler(Mockito.anyString())).thenReturn(hashPassword);
		expectedException.expect(Exception.class);
		expectedException.expectMessage("TravelerService.INVALID_CREDENTIALS");
		travelerService.authenticateTraveler("Tom@infosys.com", password);
		
	}
	
	@Test
	public void authenticateTravelerInValidDetails2() throws Exception {
		

		String password = "Tom23";
		Mockito.when(travelerDAO.getPasswordOfTraveler(Mockito.anyString())).thenReturn(null);
		expectedException.expect(Exception.class);
		expectedException.expectMessage("TravelerService.INVALID_CREDENTIALS");
		travelerService.authenticateTraveler("Tom@infosys.com", password);
		
	}
	

	
	@Test
	public void testRegisterNewTraveler() throws Exception{
		Traveler traveler=new Traveler();
		traveler.setName("Fahad Rahman");
		traveler.setEmail("Fahad@infosys.com");
		traveler.setPassword("Fahad@123");
		traveler.setLoginId("Fahad1345");
		Mockito.when(travelerDAO.checkAvailabilityOfLoginId(traveler.getLoginId())).thenReturn(true);
		Mockito.when(travelerDAO.registerNewTraveler(traveler)).thenReturn("Fahad1345");
		Assert.assertNotNull(travelerService.registerNewTraveler(traveler));
	}
	
	
	@Test
	public void registerNewCustomerExistingLoginId() throws Exception {
		
		expectedException.expect(Exception.class);
		expectedException.expectMessage("TravelerService.LOGIN_ID_ALREADY_IN_USE");
		
		Traveler traveler=new Traveler();
		traveler.setEmail("Fahad@infosys.com");
		traveler.setName("Fahad Rahman");
		traveler.setPassword("Fahad@123");
		traveler.setLoginId("Fahad12");
		Assert.assertNull(travelerService.registerNewTraveler(traveler));
	}
	
	@Test
	public void testRegisterNewCustomerInValidEmail() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("TravelerValidator.INVALID_EMAIL_FORMAT");
		Traveler traveler=new Traveler();
		traveler.setName("Fahad Rahman");
		traveler.setEmail("Fa@had@infosys.com");
		traveler.setPassword("Fahad@123");
		Assert.assertNotNull(travelerService.registerNewTraveler(traveler));
	}
	@Test
	public void testRegisterNewTravelerInValidName() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("TravelerValidator.INVALID_NAME");
		Traveler traveler=new Traveler();
		traveler.setName("12FahadRahman");
		traveler.setEmail("Fahad@infosys.com");
		traveler.setPassword("Fahad@123");
		Assert.assertNotNull(travelerService.registerNewTraveler(traveler));
	}
	@Test
	public void testRegisterNewCustomerInValidPassword() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("TravelerValidator.INVALID_PASSWORD");
		Traveler traveler=new Traveler();
		traveler.setName("Fahad Rahman");
		traveler.setEmail("Fahad@infosys.com");
		traveler.setPassword("a123");
		Assert.assertNotNull(travelerService.registerNewTraveler(traveler));
	}
	
	
}

	
