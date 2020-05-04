package com.infy.verizon.validator.test;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import com.infy.verizon.model.Admin;
import com.infy.verizon.validator.AdminValidator;


public class AdminValidatorTest {
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public  void validateEmailValidFormat() throws Exception{
		Boolean result= AdminValidator.validateEmail("Jack@infosys.com");
		Assert.assertTrue(result);
	}

	@Test
	public  void validateEmailInValidFormat() throws Exception{
		// Invalid email contain number after '@'
		Boolean result= AdminValidator.validateEmail("Tom12@infosys1.c2om");
		Assert.assertFalse(result);
	}
	
	@Test
	public void validatePasswordValidFormat() throws Exception{
		Boolean result=AdminValidator.validatePassword("Jack@123");
		Assert.assertTrue(result);
	}
	
	@Test
	public void validatePasswordInValidFormat() throws Exception{
		Boolean result=AdminValidator.validatePassword("Tom@");
		Assert.assertFalse(result);
	}
	
	@Test
	public void validatePasswordInValidFormat1() throws Exception{
		Boolean result= AdminValidator.validatePassword("A123456");
		Assert.assertFalse(result);
	}
	@Test
	public void validatePasswordInValidFormat2() throws Exception{
		Boolean result=AdminValidator.validatePassword("a123456");
		Assert.assertFalse(result);
	}
	@Test
	public void validatePasswordInValidFormat3() throws Exception{
		Boolean result=AdminValidator.validatePassword("a123456A");
		Assert.assertFalse(result);
	}
	@Test
	public void validatePasswordInValidFormat4() throws Exception{
		Boolean result=AdminValidator.validatePassword("45658963214785");
		Assert.assertFalse(result);
	}
	
