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

import com.infy.verizon.api.AdminAPI;
import com.infy.verizon.exception.AdminAPIException;
import com.infy.verizon.model.Admin;
import com.infy.verizon.service.AdminService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminAPITest {
	@Rule 
	public ExpectedException ee = ExpectedException.none();
	
	@Mock
	private AdminService adminService;
	
	@Mock
	private Environment environment;
	
	@InjectMocks
	private AdminAPI adminAPI = new AdminAPI();
	
	private Admin admin = new Admin();
	
	@Before
	public void setup() {
		
		admin.setEmail("thu123@info.com");
		admin.setLoginId("thu123");
		admin.setName("thu");
		admin.setPassword("Abc123#");
	}
	
	@Test
	public void testRegisterAdminValid() throws Exception {
		
		Optional<Admin> adminOp = Optional.of(admin);
		
		Mockito.when(adminService.registerNewAdmin(Mockito.any())).thenReturn(adminOp);
		Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("success");
		
		ResponseEntity<String> response = adminAPI.registerAdmin(admin);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void testRegisterAdminInValid() throws Exception {
		admin.setLoginId("thu123");
		ee.expect(AdminAPIException.class);
		ee.expectMessage("AdminService.LOGIN_ID_ALREADY_IN_USE");
		
		adminAPI.registerAdmin(admin);
		
	}
	
	@Test
	public void testAuthenticateAdminValid() throws Exception {
		
		Optional<Admin> adminOp = Optional.of(admin);
		
		Mockito.when(adminService.authenticateAdmin(admin.getLoginId(), admin.getPassword())).thenReturn(adminOp);
		Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("success");

		ResponseEntity<Admin> response = adminAPI.authenticateAdmin(admin);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void testAuthenticateAdminInValid() throws Exception {
		admin.setLoginId("thu124");
		ee.expect(AdminAPIException.class);
		ee.expectMessage("AdminService.INVALID_CREDENTIALS");
		
		adminAPI.authenticateAdmin(admin);
	
	}
	
}
