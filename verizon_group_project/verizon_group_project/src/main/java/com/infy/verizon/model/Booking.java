package com.infy.verizon.model;

import java.time.LocalDate;


public class Booking {

	
	Integer bookingId;
	
	Traveler traveler;
	
	LocalDate dateOfTravel;
	
	Integer numberOfTravelers;
	
	Flight flight;
	
	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Traveler getTraveler() {
		return traveler;
	}

	public void setTraveler(Traveler traveler) {
		this.traveler = traveler;
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

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	
}
