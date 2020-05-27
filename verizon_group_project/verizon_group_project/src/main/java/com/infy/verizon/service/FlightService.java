package com.infy.verizon.service;

import java.util.List;
import java.util.Optional;

import com.infy.verizon.model.Flight;

public interface FlightService {
	
	public Optional<Integer> addFlight(Flight flight);
	public Optional<Integer> removeFlight(Integer flightId);
	public Optional<List<Flight>> getFlights();
	
	
}
