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
	public void addAirport(Airport airport){
		
		AirportEntity airportEntity = new AirportEntity();
		
		airportEntity.setAirportId(airport.getAirportId());	// can be auto generated
		
		entityManager.persist(airportEntity);
		
	}
	
	@Override
	public void removeAirport(String airportId){
		
		AirportEntity airportEntity = entityManager.find(AirportEntity.class, airportId);
		
		entityManager.remove(airportEntity);
	}
	
	@Override
	public List<Airport> getAirports(){
		
		Query query = entityManager.createQuery("select a from AirportEntity a");
		
		List<AirportEntity> airportEntityList = query.getResultList();
		List<Airport> airportList = new ArrayList<Airport>();
		
		Airport airport = null;
		for(AirportEntity airportEntity : airportEntityList){
			airport = new Airport();
			airport.setAirportId(airportEntity.getAirportId());
			airportList.add(airport);
		}
		return airportList;
	}
	
}
