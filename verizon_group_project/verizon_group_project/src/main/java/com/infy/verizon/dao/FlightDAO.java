package com.infy.verizon.dao;

import java.util.List;

import com.infy.verizon.entity.FlightEntity;
import com.infy.verizon.model.Flight;

public interface FlightDAO {
	
	public FlightEntity addFlight(Flight flight);
	public FlightEntity removeFlight(Integer flightId);
	public List<Flight> getFlights();
	
}
