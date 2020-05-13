package com.infy.verizon.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infy.verizon.entity.AirportEntity;
import com.infy.verizon.model.Airport;

@Repository(value = "airportDAO")
public class AirportDAOImpl implements AirportDAO{
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public AirportEntity addAirport(Airport airport){
		// NULL check
		if(airport == null || airport.getAirportId() == null){
			return null;
		}
		AirportEntity airportEntity = new AirportEntity();
		
		airportEntity.setAirportId(airport.getAirportId());	// can be auto generated
		
		entityManager.persist(airportEntity);
		return airportEntity;
	}
	
	@Override
	public AirportEntity removeAirport(String airportId){
		// For tester:
		if(airportId == null){
			return null;
		}
		
		AirportEntity airportEntity = entityManager.find(AirportEntity.class, airportId);
		entityManager.remove(airportEntity);
		
		// For tester:
		if(entityManager.find(AirportEntity.class, airportId) == null){
			return airportEntity;
		}
		else{
			return null;
		}
	}
	
	@Override
	public List<Airport> getAirports(){
		
		Query query = entityManager.createQuery("select a from AirportEntity a");
		
		List<AirportEntity> airportEntityList = query.getResultList();
		List<Airport> airportList = new ArrayList<Airport>();
		
		airportEntityList.stream().forEach(airportEntity -> {
			Airport airport = new Airport();
			airport.setAirportId(airportEntity.getAirportId());
			airportList.add(airport);
		});
//		Airport airport = null;
//		for(AirportEntity airportEntity : airportEntityList){
//			airport = new Airport();
//			airport.setAirportId(airportEntity.getAirportId());
//			airportList.add(airport);
//		}
		return airportList;
	}
	
}
