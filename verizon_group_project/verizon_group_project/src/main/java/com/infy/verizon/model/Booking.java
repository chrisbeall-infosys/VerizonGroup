package com.infy.verizon.model;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;


<<<<<<< HEAD

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
=======
public class Booking {

	
	@Getter @Setter
	private Integer bookingId;

	@Getter @Setter
	@NotNull(message="The traveler was left null.")
	private Traveler traveler;
	
	@Getter @Setter
	@NotNull(message="The date of travel was left null.")
	private LocalDate dateOfTravel;
	
	@Getter @Setter
	@NotNull(message="Number of travelers was left null.") @Min(1)
	private Integer numberOfTravelers;
	
	@Getter @Setter
	@NotNull(message="Flight was left null.")
	private Flight flight;
	
	@Getter @Setter
	@NotNull(message="Cost was left null.") @Min(1)
	private Double cost; 

<<<<<<< HEAD
	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}
>>>>>>> 4fed3ec43409b516710ac75a736770e5d62aa60b

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

	
	
=======
>>>>>>> bbd3cd511fc00561e7299fd1da2a54821ae2d9a0
}
