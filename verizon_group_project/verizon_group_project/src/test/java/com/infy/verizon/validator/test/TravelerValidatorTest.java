package com.infy.verizon.validator.test;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.infy.verizon.model.Traveler;
import com.infy.verizon.validator.TravelerValidator;


public class TravelerValidatorTest {
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public  void validateEmailValidFormat() throws Exception{
		Boolean result= TravelerValidator.validateEmail("Jack@infosys.com");
		Assert.assertTrue(result);
	}

	@Test
	public  void validateEmailInValidFormat() throws Exception{
		// Invalid email contain number after '@'
		Boolean result= TravelerValidator.validateEmail("Tom12@infosys1.c2om");
		Assert.assertFalse(result);
	}
	
	@Test
	public void validatePasswordValidFormat() throws Exception{
		Boolean result=TravelerValidator.validatePassword("Jack@123");
		Assert.assertTrue(result);
	}
	
	@Test
	public void validatePasswordInValidFormat() throws Exception{
		Boolean result=TravelerValidator.validatePassword("Tom@");
		Assert.assertFalse(result);
	}
	
	@Test
	public void validatePasswordInValidFormat1() throws Exception{
		Boolean result= TravelerValidator.validatePassword("A123456");
		Assert.assertFalse(result);
	}
	@Test
	public void validatePasswordInValidFormat2() throws Exception{
		Boolean result=TravelerValidator.validatePassword("a123456");
		Assert.assertFalse(result);
	}
	@Test
	public void validatePasswordInValidFormat3() throws Exception{
		Boolean result=TravelerValidator.validatePassword("a123456A");
		Assert.assertFalse(result);
	}
	@Test
	public void validatePasswordInValidFormat4() throws Exception{
		Boolean result=TravelerValidator.validatePassword("45658963214785");
		Assert.assertFalse(result);
	}
	
