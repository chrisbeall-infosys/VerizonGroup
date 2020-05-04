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

import com.infy.verizon.dao.AdminDAO;
import com.infy.verizon.model.Admin;
import com.infy.verizon.service.AdminService;
import com.infy.verizon.service.AdminServiceImpl;
import com.infy.verizon.utility.HashingUtility;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {
	@Mock
	private AdminDAO adminDAO;
	@InjectMocks
	private AdminService adminService=new AdminServiceImpl();
	@Rule
	public ExpectedException expectedException=ExpectedException.none();
	
	@Test
	public void testAuthenticateAdmin() throws Exception{
		String loginId="thu123";
		String password="Abc123$";
		String hashedPassword = HashingUtility.getHashValue(password);

		Mockito.when(adminDAO.getPasswordOfAdmin(loginId)).thenReturn(hashedPassword);
		Mockito.when(adminDAO.getAdminByLoginId(loginId)).thenReturn(new Admin());
		Assert.assertNotNull(adminService.authenticateAdmin(loginId, password));
	}
	@Test
	public void testAuthenticateAdminInvalid() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_LOGINID_FORMAT_FOR_LOGIN");
		String loginId="thu12";
		String password="Jack@123";
		
		Mockito.when(adminDAO.getPasswordOfAdmin(loginId)).thenReturn(password);
		Mockito.when(adminDAO.getAdminByLoginId(loginId)).thenReturn(new Admin());
		Assert.assertNotNull(adminService.authenticateAdmin(loginId, password));
	}
	@Test
	public void testAuthenticateAdminInvalidLoginId() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminService.INVALID_CREDENTIALS");
		String loginId="Jac77897";
		String password="Jack@123";
		
		Mockito.when(adminDAO.getPasswordOfAdmin(loginId)).thenReturn(password);
		Mockito.when(adminDAO.getAdminByLoginId(loginId)).thenReturn(new Admin());
		adminService.authenticateAdmin(loginId, password);
	}
	@Test
	public void testAuthenticateAdminInvalidPassword() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_PASSWORD_FORMAT");
		String loginId="thu123";
		String password="jack@3";
		
		Assert.assertNotNull(adminService.authenticateAdmin(loginId, password));
	}
	
	@Test
	public void testAuthenticateAdminInvalidFormat() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminService.INVALID_CREDENTIALS");
		String loginId="Jack123";
		String password="Jack@123";
		
		Mockito.when(adminDAO.getPasswordOfAdmin(loginId)).thenReturn(null);
		Mockito.when(adminDAO.getAdminByLoginId(loginId)).thenReturn(new Admin());
		Assert.assertNotNull(adminService.authenticateAdmin(loginId, password));
	}
	
	
	@Test
	public void testRegisterNewAdmin() throws Exception{
		Admin admin =new Admin();
		admin.setName("Jerry Abrahm");
		admin.setLoginId("Jerry1992");
		admin.setPassword("Jerry@123");
		admin.setEmail("Jerry@infy.com");
		Mockito.when(adminDAO.checkAvailabilityOfLoginId(admin.getLoginId())).thenReturn(true);
		Mockito.when(adminDAO.registerNewAdmin(admin)).thenReturn("Jerry1992");
		adminService.registerNewAdmin(admin);

	}
	
	@Test
	public void registerNewAdminExistingLoginId() throws Exception {
		
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminService.LOGIN_ID_ALREADY_IN_USE");
		
		Admin admin = new Admin();
		admin.setLoginId("thu123");
		admin.setName("Thu");
		admin.setPassword("Thu@123");
		admin.setEmail("thu@infy.com");
		Mockito.when(adminDAO.checkAvailabilityOfLoginId(admin.getLoginId())).thenReturn(false);
		System.out.println("Is Available? " + adminDAO.checkAvailabilityOfLoginId(admin.getLoginId()));
		Assert.assertNull(adminService.registerNewAdmin(admin));
	}
	
	@Test
	public void testRegisterNewAdminInValidEmail() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_EMAIL_FORMAT");
		Admin admin =new Admin();
		admin.setEmail("Ja@ck12@infosys.com");
		admin.setName("Jack");
		admin.setPassword("Jack@123");
		Assert.assertNotNull(adminService.registerNewAdmin(admin));

	}

	@Test
	public void testRegisterNewAdminInValidName() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_NAME");
		Admin admin =new Admin();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("12Jack");
		admin.setPassword("Jack@123");
		Assert.assertNotNull(adminService.registerNewAdmin(admin));

	}
	@Test
	public void testRegisterNewSellerInValidPassword() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_PASSWORD");
		Admin admin =new Admin();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("Jack");
		admin.setPassword("a123");
		Assert.assertNotNull(adminService.registerNewAdmin(admin));

	}
	
	
}
