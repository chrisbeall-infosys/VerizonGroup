package com.infy.verizon.api;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.infy.verizon.model.Airport;
import com.infy.verizon.service.AirportService;

@CrossOrigin
@RestController
@RequestMapping("AirportAPI")	// http://localhost:3333/verizon_group_project/AirportAPI/
public class AirportAPI {
	
	@Autowired
	AirportService airportService;
	
	@Autowired
	private Environment environment;
	
	static Logger logger = LogManager.getLogger(BookingAPI.class.getName());
	
	@PostMapping(value = "addAirport")
	public ResponseEntity<String> addAirport(@RequestBody @Valid Airport airport) throws Exception{
		
		try{
			
			logger.info("Adding new Airport");
			
			String newAirportId = airportService.addAirport(airport);
			
			logger.info("Airport added successfully with ID: " + newAirportId);
			
			String message = environment.getProperty("AirportAPI.AIRPORT_ADDED_SUCCESSFULLY");
			return new ResponseEntity<String>(message, HttpStatus.OK);
		}
		catch(Exception e){
			logger.error("Failed to add Airport");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()));
		}	
	}
	
	@PostMapping(value = "removeAirport")
	public ResponseEntity<String> removeAirport(@RequestBody String airportId) throws Exception{
		
		try{
			logger.info("removing Airport with ID: " + airportId);
			airportService.removeAirport(airportId);
			logger.info("successfully removed Airport with ID: " + airportId);
			
			String message = environment.getProperty("AirportAPI.AIRPORT_DELETED_SUCCESSFULLY");
			return new ResponseEntity<String>(message, HttpStatus.OK);
		}
		catch(Exception e){
			logger.error("Failed to remove Airport with ID: " + airportId);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()));
		}
	}
	
	@GetMapping(value = "getAirports")
	public ResponseEntity<List<Airport>> getAirports() throws Exception{
		
		List<Airport> airportList = null;
		
		try{
			logger.info("Retrieving Airport list from Database");
			airportList = airportService.getAirports();
			logger.info("Airport list retrieved");
			
			ResponseEntity<List<Airport>> response = new ResponseEntity<List<Airport>>(airportList, HttpStatus.OK);
			return response;
		}
		catch(Exception e){
			logger.error("Failed to retrieve Airport list form database");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()));
		}
	}
	
}
