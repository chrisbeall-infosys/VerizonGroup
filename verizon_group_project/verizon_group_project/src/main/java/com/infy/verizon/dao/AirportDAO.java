package com.infy.verizon.dao;

import java.util.List;
import java.util.Optional;

import com.infy.verizon.entity.AirportEntity;
import com.infy.verizon.model.Airport;

public interface AirportDAO {
	
	public Optional<AirportEntity> addAirport(Airport airport);
	public Optional<String> removeAirport(String airportId);
	public Optional<List<Airport>> getAirports();
	
}
