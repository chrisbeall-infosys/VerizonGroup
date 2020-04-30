package com.infy.verizon.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.infy.verizon.model.Flight;
import com.infy.verizon.service.FlightService;

@CrossOrigin
@RestController
@RequestMapping("FlightAPI")	// http://localhost:3333/verizon_group_project/FlightAPI
public class FlightAPI {
	
	@Autowired
	private FlightService flightService;
	@Autowired
	private Environment environment;
	
	@PostMapping(value = "addFlight")
	public ResponseEntity<String> addFlight(@RequestBody Flight flight) throws Exception{
		
		try{
			flightService.addFlight(flight);
			
			String message = environment.getProperty("FlightAPI.FLIGHT_ADDED_SUCCESSFULLY");
			return new ResponseEntity<String>(message, HttpStatus.OK);
		}
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()));
		}	
	}
	
	@PostMapping(value = "removeFlight")
	public ResponseEntity<String> removeFlight(@RequestBody String flightId) throws Exception{
		
		try{
			flightService.removeFlight(Integer.parseInt(flightId));
			
			String message = environment.getProperty("FlightAPI.FLIGHT_DELETED_SUCCESSFULLY");
			return new ResponseEntity<String>(message, HttpStatus.OK);
		}
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()));
		}
	}
	
	@GetMapping(value = "getFlights")
	public ResponseEntity<List<Flight>> getFlights() throws Exception{
		
		List<Flight> flightList = null;
		
		try{
			flightList = flightService.getFlights();
			
			ResponseEntity<List<Flight>> response = new ResponseEntity<List<Flight>>(flightList, HttpStatus.OK);
			return response;
		}
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()));
		}
	}
	
}
