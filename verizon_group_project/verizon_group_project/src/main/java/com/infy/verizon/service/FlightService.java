package com.infy.verizon.service;

import java.util.List;

import com.infy.verizon.model.Flight;

public interface FlightService {
	
	public void addFlight(Flight flight) throws Exception;
	public void removeFlight(Integer flightId) throws Exception;
	public List<Flight> getFlights() throws Exception;
	
	
}
