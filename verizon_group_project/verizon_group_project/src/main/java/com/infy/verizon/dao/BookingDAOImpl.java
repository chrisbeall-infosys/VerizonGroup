package com.infy.verizon.dao;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infy.verizon.entity.BookingEntity;
import com.infy.verizon.entity.FlightEntity;
import com.infy.verizon.entity.TravelerEntity;
import com.infy.verizon.model.Booking;

@Repository(value="bookingDAO")
public class BookingDAOImpl implements BookingDAO{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public Optional<BookingEntity> addNewBooking(Booking booking){
		BookingEntity bookingEntity = new BookingEntity(); 
		Optional<Booking> optionalBooking = Optional.ofNullable(booking);
		if (!optionalBooking.isPresent()){
			return Optional.empty();
		}
		if (booking.getCost() == null){
			return Optional.empty();
		}
		if (booking.getDateOfTravel() == null){
			return Optional.empty();
		}
		if (booking.getFlight() == null){ 
			return Optional.empty();
		}
		if (booking.getNumberOfTravelers() == null){
			return Optional.empty();
		}
		if (booking.getTraveler() == null){
			return Optional.empty();
		}
		
		bookingEntity.setDateOfTravel(booking.getDateOfTravel());
		bookingEntity.setNumberOfTravelers(booking.getNumberOfTravelers());
		bookingEntity.setCost(booking.getCost());
		TravelerEntity travelerEntity = entityManager.find(TravelerEntity.class, booking.getTraveler().getLoginId());
		FlightEntity flightEntity = entityManager.find(FlightEntity.class, booking.getFlight().getFlightId());
		
		bookingEntity.setFlightEntity(flightEntity);
		bookingEntity.setTravelerEntity(travelerEntity);
		
		
		entityManager.persist(bookingEntity);
		
		return Optional.ofNullable(bookingEntity);
	}
	
}