	@Test
	public void validateAdminLoginValidFormat() throws Exception{
		AdminValidator.validateAdminForLogin("thu123", "Abc123$");
		Assert.assertTrue(true);
		
	}
	@Test
	public void validateAdminLoginInValidFormat() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_LOGINID_FORMAT_FOR_LOGIN");
		AdminValidator.validateAdminForLogin("Jackinfosys.com", "Jack@123");
		Assert.assertFalse(false);
		
	}
	@Test
	public void validateAdminLoginInValidFormat1() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_EMAIL_FORMAT");
		AdminValidator.validateAdminForLogin("Jack@infosys.com", "Jack@23");
		Assert.assertFalse(false);
		
	}
	@Test
	public void validateAdminLoginInValidFormat2() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_PASSWORD_FORMAT");
		AdminValidator.validateAdminForLogin("Jack@infosys.com", "Jack23");
		Assert.assertFalse(false);
		
	}

	@Test
	public void validateAdminRegisterValidFormat() throws Exception{
		Admin admin =new Admin();
		admin.setName("Jerry Abrahm");
		admin.setEmail("Jerry1992@infosys.com");
		admin.setPassword("Jerry@123");
		admin.setLoginId("Jerry1992");
		AdminValidator.validateAdminForRegistration(admin);
	}
	
	@Test
	public void validateAdminRegisterInvalidLoginId() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_LOGINID");
		Admin admin =new Admin();
		admin.setEmail("Ja@ck12@infosys.com");
		admin.setName("Jack");
		admin.setPassword("Jack@123");
		admin.setLoginId("Jerry1992@");
		AdminValidator.validateAdminForRegistration(admin);
	}
	
	@Test
	public void validateAdminRegisterInvalidName1() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_NAME");
		Admin admin =new Admin();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("12Jack");
		admin.setPassword("Jack@123");
		admin.setLoginId("Jack12");
		AdminValidator.validateAdminForRegistration(admin);
	}
	
	@Test
	public void validateAdminRegisterInvalidName2() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_NAME");
		Admin admin =new Admin();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("Jack  jill");
		admin.setPassword("Jack@123");
		admin.setLoginId("Jack12@");
		AdminValidator.validateAdminForRegistration(admin);
	}
	
	@Test
	public void validateAdminRegisterInvalidName3() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_NAME");
		Admin admin =new Admin();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("Jack  ");
		admin.setPassword("Jack@123");
		admin.setLoginId("Jack12");
		AdminValidator.validateAdminForRegistration(admin);
	}
	
	@Test
	public void validateAdminRegisterInvalidName4() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_NAME");
		Admin admin =new Admin();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("#Jack");
		admin.setPassword("Jack@123");
		admin.setLoginId("Jack12@");
		AdminValidator.validateAdminForRegistration(admin);
	}
	
	
	@Test
	public void validateAdminRegisterInvalidName5() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_NAME");
		Admin admin =new Admin();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("   ");
		admin.setPassword("Jack@123");
		admin.setLoginId("Jack12");
		AdminValidator.validateAdminForRegistration(admin);
	}
	
	@Test
	public void validateAdminRegisterInvalidName6() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_NAME");
		Admin admin =new Admin();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("Jack1Jill");
		admin.setPassword("Jack@123");
		admin.setLoginId("Jack12");
		AdminValidator.validateAdminForRegistration(admin);
	}
	
	@Test
	public void validateAdminRegisterInvalidName7() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_NAME");
		Admin admin =new Admin();
		admin.setEmail("Jack12@infosys.com");
		admin.setName(" Jack Jill");
		admin.setPassword("Jack@123");
		admin.setLoginId("Jack12");
		AdminValidator.validateAdminForRegistration(admin);
	}
	
	
	
	@Test
	public void validateAdminRegisterInvalidPassword1() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_PASSWORD");
		Admin admin =new Admin();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("Jack");
		admin.setPassword("a123");
		admin.setLoginId("Jack12");
		AdminValidator.validateAdminForRegistration(admin);
	}
	
	@Test
	public void validateAdminRegisterInvalidPassword2() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_PASSWORD");
		Admin admin =new Admin();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("Jack");
		admin.setPassword("ABcd4567894321bdeklmsbx");
		admin.setLoginId("Jack12");
		AdminValidator.validateAdminForRegistration(admin);
	}
	
	@Test
	public void validateAdminRegisterInvalidPassword3() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_PASSWORD");
		Admin admin =new Admin();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("Jack");
		admin.setPassword("jackjill123");
		admin.setLoginId("Jack12");
		AdminValidator.validateAdminForRegistration(admin);
	}
	
	@Test
	public void validateAdminRegisterInvalidPassword4() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_PASSWORD");
		Admin admin =new Admin();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("Jack");
		admin.setPassword("JACKJILL123");
		admin.setLoginId("Jack12");
		AdminValidator.validateAdminForRegistration(admin);
	}
	
	@Test
	public void validateAdminRegisterInvalidPassword5() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_PASSWORD");
		Admin admin =new Admin();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("Jack");
		admin.setPassword("45@123456789");
		admin.setLoginId("Jack12");
		AdminValidator.validateAdminForRegistration(admin);
	}
	
	@Test
	public void validateAdminRegisterInvalidPassword6() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_PASSWORD");
		Admin admin =new Admin();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("Jack");
		admin.setPassword("Jack12345");
		admin.setLoginId("Jack12");
		AdminValidator.validateAdminForRegistration(admin);
	}
	

	@Test
	public void validateAdminRegisterInvalidPassword7() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_PASSWORD");
		Admin admin =new Admin();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("Jack");
		admin.setPassword("!@#$%^&*");
		admin.setLoginId("Jack12");
		AdminValidator.validateAdminForRegistration(admin);
	}
	
	@Test
	public void validateAdminRegisterInvalidPassword8() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("SellerValidator.INVALID_PASSWORD");
		Admin admin =new Admin();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("Jack");
		admin.setPassword(" asSDFADfg#$%");
		admin.setLoginId("Jack12");
		AdminValidator.validateAdminForRegistration(admin);
	}
	

	
	@Test
	public void validateAdminNameValidFormat1() throws Exception{
		Boolean result = AdminValidator.validateName("Jack Roger");
		Assert.assertTrue(result);
	}
	
	@Test
	public void validateAdminNameValidFormat2() throws Exception{
		Boolean result = AdminValidator.validateName("Jack");
		Assert.assertTrue(result);
	}
	
	@Test
	public void validateAdminNameInvalidFormat1() throws Exception{
		Boolean result = AdminValidator.validateName(" ");
		Assert.assertFalse(result);
	}
	
	@Test
	public void validateAdminNameInvalidFormat2() throws Exception{
		Boolean result = AdminValidator.validateName("1");
		Assert.assertFalse(result);
	}
	
	@Test
	public void validateAdminNameInvalidFormat3() throws Exception{
		Boolean result = AdminValidator.validateName("1 Jack ");
		Assert.assertFalse(result);
	}
	
	
	


}

