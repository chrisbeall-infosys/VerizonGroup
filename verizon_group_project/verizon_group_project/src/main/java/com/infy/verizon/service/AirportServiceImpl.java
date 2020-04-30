package com.infy.verizon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.verizon.dao.AirportDAO;
import com.infy.verizon.model.Airport;

@Transactional
@Service(value = "airportService")
public class AirportServiceImpl implements AirportService {
	
	@Autowired
	private AirportDAO airportDAO;
	
	@Override
	public void addAirport(Airport airport) throws Exception {
		List<Airport> existingAirports = airportDAO.getAirports();
		
		for(Airport existingAirport : existingAirports){
			if(airport.getAirportId().equals(existingAirport.getAirportId())){
				throw new Exception("AirprotService.AIRPORT_ID_ALREADY_EXISTS");
			}
		}
		airportDAO.addAirport(airport);
	}
	
	@Override
	public void removeAirport(Integer airportId) throws Exception {
		airportDAO.removeAirport(airportId);
	}
	
	@Override
	public List<Airport> getAirports() throws Exception {
		
		List<Airport> airportList = airportDAO.getAirports();
		if(airportList == null || airportList.isEmpty()){
			throw new Exception("AirportService.NO_AIRPORTS_IN_TABLE");
		}
		return airportList;
	}
	
}
