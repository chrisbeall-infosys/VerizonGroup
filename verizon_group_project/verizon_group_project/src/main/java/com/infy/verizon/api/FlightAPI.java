package com.infy.verizon.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.verizon.exception.FlightAPIException;
import com.infy.verizon.model.Flight;
import com.infy.verizon.service.FlightService;
import com.infy.verizon.validator.FlightValidationGroup;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@Api(tags = {"Flight API"})
@SwaggerDefinition(tags = {
    @Tag(name = "Flight API", description = "Flight API, used to create new flights.")
})
@CrossOrigin
@RestController
//@RequestMapping("FlightAPI")	// http://localhost:3333/verizon_group_project/FlightAPI
public class FlightAPI  {
	
	@Autowired
	private FlightService flightService;
	@Autowired
	private Environment environment;
	
	@ApiOperation(value="Add a new flight")
	@PostMapping(value = "flight")
	public ResponseEntity<String> addFlight(
			@ApiParam(value = "Flight object used to create a new flight", required = true)
			@RequestBody @Validated(FlightValidationGroup.class) Flight flight) {
			
		Optional<Integer> newFlightId = flightService.addFlight(flight);
		
		if(!newFlightId.isPresent()){
			throw new FlightAPIException("FlightAPI.NULL_FIELD");
		}
			
		String message = environment.getProperty("FlightAPI.FLIGHT_ADDED_SUCCESSFULLY") + newFlightId.get();
		return new ResponseEntity<String>(message, HttpStatus.OK);
		
			
	}
	
	@ApiOperation(value="Delete a flight")
	@DeleteMapping(value = "flight/{flightId}")
	public ResponseEntity<String> removeFlight(
			@ApiParam(value = "Flight Id used to delete a spacific flight", required = true)
			@PathVariable String flightId) {
		
		Optional<Integer> flightIdFromService = flightService.removeFlight(Integer.parseInt(flightId));
		
		if(!flightIdFromService.isPresent()){
			throw new FlightAPIException("FlightAPI.FLIGHT_ID_DOES_NOT_EXIST");
		}
		
		String message = environment.getProperty("FlightAPI.FLIGHT_DELETED_SUCCESSFULLY") + flightIdFromService.get();
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@ApiOperation(value="Get list of flights")
	@GetMapping(value = "flight")
	public ResponseEntity<List<Flight>> getFlights() {
		
		Optional<List<Flight>> flightListFromService = flightService.getFlights();
		
		if(!flightListFromService.isPresent()){
			throw new FlightAPIException("FlightAPI.NO_FLIGHTS_IN_TABLE");
		}
		
		ResponseEntity<List<Flight>> response = new ResponseEntity<List<Flight>>(flightListFromService.get(), HttpStatus.OK);
		return response;
		
	}
	
}
