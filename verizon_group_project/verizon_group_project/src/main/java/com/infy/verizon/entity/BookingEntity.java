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
	@Getter @Setter
	private Integer BookingId;
	
	@ManyToOne
	@JoinColumn(name="login_id")
	@Getter @Setter
	private TravelerEntity travelerEntity;
	
	@Getter @Setter
	private LocalDate dateOfTravel;
	
	@Getter @Setter
	private Integer numberOfTravelers;
	
	@Getter @Setter
	private Double cost;
	
	@ManyToOne
	@JoinColumn(name="flight_id")
	@Getter @Setter
	private FlightEntity flightEntity;
	
	
}
