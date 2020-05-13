package com.infy.verizon.dao;

import java.util.List;

import com.infy.verizon.entity.AirportEntity;
import com.infy.verizon.model.Airport;

public interface AirportDAO {
	
	public AirportEntity addAirport(Airport airport);
	public AirportEntity removeAirport(String airportId);
	public List<Airport> getAirports();
	
}
