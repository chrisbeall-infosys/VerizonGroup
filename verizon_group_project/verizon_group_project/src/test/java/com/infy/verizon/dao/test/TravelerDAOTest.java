package com.infy.verizon.dao.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.infy.verizon.dao.TravelerDAO;
import com.infy.verizon.model.Traveler;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class TravelerDAOTest {
	
	@Autowired
	private TravelerDAO travelerDAO;

	
	@Test
	public void getPasswordOfAdminValidDetails() {
		travelerDAO.getPasswordOfTraveler("thu123");
		Assert.assertTrue(true);
	}
	
	@Test
	public void getPasswordOfAdminInValidDetails() {
		travelerDAO.getPasswordOfTraveler("t123");
		Assert.assertFalse(false);
	}
	
	
	@Test
	public void checkAvailabilityOfLoginIdValid(){
		Traveler traveler = new Traveler();
		traveler.setLoginId("tom123");
		travelerDAO.checkAvailabilityOfLoginId(traveler.getLoginId());
		
		Assert.assertTrue(true);
	}
	
	@Test
	public void checkAvailabilityOfLoginIdInValid(){
		
		Traveler traveler = new Traveler();
		traveler.setLoginId("thu123");
		travelerDAO.checkAvailabilityOfLoginId(traveler.getLoginId());
		
		Assert.assertFalse(false);
	}
	
	@Test 
	public void registerNewAdminValidDetails() {
		Traveler traveler = new Traveler();
		traveler.setLoginId("Jerry1992");
		
		traveler.setName("Jerry Abrahm");
	
		travelerDAO.registerNewTraveler(traveler);
		Assert.assertTrue(true);
	}
	
	@Test 
	public void registerNewAdminInValidDetails() {
		Traveler traveler = new Traveler();
		traveler.setLoginId("Je@rry1992");
		traveler.setName("Jerry Abrahm");
		
		travelerDAO.registerNewTraveler(traveler);
		Assert.assertFalse(false);
	}
	
	

	@Test
	public void getAdminByLoginIdValidDetails() {
		travelerDAO.getTravelerByLoginId("thu1234");
		Assert.assertTrue(true);
	}
	

	@Test
	public void getAdminByLoginIdInValidDetails() {
		travelerDAO.getTravelerByLoginId("jack");
		Assert.assertFalse(false);
	}
	
	
}

