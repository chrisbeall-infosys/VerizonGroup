package com.infy.verizon.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.verizon.dao.AdminDAO;
import com.infy.verizon.model.Admin;
import com.infy.verizon.utility.HashingUtility;


@Service(value="adminService" )
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDAO;
	
	@Override
	public Optional<Admin> registerNewAdmin(Admin admin) throws Exception {
		
		Optional<Admin> newAdmin = Optional.empty();
		
		//AdminValidator.validateAdminForRegistration(admin);
		Boolean available = adminDAO.checkAvailabilityOfLoginId(admin.getLoginId());
		if(available){
			
				String loginIdToDB = admin.getLoginId();
				String passwordToDB = HashingUtility.getHashValue(admin.getPassword());
				
				admin.setLoginId(loginIdToDB);
				admin.setPassword(passwordToDB);

				
				newAdmin = adminDAO.registerNewAdmin(admin);

				
		} else{
			throw new Exception("AdminService.LOGIN_ID_ALREADY_IN_USE");
		}
		
		return newAdmin;
	}

	@Override
	public Admin authenticateAdmin(String loginId, String password) throws Exception {
		
		Admin admin = null;
		loginId = loginId.toLowerCase();
		
		//AdminValidator.validateAdminForLogin(loginId, password);

		String passwordFromDB = adminDAO.getPasswordOfAdmin(loginId);
		
		if(passwordFromDB != null){
			String hashedPassword = HashingUtility.getHashValue(password);
			
			if(hashedPassword.equals(passwordFromDB)){
				
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
