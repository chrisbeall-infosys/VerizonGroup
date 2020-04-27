package com.infy.verizon.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.infy.verizon.model.Admin;
import com.infy.verizon.service.AdminService;

@CrossOrigin
@RestController
@RequestMapping("AdminAPI")
public class AdminAPI {
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AdminService adminLoginService;
	
	@Autowired
	private Environment environment;
	
	static Logger logger = LogManager.getLogger(AdminAPI.class.getName());
	
	@PostMapping(value = "registerAdmin")
	public ResponseEntity<String> registerAdmin(@RequestBody Admin admin) throws Exception {
		try
		{
			logger.info("ADMIN TRYING TO REGISTER. ADMIN LOGIN ID: "+admin.getLoginId());
			
			String registeredWithLoginId = adminService.registerNewAdmin(admin);
			
			logger.info("ADMIN REGISTRATION SUCCESSFUL. ADMIN LOGIN ID: "+admin.getLoginId());
			
			registeredWithLoginId = environment.getProperty("AdminAPI.ADMIN_REGISTRATION_SUCCESS")+registeredWithLoginId;
			
			return new ResponseEntity<String>(registeredWithLoginId, HttpStatus.OK);
			
		}
		catch (Exception e){
			if(e.getMessage().contains("Validator")){
				throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, environment.getProperty(e.getMessage()));
			}
			throw new ResponseStatusException(HttpStatus.CONFLICT, environment.getProperty(e.getMessage()));
		}
	}
	
	@PostMapping(value = "adminLogin")
	public ResponseEntity<Admin> authenticateAdmin(@RequestBody Admin admin) throws Exception {
		try
		{
			logger.info("ADMIN TRYING TO LOGIN. ADMIN LOGIN ID: "+admin.getLoginId());
			System.out.println("In api 1");
			
			Admin adminFromDB =  adminLoginService.authenticateAdmin(admin.getLoginId(), admin.getPassword());
			System.out.println("In api 2");
			
			logger.info("ADMIN LOGIN SUCCESSFUL. ADMIN LOGIN ID: "+admin.getLoginId());
			
			return new ResponseEntity<Admin>(adminFromDB, HttpStatus.OK);
		}
		catch (Exception e) {

			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, environment.getProperty(e.getMessage()));
		}
	}	
}
