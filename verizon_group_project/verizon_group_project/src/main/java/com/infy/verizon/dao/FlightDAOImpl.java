package com.infy.verizon.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infy.verizon.entity.AirportEntity;
import com.infy.verizon.entity.FlightEntity;
import com.infy.verizon.model.Airport;
import com.infy.verizon.model.Flight;

@Repository(value = "flightDAO")
public class FlightDAOImpl implements FlightDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void addFlight(Flight flight){
		
		FlightEntity flightEntity = new FlightEntity();
		
		flightEntity.setFlightId(flight.getFlightId());	// can be auto generated
		flightEntity.setFare(flight.getFare());
		flightEntity.setTaxes(flight.getTaxes());
		
		AirportEntity fromAirportEntity = new AirportEntity();
		fromAirportEntity.setAirportId(flight.getFromAirport().getAirportId());	// this can be auto generated
		flightEntity.setFromAirportEntity(fromAirportEntity);
		
		AirportEntity toAirportEntity = new AirportEntity();
		toAirportEntity.setAirportId(flight.getToAirport().getAirportId());	// can be auto generated
		flightEntity.setToAirportEntity(toAirportEntity);
		
		entityManager.persist(flightEntity);
		
		
	}
	
	@Override
	public void removeFlight(Integer flightId){
		
		FlightEntity flightEntity = entityManager.find(FlightEntity.class, flightId);
		
		entityManager.remove(flightEntity);
	}
	
	@Override
	public List<Flight> getFlights(){
		
		Query query = entityManager.createQuery("select f from FlightEntity f");
		
		List<FlightEntity> flightEntityList = query.getResultList();
		List<Flight> flightList = new ArrayList<Flight>();
		
		Flight flight = null;	// in case flight table is empty
		for(FlightEntity flightEntity : flightEntityList){
			flight = new Flight();
			
			flight.setFlightId(flightEntity.getFlightId());
			flight.setFare(flightEntity.getFare());
			flight.setTaxes(flightEntity.getTaxes());
			
			Airport fromAirport = new Airport();
			fromAirport.setAirportId(flightEntity.getFromAirportEntity().getAirportId());
			flight.setFromAirport(fromAirport);
			
			Airport toAirport = new Airport();
			toAirport.setAirportId(flightEntity.getToAirportEntity().getAirportId());
			flight.setToAirport(toAirport);
		}
		return flightList;
	}
	
}
