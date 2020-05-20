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

import com.infy.verizon.exception.TravelerAPIException;
import com.infy.verizon.model.Traveler;
import com.infy.verizon.service.TravelerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@Api(tags= {"Swagger Resource"})
@SwaggerDefinition(tags= {
		@Tag(name ="Swagger Resource", description = "Traveler API, used to register and authenticate traveler")
})


@CrossOrigin
@RestController
//@RequestMapping("TravelerAPI")
public class TravelerAPI {
	@Autowired
	private TravelerService travelerService;
	
	@Autowired
	private Environment environment;
		
	@PostMapping(value = "registerTraveler")
	@ApiOperation(value="Register a new Traveler",
			      notes = "Provide username, password, name, and email to register", 
			      response = ResponseEntity.class)
	public ResponseEntity<String> registerTraveler(
			@ApiParam(value = "Traveler object was provided by user to register", required = true)
			@RequestBody @Valid Traveler traveler) throws Exception {
	
			Optional<Traveler> newTraveler = travelerService.registerNewTraveler(traveler);
			
			if (!newTraveler.isPresent()) {
				throw new TravelerAPIException("TravelerService.LOGIN_ID_ALREADY_IN_USE");
			}
						
			String registeredWithLoginId = environment.getProperty("TravelerAPI.TRAVELER_REGISTRATION_SUCCESS")+newTraveler.get().getLoginId();
			
			return new ResponseEntity<String>(registeredWithLoginId, HttpStatus.OK);
			
//			throw new ResponseStatusException(HttpStatus.CONFLICT, environment.getProperty(e.getMessage()));

	}
	
	@PostMapping(value = "travelerLogin")
	@ApiOperation(value="Authenticate traveler credentials",
			      notes = "Provide username, password to login", 
			      response = ResponseEntity.class)
	public ResponseEntity<Traveler> authenticateTraveler(
			@ApiParam(value = "Traveler object was provided by user to register", required = true)
			@RequestBody @Valid Traveler traveler) throws Exception {
	
			Optional<Traveler> travelerFromDB =  travelerService.authenticateTraveler(traveler.getLoginId(), traveler.getPassword());
			if (!travelerFromDB.isPresent()) {
				throw new TravelerAPIException("TravelerService.INVALID_CREDENTIALS");
			}
			
			return new ResponseEntity<Traveler>(travelerFromDB.get(), HttpStatus.OK);

//			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, environment.getProperty(e.getMessage()));

	}	
}

