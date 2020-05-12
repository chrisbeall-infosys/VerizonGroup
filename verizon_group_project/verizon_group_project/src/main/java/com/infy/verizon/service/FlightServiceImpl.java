package com.infy.verizon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.verizon.dao.FlightDAO;
import com.infy.verizon.entity.FlightEntity;
import com.infy.verizon.model.Flight;

@Transactional
@Service(value = "flightService")
public class FlightServiceImpl implements FlightService{
	
	@Autowired
	private FlightDAO flightDAO;
	
	@Override
	public Integer addFlight(Flight flight) throws Exception {
		
		List<Flight> existingFlights = flightDAO.getFlights();
		
		for(Flight existingFlight : existingFlights){
			if(flight.getFlightId().equals(existingFlight.getFlightId())){
				throw new Exception("FlightService.FLIGHT_ID_ALREADY_EXISTS");
			}
		}
		FlightEntity fromDAO = flightDAO.addFlight(flight);
		if (fromDAO == null){ 
			throw new Exception("FlightService.NULL_FIELD");
		}
		return fromDAO.getFlightId();
	}
	
	@Override
	public void removeFlight(Integer flightId) throws Exception {
		flightDAO.removeFlight(flightId);
	}
	
	@Override
	public List<Flight> getFlights() throws Exception {
		
		List<Flight> flightList = flightDAO.getFlights();
		if(flightList == null || flightList.isEmpty()){
			throw new Exception("FlightService.NO_FLIGHTS_IN_TABLE");
		}
		return flightList;
		
	}
	
}
