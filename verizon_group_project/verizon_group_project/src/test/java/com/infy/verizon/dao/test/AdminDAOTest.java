package com.infy.verizon.dao.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.infy.verizon.dao.AdminDAO;
import com.infy.verizon.model.Admin;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class AdminDAOTest {
	@Autowired
	private AdminDAO adminDAO;

	
	@Test
	public void getPasswordOfAdminValidDetails(){
		adminDAO.getPasswordOfAdmin("thu123");
		Assert.assertTrue(true);
	}
	
	@Test
	public void getPasswordOfAdminInValidDetails(){
		adminDAO.getPasswordOfAdmin("t123");
		Assert.assertFalse(false);
	}
	
	
	@Test
	public void checkAvailabilityOfLoginIdValid(){
		Admin admin = new Admin();
		admin.setLoginId("tom123");
		adminDAO.checkAvailabilityOfLoginId(admin.getLoginId());
		
		Assert.assertTrue(true);
	}
	
	@Test
	public void checkAvailabilityOfLoginIdInValid(){
		
		Admin admin = new Admin();
		admin.setLoginId("mark123");
		adminDAO.checkAvailabilityOfLoginId(admin.getLoginId());
		
		Assert.assertFalse(false);
	}
	
	@Test 
	public void registerNewAdminValidDetails() {
		Admin admin = new Admin();
		admin.setLoginId("Jerry1992");
		
		admin.setName("Jerry Abrahm");
		
		
		adminDAO.registerNewAdmin(admin);
		Assert.assertTrue(true);
	}
	
	@Test 
	public void registerNewAdminInValidDetails() {
		Admin admin = new Admin();
		admin.setLoginId("Je@rry1992");
		admin.setName("Jerry Abrahm");
		
		adminDAO.registerNewAdmin(admin);
		Assert.assertFalse(false);
	}
	
	

	@Test
	public void getAdminByLoginIdValidDetails() throws Exception{
		adminDAO.getAdminByLoginId("thu123");
		Assert.assertTrue(true);
	}
	

	@Test
	public void getAdminByLoginIdInValidDetails() throws Exception{
		adminDAO.getAdminByLoginId("thu23");
		Assert.assertFalse(false);
	}
	
	
}

