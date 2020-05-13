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

import com.infy.verizon.model.Flight;
import com.infy.verizon.service.FlightService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("FlightAPI")	// http://localhost:3333/verizon_group_project/FlightAPI
public class FlightAPI  {
	
	@Autowired
	private FlightService flightService;
	@Autowired
	private Environment environment;
	
	static Logger logger = LogManager.getLogger(BookingAPI.class.getName());
	
	@PostMapping(value = "addFlight")
	public ResponseEntity<String> addFlight(@RequestBody @Valid Flight flight) throws Exception{
		
		try{
			logger.info("Adding new Flight");
			
			Integer newFlightId = flightService.addFlight(flight);
			
			logger.info("Flight added successfully with ID: " + newFlightId);
			
			String message = environment.getProperty("FlightAPI.FLIGHT_ADDED_SUCCESSFULLY");
			return new ResponseEntity<String>(message, HttpStatus.OK);
		}
		catch(Exception e){
			logger.error("Failed to add Flight");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()));
		}	
	}
	
	@PostMapping(value = "removeFlight")
	public ResponseEntity<String> removeFlight(@RequestBody String flightId) throws Exception{
		
		try{
			logger.info("removing Flight with ID: " + flightId);
			flightService.removeFlight(Integer.parseInt(flightId));
			logger.info("Successfully removed Flight with ID: " + flightId);
			
			String message = environment.getProperty("FlightAPI.FLIGHT_DELETED_SUCCESSFULLY");
			return new ResponseEntity<String>(message, HttpStatus.OK);
		}
		catch(Exception e){
			logger.error("Failed to remove Flight with ID: " + flightId);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()));
		}
	}
	
	@GetMapping(value = "getFlights")
	public ResponseEntity<List<Flight>> getFlights() throws Exception{
		
		List<Flight> flightList = null;
		
		try{
			logger.info("Retrieving Flight list from database");
			flightList = flightService.getFlights();
			logger.info("Flight list retrieved");
			
			ResponseEntity<List<Flight>> response = new ResponseEntity<List<Flight>>(flightList, HttpStatus.OK);
			return response;
		}
		catch(Exception e){
			logger.error("Failed to retrieve Flight list form database");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()));
		}
	}
	
}
