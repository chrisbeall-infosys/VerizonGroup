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

import com.infy.verizon.model.Traveler;
import com.infy.verizon.service.TravelerService;

@CrossOrigin
@RestController
@RequestMapping("TravelerAPI")
public class TravelerAPI {
	@Autowired
	private TravelerService travelerService;
	
	@Autowired
	private Environment environment;
	
	static Logger logger = LogManager.getLogger(TravelerAPI.class.getName());
	
	@PostMapping(value = "registerTraveler")
	public ResponseEntity<String> registerTraveler(@RequestBody Traveler traveler) throws Exception {
		try
		{
			logger.info("TRAVELER TRYING TO REGISTER. TRAVELER LOGIN ID: "+ traveler.getLoginId());
			
			String registeredWithLoginId = travelerService.registerNewTraveler(traveler);
			
			logger.info("TRAVELER REGISTRATION SUCCESSFUL. TRAVELER LOGIN ID: "+ traveler.getLoginId());
			
			registeredWithLoginId = environment.getProperty("TravelerAPI.TRAVELER_REGISTRATION_SUCCESS")+registeredWithLoginId;
			
			return new ResponseEntity<String>(registeredWithLoginId, HttpStatus.OK);
			
		}
		catch (Exception e){
			if(e.getMessage().contains("Validator")){
				throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, environment.getProperty(e.getMessage()));
			}
			throw new ResponseStatusException(HttpStatus.CONFLICT, environment.getProperty(e.getMessage()));
		}
	}
	
	@PostMapping(value = "travelerLogin")
	public ResponseEntity<Traveler> authenticateTraveler(@RequestBody Traveler traveler) throws Exception {
		try
		{	
			logger.info("TRAVELER TRYING TO LOGIN. TRAVELER LOGIN ID: "+traveler.getLoginId());
			
			Traveler travelerFromDB =  travelerService.authenticateTraveler(traveler.getLoginId(), traveler.getPassword());
			
			logger.info("TRAVELER LOGIN SUCCESSFUL. TRAVELER LOGIN ID: "+traveler.getLoginId());
			
			return new ResponseEntity<Traveler>(travelerFromDB, HttpStatus.OK);
		}
		catch (Exception e) {

			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, environment.getProperty(e.getMessage()));
		}
	}	
}

