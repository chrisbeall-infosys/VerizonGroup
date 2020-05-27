package com.infy.verizon.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infy.verizon.entity.AirportEntity;
import com.infy.verizon.entity.FlightEntity;
import com.infy.verizon.exception.FlightDAOException;
import com.infy.verizon.model.Airport;
import com.infy.verizon.model.Flight;

@Repository(value = "flightDAO")
public class FlightDAOImpl implements FlightDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public Optional<FlightEntity> addFlight(Flight flight) {
		
		Optional<Flight> optionalFlight = Optional.ofNullable(flight);
		// NULL Checks:
		if(!optionalFlight.isPresent() || flight.getFlightId() == null || flight.getFare() == null
				|| flight.getTaxes() == null || flight.getFromAirport() == null
				|| flight.getToAirport() == null){
			return Optional.empty();
		}
		
		
		FlightEntity flightEntity = new FlightEntity();

		flightEntity.setFlightId(flight.getFlightId()); // can be auto generated
		flightEntity.setFare(flight.getFare());
		flightEntity.setTaxes(flight.getTaxes());
		
		AirportEntity fromAirportEntity = entityManager.find(AirportEntity.class,
				flight.getFromAirport().getAirportId());
		
		if(fromAirportEntity == null){
			fromAirportEntity = new AirportEntity();
			fromAirportEntity.setAirportId(flight.getFromAirport().getAirportId());
			entityManager.persist(fromAirportEntity);
		}
		
		flightEntity.setFromAirportEntity(fromAirportEntity);

		AirportEntity toAirportEntity = entityManager.find(AirportEntity.class,
				flight.getToAirport().getAirportId());
		if(toAirportEntity == null){
			toAirportEntity = new AirportEntity();
			toAirportEntity.setAirportId(flight.getToAirport().getAirportId());
			entityManager.persist(toAirportEntity);
		}
		
		flightEntity.setToAirportEntity(toAirportEntity);

		entityManager.persist(flightEntity);
		return Optional.ofNullable(flightEntity);
	}

	@Override
	public Optional<Integer> removeFlight(Integer flightId) {
		// For tester
		if(flightId == null){
			throw new FlightDAOException("FlightDAO.FLIGHT_ID_DOES_NOT_EXIST");
		}
		
		FlightEntity flightEntity = entityManager.find(FlightEntity.class, flightId);
		
		entityManager.remove(flightEntity);
		
		// For tester:
		if(entityManager.find(FlightEntity.class, flightId) == null){
			//System.out.println("Flight Entity is null, post delete.");
			return Optional.ofNullable(flightEntity.getFlightId());
		}
		else{
			//System.out.println("delete Failed.");
			throw new FlightDAOException("FlightDAO.FAILED_TO_REMOVE_FLIGHT");
		}
	}

	@Override
	public Optional<List<Flight>> getFlights() {

		Query query = entityManager.createQuery("select f from FlightEntity f");

		List<FlightEntity> flightEntityList = query.getResultList();
		List<Flight> flightList = new ArrayList<Flight>();

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
		
		return Optional.ofNullable(flightList);
	}

}
