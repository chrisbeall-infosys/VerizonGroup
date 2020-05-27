package com.infy.verizon.service;

import java.util.List;
import java.util.Optional;

import com.infy.verizon.model.Airport;

public interface AirportService {
	
	public Optional<String> addAirport(Airport airport);
	public Optional<String> removeAirport(String airportId);
	public Optional<List<Airport>> getAirports();
	
}
