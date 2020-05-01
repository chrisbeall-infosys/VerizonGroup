package com.infy.verizon.dao;

import java.util.List;

import com.infy.verizon.model.Flight;

public interface FlightDAO {
	
	public void addFlight(Flight flight);
	public void removeFlight(Integer flightId);
	public List<Flight> getFlights();
	
}
