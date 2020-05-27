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

import com.infy.verizon.exception.AirportAPIException;
import com.infy.verizon.model.Airport;
import com.infy.verizon.service.AirportService;
import com.infy.verizon.validator.AirportValidationGroup;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;


@Api(tags = {"Airport API"})
@SwaggerDefinition(tags = {
    @Tag(name = "Airport API", description = "Airport API, used to create new airports.")
})
@CrossOrigin
@RestController
public class AirportAPI {
	
	@Autowired
	AirportService airportService;
	
	@Autowired
	private Environment environment;
	
	@ApiOperation(value="Add a new Airport")
	@PostMapping(value = "airport")
	public ResponseEntity<String> addAirport(
			@ApiParam(value = "Airport object used to create a new airport", required = true)
			@RequestBody @Validated(AirportValidationGroup.class) Airport airport) {
			
		Optional<String> newAirportId = airportService.addAirport(airport);
		
		if(!newAirportId.isPresent()){
			throw new AirportAPIException("AirportAPI.NULL_FIELD");
		}
			
		String message = environment.getProperty("AirportAPI.AIRPORT_ADDED_SUCCESSFULLY") + newAirportId;
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@ApiOperation(value="Delete an airport")
	@DeleteMapping(value = "airport/{airportId}")
	public ResponseEntity<String> removeAirport(
			@ApiParam(value = "Airport Id used to delete a specific airport", required = true)
			@PathVariable String airportId) {
		
		Optional<String> airportIdFromService = airportService.removeAirport(airportId);
		
		if(!airportIdFromService.isPresent()){
			throw new AirportAPIException("AirportAPI.AIRPORT_ID_DOES_NOT_EXIST");
		}
		
		String message = environment.getProperty("AirportAPI.AIRPORT_DELETED_SUCCESSFULLY") + airportIdFromService.get();
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@ApiOperation(value="Get list of airports")
	@GetMapping(value = "airport")
	public ResponseEntity<List<Airport>> getAirports() {
		
		Optional<List<Airport>> airportListFromService = airportService.getAirports();
		
		if(!airportListFromService.isPresent()){
			throw new AirportAPIException("AirportAPI.NO_AIRPORTS_IN_TABLE");
		}
		
		ResponseEntity<List<Airport>> response = new ResponseEntity<List<Airport>>(airportListFromService.get(), HttpStatus.OK);
		return response;
	}
	
}
