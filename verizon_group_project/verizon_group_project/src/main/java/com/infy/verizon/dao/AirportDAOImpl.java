package com.infy.verizon.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infy.verizon.entity.AirportEntity;
import com.infy.verizon.exception.AirportDAOException;
import com.infy.verizon.model.Airport;

@Repository(value = "airportDAO")
public class AirportDAOImpl implements AirportDAO{
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Optional<AirportEntity> addAirport(Airport airport){
		Optional<Airport> optionalAirport = Optional.ofNullable(airport);
		// NULL check
		if(!optionalAirport.isPresent() || airport.getAirportId() == null){
			return Optional.empty();
		}
		AirportEntity airportEntity = new AirportEntity();
		
		airportEntity.setAirportId(airport.getAirportId());	// can be auto generated
		
		entityManager.persist(airportEntity);
		return Optional.ofNullable(airportEntity);
	}
	
	@Override
	public Optional<String> removeAirport(String airportId){
		// For tester:
		if(airportId == null){
			throw new AirportDAOException("AirportDAO.AIRPORT_ID_DOES_NOT_EXIST");
		}
		
		AirportEntity airportEntity = entityManager.find(AirportEntity.class, airportId);
		entityManager.remove(airportEntity);
		
		// For tester:
		if(entityManager.find(AirportEntity.class, airportId) == null){
			return Optional.ofNullable(airportEntity.getAirportId());
		}
		else{
			throw new AirportDAOException("AirportDAO.FAILED_TO_REMOVE_AIRPORT");
		}
	}
	
	@Override
	public Optional<List<Airport>> getAirports(){
		
		Query query = entityManager.createQuery("select a from AirportEntity a");
		
		List<AirportEntity> airportEntityList = query.getResultList();
		List<Airport> airportList = new ArrayList<Airport>();
		
		airportEntityList.stream().forEach(airportEntity -> {
			Airport airport = new Airport();
			airport.setAirportId(airportEntity.getAirportId());
			airportList.add(airport);
		});
//		
		return Optional.ofNullable(airportList);
	}
	
}
