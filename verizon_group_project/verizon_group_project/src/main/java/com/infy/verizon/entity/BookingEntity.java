package com.infy.verizon.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BookingEntity {
	@Id
	Integer BookingId;
	
	@ManyToOne
	@JoinColumn(name="login_id")
	TravelerEntity travelerEntity;
	
	LocalDate dateOfTravel;
	
	Integer numberOfTravelers;
	
	@ManyToOne
	@JoinColumn(name="flight_id")
	FlightEntity flightEntity;

	public Integer getBookingId() {
		return BookingId;
	}

	public void setBookingId(Integer bookingId) {
		BookingId = bookingId;
	}

	public TravelerEntity getTravelerEntity() {
		return travelerEntity;
	}

	public void setTravelerEntity(TravelerEntity travelerEntity) {
		this.travelerEntity = travelerEntity;
	}

	public LocalDate getDateOfTravel() {
		return dateOfTravel;
	}

	public void setDateOfTravel(LocalDate dateOfTravel) {
		this.dateOfTravel = dateOfTravel;
	}

	public Integer getNumberOfTravelers() {
		return numberOfTravelers;
	}

	public void setNumberOfTravelers(Integer numberOfTravelers) {
		this.numberOfTravelers = numberOfTravelers;
	}

	public FlightEntity getFlightEntity() {
		return flightEntity;
	}

	public void setFlightEntity(FlightEntity flightEntity) {
		this.flightEntity = flightEntity;
	}
	
	
	
	
}
