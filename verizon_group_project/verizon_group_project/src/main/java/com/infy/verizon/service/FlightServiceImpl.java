package com.infy.verizon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.verizon.dao.FlightDAO;
import com.infy.verizon.entity.FlightEntity;
import com.infy.verizon.exception.FlightServiceException;
import com.infy.verizon.model.Flight;

@Transactional
@Service(value = "flightService")
public class FlightServiceImpl implements FlightService{
	
	@Autowired
	private FlightDAO flightDAO;
	
	@Override
	public Optional<Integer> addFlight(Flight flight) {
		
		Optional<List<Flight>> existingFlights = flightDAO.getFlights();
		
		for(Flight existingFlight : existingFlights.get()){
			if(flight.getFlightId().equals(existingFlight.getFlightId())){
				throw new FlightServiceException("FlightService.FLIGHT_ID_ALREADY_EXISTS");
			}
		}
		Optional<FlightEntity> fromDAO = flightDAO.addFlight(flight);
		if (!fromDAO.isPresent()){ 
			throw new FlightServiceException("FlightService.NULL_FIELD");
		}
		return Optional.ofNullable(fromDAO.get().getFlightId());
	}
	
	@Override
	public Optional<Integer> removeFlight(Integer flightId) {
		Optional<List<Flight>> flightList = flightDAO.getFlights();
		boolean found = false;
		if(!flightList.isPresent()){
			throw new FlightServiceException("FlightService.FLIGHT_ID_DOES_NOT_EXIST");
		}
		for(Flight flight : flightList.get()){
			if(flight.getFlightId() == flightId){
				found = true;
				break;
			}
		}
		if(!found){
			throw new FlightServiceException("FlightService.FLIGHT_ID_DOES_NOT_EXIST");
		}
		return flightDAO.removeFlight(flightId);
		
	}
	
	@Override
	public Optional<List<Flight>> getFlights() {
		
		Optional<List<Flight>> flightList = flightDAO.getFlights();
		if(!flightList.isPresent() || flightList.get().isEmpty()){
			throw new FlightServiceException("FlightService.NO_FLIGHTS_IN_TABLE");
		}
		return flightList;	// should this return an empty list?
		
	}
	
}
