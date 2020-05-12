package com.infy.verizon.service;

import java.util.List;

import com.infy.verizon.model.Airport;

public interface AirportService {
	
	public String addAirport(Airport airport) throws Exception;
	public void removeAirport(String airportId) throws Exception;
	public List<Airport> getAirports() throws Exception;
	
}
