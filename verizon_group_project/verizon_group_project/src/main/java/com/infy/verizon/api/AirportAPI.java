package com.infy.verizon.api;

import java.util.List;

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
	
	@PostMapping(value = "addAirport")
	public ResponseEntity<String> addAirport(@RequestBody Airport airport) throws Exception{
		
		try{
			airportService.addAirport(airport);
			
			String message = environment.getProperty("AirportAPI.AIRPORT_ADDED_SUCCESSFULLY");
			return new ResponseEntity<String>(message, HttpStatus.OK);
		}
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()));
		}	
	}
	
	@PostMapping(value = "removeAirport")
	public ResponseEntity<String> removeAirport(@RequestBody String airportId) throws Exception{
		
		try{
			airportService.removeAirport(Integer.parseInt(airportId));
			
			String message = environment.getProperty("AirportAPI.AIRPORT_DELETED_SUCCESSFULLY");
			return new ResponseEntity<String>(message, HttpStatus.OK);
		}
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()));
		}
	}
	
	@GetMapping(value = "getAirports")
	public ResponseEntity<List<Airport>> getAirports() throws Exception{
		
		List<Airport> airportList = null;
		
		try{
			airportList = airportService.getAirports();
			
			ResponseEntity<List<Airport>> response = new ResponseEntity<List<Airport>>(airportList, HttpStatus.OK);
			return response;
		}
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()));
		}
	}
	
}