	@Test
	public void validateTravelerLoginValidFormat() throws Exception{
		TravelerValidator.validateTravelerForLogin("thu123", "Abc123$");
		Assert.assertTrue(true);
		
	}
	@Test
	public void validateTravelerLoginInValidFormat() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("TravelerValidator.INVALID_LOGINID_FORMAT_FOR_LOGIN");
		TravelerValidator.validateTravelerForLogin("Jackinfosys.com", "Jack@123");
		Assert.assertFalse(false);
		
	}
	@Test
	public void validateTravelerLoginInValidFormat1() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("TravelerValidator.INVALID_LOGINID_FORMAT_FOR_LOGIN");
		TravelerValidator.validateTravelerForLogin("Jack@infosys.com", "Jack@23");
		Assert.assertFalse(false);
		
	}
	@Test
	public void validateTravelerLoginInValidFormat2() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("TravelerValidator.INVALID_PASSWORD_FORMAT_FOR_LOGIN");
		TravelerValidator.validateTravelerForLogin("Jack123", "Jack23");
		Assert.assertFalse(false);
		
	}

	@Test
	public void validateTravelerRegisterValidFormat() throws Exception{
		Traveler traveler =new Traveler();
		traveler.setName("Jerry Abrahm");
		traveler.setEmail("Jerry1992@infosys.com");
		traveler.setPassword("Jerry@123");
		traveler.setLoginId("Jerry1992");
		TravelerValidator.validateTravelerForRegistration(traveler);
	}
	
	@Test
	public void validateTravelerRegisterInvalidLoginId() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("TravelerValidator.INVALID_LOGINID");
		Traveler admin =new Traveler();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("Jack");
		admin.setPassword("Jack@123");
		admin.setLoginId("Jerry1992@");
		TravelerValidator.validateTravelerForRegistration(admin);
	}
	
	@Test
	public void validateTravelerRegisterInvalidName1() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("TravelerValidator.INVALID_NAME");
		Traveler admin =new Traveler();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("12Jack");
		admin.setPassword("Jack@123");
		admin.setLoginId("Jack12");
		TravelerValidator.validateTravelerForRegistration(admin);
	}
	
	@Test
	public void validateTravelerRegisterInvalidName2() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("TravelerValidator.INVALID_NAME");
		Traveler admin =new Traveler();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("Jack  jill");
		admin.setPassword("Jack@123");
		admin.setLoginId("Jack12@");
		TravelerValidator.validateTravelerForRegistration(admin);
	}
	
	@Test
	public void validateTravelerRegisterInvalidName3() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("TravelerValidator.INVALID_NAME");
		Traveler admin =new Traveler();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("Jack  ");
		admin.setPassword("Jack@123");
		admin.setLoginId("Jack12");
		TravelerValidator.validateTravelerForRegistration(admin);
	}
	
	@Test
	public void validateTravelerRegisterInvalidName4() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("TravelerValidator.INVALID_NAME");
		Traveler admin =new Traveler();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("#Jack");
		admin.setPassword("Jack@123");
		admin.setLoginId("Jack12@");
		TravelerValidator.validateTravelerForRegistration(admin);
	}
	
	
	@Test
	public void validateTravelerRegisterInvalidName5() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("TravelerValidator.INVALID_NAME");
		Traveler admin =new Traveler();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("   ");
		admin.setPassword("Jack@123");
		admin.setLoginId("Jack12");
		TravelerValidator.validateTravelerForRegistration(admin);
	}
	
	@Test
	public void validateTravelerRegisterInvalidName6() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("TravelerValidator.INVALID_NAME");
		Traveler admin =new Traveler();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("Jack1Jill");
		admin.setPassword("Jack@123");
		admin.setLoginId("Jack12");
		TravelerValidator.validateTravelerForRegistration(admin);
	}
	
	@Test
	public void validateTravelerRegisterInvalidName7() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("TravelerValidator.INVALID_NAME");
		Traveler admin =new Traveler();
		admin.setEmail("Jack12@infosys.com");
		admin.setName(" Jack Jill");
		admin.setPassword("Jack@123");
		admin.setLoginId("Jack12");
		TravelerValidator.validateTravelerForRegistration(admin);
	}
	
	
	
	@Test
	public void validateTravelerRegisterInvalidPassword1() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("TravelerValidator.INVALID_PASSWORD");
		Traveler admin =new Traveler();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("Jack");
		admin.setPassword("a123");
		admin.setLoginId("Jack12");
		TravelerValidator.validateTravelerForRegistration(admin);
	}
	
	@Test
	public void validateTravelerRegisterInvalidPassword2() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("TravelerValidator.INVALID_PASSWORD");
		Traveler admin =new Traveler();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("Jack");
		admin.setPassword("ABcd4567894321bdeklmsbx");
		admin.setLoginId("Jack12");
		TravelerValidator.validateTravelerForRegistration(admin);
	}
	
	@Test
	public void validateTravelerRegisterInvalidPassword3() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("TravelerValidator.INVALID_PASSWORD");
		Traveler admin =new Traveler();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("Jack");
		admin.setPassword("jackjill123");
		admin.setLoginId("Jack12");
		TravelerValidator.validateTravelerForRegistration(admin);
	}
	
	@Test
	public void validateTravelerRegisterInvalidPassword4() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("TravelerValidator.INVALID_PASSWORD");
		Traveler admin =new Traveler();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("Jack");
		admin.setPassword("JACKJILL123");
		admin.setLoginId("Jack12");
		TravelerValidator.validateTravelerForRegistration(admin);
	}
	
	@Test
	public void validateTravelerRegisterInvalidPassword5() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("TravelerValidator.INVALID_PASSWORD_FORMAT");
		Traveler admin =new Traveler();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("Jack");
		admin.setPassword("45@123456789");
		admin.setLoginId("Jack12");
		TravelerValidator.validateTravelerForRegistration(admin);
	}
	
	@Test
	public void validateTravelerRegisterInvalidPassword6() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("TravelerValidator.INVALID_PASSWORD");
		Traveler admin =new Traveler();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("Jack");
		admin.setPassword("Jack12345");
		admin.setLoginId("Jack12");
		TravelerValidator.validateTravelerForRegistration(admin);
	}
	

	@Test
	public void validateTravelerRegisterInvalidPassword7() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("TravelerValidator.INVALID_PASSWORD");
		Traveler admin =new Traveler();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("Jack");
		admin.setPassword("!@#$%^&*");
		admin.setLoginId("Jack12");
		TravelerValidator.validateTravelerForRegistration(admin);
	}
	
	@Test
	public void validateTravelerRegisterInvalidPassword8() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("TravelerValidator.INVALID_PASSWORD");
		Traveler admin =new Traveler();
		admin.setEmail("Jack12@infosys.com");
		admin.setName("Jack");
		admin.setPassword(" asSDFADfg#$%");
		admin.setLoginId("Jack12");
		TravelerValidator.validateTravelerForRegistration(admin);
	}
	

	
	@Test
	public void validateTravelerNameValidFormat1() throws Exception{
		Boolean result = TravelerValidator.validateName("Jack Roger");
		Assert.assertTrue(result);
	}
	
	@Test
	public void validateTravelerNameValidFormat2() throws Exception{
		Boolean result = TravelerValidator.validateName("Jack");
		Assert.assertTrue(result);
	}
	
	@Test
	public void validateTravelerNameInvalidFormat1() throws Exception{
		Boolean result = TravelerValidator.validateName(" ");
		Assert.assertFalse(result);
	}
	
	@Test
	public void validateTravelerNameInvalidFormat2() throws Exception{
		Boolean result = TravelerValidator.validateName("1");
		Assert.assertFalse(result);
	}
	
	@Test
	public void validateTravelerNameInvalidFormat3() throws Exception{
		Boolean result = TravelerValidator.validateName("1 Jack ");
		Assert.assertFalse(result);
	}
	
	
	


}

