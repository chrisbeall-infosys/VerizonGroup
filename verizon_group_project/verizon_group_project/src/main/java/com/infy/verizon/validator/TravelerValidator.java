package com.infy.verizon.validator;

import com.infy.verizon.model.Traveler;

public class TravelerValidator {
	
	public static void validateTraveler(Traveler traveler) throws Exception {
		
		if(!validateEmail(traveler.getEmail()))
			throw new Exception("TravelerValidator.INVALID_EMAIL_FORMAT");
		
		if(!validateName(traveler.getName()))
			throw new Exception("TravelerValidator.INVALID_NAME");
		
		if(!validatePassword(traveler.getPassword()))
			throw new Exception("TravelerValidator.INVALID_PASSWORD_FORMAT");
			
	}
	
	public static void validateTravelerForRegistration(Traveler traveler) throws Exception {
		if(!validateEmail(traveler.getEmail()))
			throw new Exception("AdminValidator.INVALID_EMAIL_FORMAT");

		if(!validateName(traveler.getName()))
			throw new Exception("AdminValidator.INVALID_NAME");
		
		if(!validatePassword(traveler.getPassword()))
			throw new Exception("AdminValidator.INVALID_PASSWORD_FORMAT");
		
		if(!validateLoginId(traveler.getLoginId()))
			throw new Exception("AdminValidator.INVALID_LOGINID");
		
	}
	
	public static Boolean validateName(String name){
		Boolean flag = false;
		if(!name.matches("[ ]*") && name.matches("([A-Za-z])+(\\s[A-Za-z]+)*"))
			flag=true;
		return flag;
	}


	public static Boolean validateEmail(String email){
		Boolean flag = false;
		if(email.matches("[a-zA-Z0-9._]+@[a-zA-Z]{2,}\\.[a-zA-Z][a-zA-Z.]+"))
			flag = true;
		return flag;
	}
	
	
	
	public static Boolean validatePassword(String password){
		Boolean flag = false;
		if (password.length()>=6 && password.length()<=20)
			if(password.matches(".*[A-Z]+.*"))
				if(password.matches(".*[a-z]+.*"))
					if(password.matches(".*[0-9]+.*"))
						if(password.matches(".*[^a-zA-Z-0-9].*"))
							flag = true;
		return flag;
	}
	
	public static Boolean validateLoginId(String loginId)  {
		return loginId.matches("[a-zA-Z0-9]{6,15}");
	}
	
	
}
