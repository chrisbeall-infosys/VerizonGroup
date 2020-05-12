package com.infy.verizon.entity;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Flights")
public class FlightEntity {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter @Setter
	private Integer FlightId;
	
	@Getter @Setter
	private Double fare;
	
	@Getter @Setter
	private Double taxes;
	
	@ManyToOne
	@JoinColumn(name="from_airport")
	@Getter @Setter
	private AirportEntity fromAirportEntity;
	
	@ManyToOne
	@JoinColumn(name="to_airport")
	@Getter @Setter
	private AirportEntity toAirportEntity;


}
