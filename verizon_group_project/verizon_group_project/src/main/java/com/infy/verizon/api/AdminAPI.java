package com.infy.verizon.api;

import java.util.Optional;

import javax.validation.Valid;

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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@Api(tags= {"Swagger Resource"})
@SwaggerDefinition(tags= {
		@Tag(name ="Swagger Resource", description = "Admin API, used to register and authenticate admin")
})

@CrossOrigin
@RestController
//@RequestMapping("AdminAPI")
public class AdminAPI {
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AdminService adminLoginService;
	
	@Autowired
	private Environment environment;
	
	static Logger logger = LogManager.getLogger(AdminAPI.class.getName());
	
	@PostMapping(value = "registerAdmin")
	@ApiOperation(value="Register a new Admin")
	public ResponseEntity<String> registerAdmin(
			@ApiParam(value = "Admin object was provided by user to register", required = true)
			@RequestBody @Valid Admin admin) throws Exception {
		
		String registeredWithLoginId = null;
//		try
//		{
			//logger.info("ADMIN TRYING TO REGISTER. ADMIN LOGIN ID: "+admin.getLoginId());
			
			Optional<Admin> newAdmin = adminService.registerNewAdmin(admin);
			
			//logger.info("ADMIN REGISTRATION SUCCESSFUL. ADMIN LOGIN ID: "+admin.getLoginId());
			
			registeredWithLoginId = environment.getProperty("AdminAPI.ADMIN_REGISTRATION_SUCCESS")+registeredWithLoginId;
			
			return new ResponseEntity<String>(registeredWithLoginId, HttpStatus.OK);
			
//		}
//		catch (Exception e){
//			if(e.getMessage().contains("Validator")){
//				throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, environment.getProperty(e.getMessage()));
//			}
//			throw new ResponseStatusException(HttpStatus.CONFLICT, environment.getProperty(e.getMessage()));
//		}
	}
	
	@PostMapping(value = "adminLogin")
	@ApiOperation(value="Authenticate admin credentials")
	public ResponseEntity<Admin> authenticateAdmin(
			@ApiParam(value = "Admin object was provided by user to authenticate", required = true)
			@RequestBody @Valid Admin admin) throws Exception {
		try
		{
			//logger.info("ADMIN TRYING TO LOGIN. ADMIN LOGIN ID: "+admin.getLoginId());
			
			
			Admin adminFromDB =  adminLoginService.authenticateAdmin(admin.getLoginId(), admin.getPassword());
			
			
			//logger.info("ADMIN LOGIN SUCCESSFUL. ADMIN LOGIN ID: "+admin.getLoginId());
			
			return new ResponseEntity<Admin>(adminFromDB, HttpStatus.OK);
		}
		catch (Exception e) {

			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, environment.getProperty(e.getMessage()));
		}
	}	
}
