package com.infy.verizon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.verizon.dao.AdminDAO;
import com.infy.verizon.model.Admin;
import com.infy.verizon.utility.HashingUtility;
import com.infy.verizon.validator.AdminValidator;

@Service(value="adminService" )
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDAO;
	
	@Override
	public String registerNewAdmin(Admin admin) throws Exception {
		
		String registeredWithLoginId = null;
		
		AdminValidator.validateAdminForRegistration(admin);
		Boolean available = adminDAO.checkAvailabilityOfLoginId(admin.getLoginId().toLowerCase());
		if(available){
			
				String loginIdToDB = admin.getLoginId().toLowerCase();
				String passwordToDB = HashingUtility.getHashValue(admin.getPassword());
				
				admin.setLoginId(loginIdToDB);
				admin.setPassword(passwordToDB);
				
				registeredWithLoginId = adminDAO.registerNewAdmin(admin);
				
		} else{
			throw new Exception("AdminService.LOGIN_ID_ALREADY_IN_USE");
		}
		
		return registeredWithLoginId;
	}

	@Override
	public Admin authenticateAdmin(String loginId, String password) throws Exception {
		System.out.println("In authenticate 1");
		Admin admin = null;
		loginId = loginId.toLowerCase();
		
		AdminValidator.validateAdminForLogin(loginId, password);

		String passwordFromDB = adminDAO.getPasswordOfAdmin(loginId);
		System.out.println("In authenticate 2");
		if(passwordFromDB != null){
			String hashedPassword = HashingUtility.getHashValue(password);
			System.out.println("In authenticate 3: " + hashedPassword + "Password: " + passwordFromDB);
			if(hashedPassword.equals(passwordFromDB)){
				System.out.println("In authenticate 4");
				admin  = adminDAO.getAdminByLoginId(loginId);
			}
			else
				throw new Exception ("AdminService.INVALID_CREDENTIALS");
		}
		else
			
			throw new Exception ("AdminService.INVALID_CREDENTIALS");
		
		return admin;
	}

}
