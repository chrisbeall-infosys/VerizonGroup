package com.infy.verizon.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.verizon.dao.AdminDAO;
import com.infy.verizon.entity.AdminEntity;
import com.infy.verizon.model.Admin;
import com.infy.verizon.utility.HashingUtility;
import com.infy.verizon.validator.AdminValidator;

@Service(value="adminService" )
@Transactional
public class AdminServiceImpl implements AdminService {

	private Admin admin;
	
	
	@Autowired
	private AdminDAO adminDAO;
	
//	@Autowired
//	private PasswordEncoder bcryptEncoder;
//	
	@Override
	public String registerNewAdmin(Admin admin) throws Exception {
		
		String registeredWithLoginId = null;
		
		AdminValidator.validateAdminForRegistration(admin);
		Boolean available = adminDAO.checkAvailabilityOfLoginId(admin.getLoginId());
		if(available){
			
				String loginIdToDB = admin.getLoginId();
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
		
		this.admin = null;
		loginId = loginId.toLowerCase();
		
		AdminValidator.validateAdminForLogin(loginId, password);

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

//	@Override
//	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//		
//		Admin admin = null;
//		try {
//			admin = adminDAO.getAdminByLoginId(userName);
//			if (admin == null) {
//				throw new UsernameNotFoundException("AdminService.USER_NOT_FOUND" + userName);
//			}
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		return new org.springframework.security.core.userdetails.User(admin.getLoginId(), admin.getPassword(),
//				new ArrayList<>());
//	}
//		
	
	
}
