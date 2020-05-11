package com.infy.verizon.dao;

import java.util.List;

import com.infy.verizon.model.Airport;

public interface AirportDAO {
	
	public void addAirport(Airport airport);
	public void removeAirport(String airportId);
	public List<Airport> getAirports();
	
}
