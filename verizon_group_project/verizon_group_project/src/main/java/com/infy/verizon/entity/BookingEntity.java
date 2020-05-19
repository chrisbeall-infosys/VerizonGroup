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
@Getter 
@Setter
@Table(name="Booking")
public class BookingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer BookingId;
	
	@ManyToOne
	@JoinColumn(name="login_id")
	private TravelerEntity travelerEntity;
	
	private LocalDate dateOfTravel;

	private Integer numberOfTravelers;
	
	private Double cost;
	
	@ManyToOne
	@JoinColumn(name="flight_id")
	private FlightEntity flightEntity;
	
	
}
