package com.infy.verizon.api;

import java.util.Optional;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.verizon.exception.AdminAPIException;
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
	private Environment environment;
	
	@PostMapping(value = "registerAdmin")
	@ApiOperation(value = "Register a new Admin", 
				  notes = "Provide username, password, name, and email to register", 
				  response = ResponseEntity.class)
	public ResponseEntity<String> registerAdmin(
			@ApiParam(value = "Admin object was provided by user to register", required = true)
			@RequestBody @Valid Admin admin) throws Exception {
		
			String registeredWithLoginId = null;
	
			Optional<Admin> newAdmin = adminService.registerNewAdmin(admin);
			
			if (!newAdmin.isPresent()) {
				throw new AdminAPIException("AdminService.LOGIN_ID_ALREADY_IN_USE");
			}
			
			registeredWithLoginId = environment.getProperty("AdminAPI.ADMIN_REGISTRATION_SUCCESS")+newAdmin.get().getLoginId();
			
			return new ResponseEntity<String>(registeredWithLoginId, HttpStatus.OK);
			

//			throw new ResponseStatusException(HttpStatus.CONFLICT, environment.getProperty(e.getMessage()));

	}
	
	@PostMapping(value = "adminLogin")
	@ApiOperation(value="Authenticate admin credentials",
			      notes = "Provide username, password to login", 
			      response = ResponseEntity.class)
	public ResponseEntity<Admin> authenticateAdmin(
			@ApiParam(value = "Admin object was provided by user to authenticate", required = true)
			@RequestBody @Valid Admin admin) throws Exception {

			Optional<Admin> adminFromDB =  adminService.authenticateAdmin(admin.getLoginId(), admin.getPassword());
			
			if (!adminFromDB.isPresent()) {
				throw new AdminAPIException("AdminService.INVALID_CREDENTIALS");
			}
			
			return new ResponseEntity<Admin>(adminFromDB.get(), HttpStatus.OK);

//			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, environment.getProperty(e.getMessage()));

	}	
}
