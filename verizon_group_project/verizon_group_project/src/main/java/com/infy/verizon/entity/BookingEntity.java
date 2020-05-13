package com.infy.verizon.entity;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Booking")
public class BookingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
<<<<<<< HEAD
	
=======
	@Getter @Setter
>>>>>>> bbd3cd511fc00561e7299fd1da2a54821ae2d9a0
	private Integer BookingId;
	
	@ManyToOne
	@JoinColumn(name="login_id")
	@Getter @Setter
	private TravelerEntity travelerEntity;
	
<<<<<<< HEAD
	
	private LocalDate dateOfTravel;
	
	
	private Integer numberOfTravelers;
	
	
=======
	@Getter @Setter
	private LocalDate dateOfTravel;
	
	@Getter @Setter
	private Integer numberOfTravelers;
	
	@Getter @Setter
>>>>>>> bbd3cd511fc00561e7299fd1da2a54821ae2d9a0
	private Double cost;
	
	@ManyToOne
	@JoinColumn(name="flight_id")
	@Getter @Setter
	private FlightEntity flightEntity;
<<<<<<< HEAD

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

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public FlightEntity getFlightEntity() {
		return flightEntity;
	}

	public void setFlightEntity(FlightEntity flightEntity) {
		this.flightEntity = flightEntity;
	}
	
	
	
	

	
	
=======
>>>>>>> bbd3cd511fc00561e7299fd1da2a54821ae2d9a0
	
	
}
