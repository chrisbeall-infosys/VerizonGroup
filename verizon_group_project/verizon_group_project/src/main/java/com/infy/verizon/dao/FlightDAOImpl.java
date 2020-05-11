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
	public FlightEntity addFlight(Flight flight) {
		
		// NULL Checks:
		if(flight == null || flight.getFlightId() == null || flight.getFare() == null
				|| flight.getTaxes() == null || flight.getFromAirport() == null
				|| flight.getToAirport() == null){
			return null;
		}
		
		
		FlightEntity flightEntity = new FlightEntity();

		flightEntity.setFlightId(flight.getFlightId()); // can be auto generated
		flightEntity.setFare(flight.getFare());
		flightEntity.setTaxes(flight.getTaxes());
		
		AirportEntity fromAirportEntity = entityManager.find(AirportEntity.class,
				flight.getFromAirport().getAirportId());
		
		if(fromAirportEntity == null){
			//System.out.println("From Airport did not exist.");
			fromAirportEntity = new AirportEntity();
			fromAirportEntity.setAirportId(flight.getFromAirport().getAirportId());
			entityManager.persist(fromAirportEntity);
		}
		else{
			//System.out.println("From Airport Already exists");
		}
		flightEntity.setFromAirportEntity(fromAirportEntity);

		AirportEntity toAirportEntity = entityManager.find(AirportEntity.class,
				flight.getToAirport().getAirportId());
		if(toAirportEntity == null){
			System.out.println("To Airport did not exist.");
			toAirportEntity = new AirportEntity();
			toAirportEntity.setAirportId(flight.getToAirport().getAirportId());
			entityManager.persist(toAirportEntity);
		}
		else{
			System.out.println("To Airport Already exists");
		}
		flightEntity.setToAirportEntity(toAirportEntity);

		entityManager.persist(flightEntity);
		return flightEntity;
	}

	@Override
	public FlightEntity removeFlight(Integer flightId) {

		FlightEntity flightEntity = entityManager.find(FlightEntity.class, flightId);

		entityManager.remove(flightEntity);
		return flightEntity;
	}

	@Override
	public List<Flight> getFlights() {

		Query query = entityManager.createQuery("select f from FlightEntity f");

		List<FlightEntity> flightEntityList = query.getResultList();
		List<Flight> flightList = new ArrayList<Flight>();

		//Flight flight = null; // in case flight table is empty
		flightEntityList.stream().forEach(flightEntity -> {
			Flight flight = new Flight();

			flight.setFlightId(flightEntity.getFlightId());
			flight.setFare(flightEntity.getFare());
			flight.setTaxes(flightEntity.getTaxes());

			Airport fromAirport = new Airport(); // could do error checking here
			fromAirport.setAirportId(flightEntity.getFromAirportEntity().getAirportId());
			flight.setFromAirport(fromAirport);

			Airport toAirport = new Airport();
			toAirport.setAirportId(flightEntity.getToAirportEntity().getAirportId());
			flight.setToAirport(toAirport);

			flightList.add(flight);
		});
//		for (FlightEntity flightEntity : flightEntityList) {
//			flight = new Flight();
//
//			flight.setFlightId(flightEntity.getFlightId());
//			flight.setFare(flightEntity.getFare());
//			flight.setTaxes(flightEntity.getTaxes());
//
//			Airport fromAirport = new Airport(); // could do error checking here
//			fromAirport.setAirportId(flightEntity.getFromAirportEntity().getAirportId());
//			flight.setFromAirport(fromAirport);
//
//			Airport toAirport = new Airport();
//			toAirport.setAirportId(flightEntity.getToAirportEntity().getAirportId());
//			flight.setToAirport(toAirport);
//
//			flightList.add(flight);
//		}
		return flightList;
	}

}
