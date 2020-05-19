package com.infy.verizon.entity;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter 
@Setter
@Table(name = "Flights")
public class FlightEntity {
	
	@Id
	private Integer FlightId;
	
	private Double fare;
	
	private Double taxes;
	
	@ManyToOne
	@JoinColumn(name="from_airport")
	private AirportEntity fromAirportEntity;
	
	@ManyToOne
	@JoinColumn(name="to_airport")
	private AirportEntity toAirportEntity;


}
