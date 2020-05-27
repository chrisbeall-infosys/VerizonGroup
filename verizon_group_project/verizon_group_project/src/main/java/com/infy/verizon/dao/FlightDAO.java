package com.infy.verizon.dao;

import java.util.List;
import java.util.Optional;

import com.infy.verizon.entity.FlightEntity;
import com.infy.verizon.model.Flight;

public interface FlightDAO {
	
	public Optional<FlightEntity> addFlight(Flight flight);
	public Optional<Integer> removeFlight(Integer flightId);
	public Optional<List<Flight>> getFlights();
	
}
