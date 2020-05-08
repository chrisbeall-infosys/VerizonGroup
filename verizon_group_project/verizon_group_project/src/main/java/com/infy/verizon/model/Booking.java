package com.infy.verizon.model;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class Booking {

	

	private Integer bookingId;

	@NotNull
	private Traveler traveler;
	
	@NotNull
	private LocalDate dateOfTravel;
	@NotNull @Min(1)
	private Integer numberOfTravelers;
	@NotNull
	private Flight flight;
	@NotNull @Min(1)
	private Double cost; 

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

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
