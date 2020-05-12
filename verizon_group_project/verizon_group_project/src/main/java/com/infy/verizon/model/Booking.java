package com.infy.verizon.model;

import java.time.LocalDate;



public class Booking {
	//@Getter @Setter
	private Integer bookingId;

	//@Getter @Setter
	private Traveler traveler;
	
	//@Getter @Setter
	private LocalDate dateOfTravel;
	
	//@Getter @Setter
	private Integer numberOfTravelers;
	
	//@Getter @Setter
	private Flight flight;
	
	//@Getter @Setter
	private Double cost;

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

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	} 

	
	
}
