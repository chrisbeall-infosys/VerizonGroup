package com.infy.verizon.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.verizon.dao.AdminDAO;
import com.infy.verizon.exception.AdminServiceException;
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
			throw new AdminServiceException("AdminService.LOGIN_ID_ALREADY_IN_USE");
		}
		
		return newAdmin;
	}

	@Override
	public Optional<Admin> authenticateAdmin(String loginId, String password) throws Exception {
		
		Optional<Admin> admin = Optional.empty();
		loginId = loginId.toLowerCase();

		String passwordToDB = HashingUtility.getHashValue(password);
		
		String adminLoginIdFromDAO = adminDAO.authenticateAdmin(loginId, passwordToDB);
		
		if(adminLoginIdFromDAO !=null){
			
				admin  = adminDAO.getAdminByLoginId(adminLoginIdFromDAO);
		}
		else
			throw new AdminServiceException("AdminService.INVALID_CREDENTIALS");
		
		return admin;
	}

}
