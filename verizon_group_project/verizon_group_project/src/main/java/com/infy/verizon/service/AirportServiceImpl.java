package com.infy.verizon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.verizon.dao.AirportDAO;
import com.infy.verizon.entity.AirportEntity;
import com.infy.verizon.exception.AirportServiceException;
import com.infy.verizon.model.Airport;

@Transactional
@Service(value = "airportService")
public class AirportServiceImpl implements AirportService {
	
	@Autowired
	private AirportDAO airportDAO;
	
	@Override
	public Optional<String> addAirport(Airport airport) {
		Optional<List<Airport>> existingAirports = airportDAO.getAirports();
		
		for(Airport existingAirport : existingAirports.get()){
			if(airport.getAirportId().equals(existingAirport.getAirportId())){
				throw new AirportServiceException("AirprotService.AIRPORT_ID_ALREADY_EXISTS");
			}
		}
		Optional<AirportEntity> fromDAO = airportDAO.addAirport(airport);
		if(!fromDAO.isPresent()){
			throw new AirportServiceException("AirportService.NULL_FIELD");
		}
		return Optional.ofNullable(fromDAO.get().getAirportId());
	}
	
	@Override
	public Optional<String> removeAirport(String airportId) {
		Optional<List<Airport>> airportList = airportDAO.getAirports();
		boolean found = false;
		for(Airport airport : airportList.get()){
			if(airport.getAirportId().equals(airportId)){
				found = true;
				break;
			}
		}
		if(!found){
			throw new AirportServiceException("AirportService.AIRPORT_ID_DOES_NOT_EXIST");
		}
		return airportDAO.removeAirport(airportId);
	}
	
	@Override
	public Optional<List<Airport>> getAirports() {
		
		Optional<List<Airport>> airportList = airportDAO.getAirports();
		if(!airportList.isPresent() || airportList.get().isEmpty()){
			throw new AirportServiceException("AirportService.NO_AIRPORTS_IN_TABLE");
		}
		return airportList;
	}
	
}
