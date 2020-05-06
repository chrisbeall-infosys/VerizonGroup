package com.infy.verizon.dao;

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
	public BookingEntity addNewBooking(Booking booking){
		BookingEntity bookingEntity = new BookingEntity();
		
		if (booking.getCost() == null){
			return null;
		}
		if (booking.getDateOfTravel() == null){
			return null;
		}
		if (booking.getFlight() == null){
			return null;
		}
		if (booking.getNumberOfTravelers() == null){
			return null;
		}
		if (booking.getTraveler() == null){
			return null;
		}
		
		bookingEntity.setDateOfTravel(booking.getDateOfTravel());
		bookingEntity.setNumberOfTravelers(booking.getNumberOfTravelers());
		bookingEntity.setCost(booking.getCost());
		if (booking.getTraveler() == null || booking.getFlight() == null){
			return null;
		}
		TravelerEntity travelerEntity = entityManager.find(TravelerEntity.class, booking.getTraveler().getLoginId());
		FlightEntity flightEntity = entityManager.find(FlightEntity.class, booking.getFlight().getFlightId());
		
		bookingEntity.setFlightEntity(flightEntity);
		bookingEntity.setTravelerEntity(travelerEntity);
		
		
		entityManager.persist(bookingEntity);
		
		return bookingEntity;
	}
	
}
