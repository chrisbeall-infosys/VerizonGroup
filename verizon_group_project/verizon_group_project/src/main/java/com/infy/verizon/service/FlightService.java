package com.infy.verizon.service;

import java.util.List;

import com.infy.verizon.entity.FlightEntity;
import com.infy.verizon.model.Flight;

public interface FlightService {
	
	public Integer addFlight(Flight flight) throws Exception;
	public Integer removeFlight(Integer flightId) throws Exception;
	public List<Flight> getFlights() throws Exception;
	
	
}
