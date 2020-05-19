package com.infy.verizon.model;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class Flight {
	
	private Integer FlightId;

	@NotNull
	private Double fare;
	
	@NotNull
	private Double taxes;

	@NotNull
	private Airport fromAirport;
	
	@NotNull
	private Airport toAirport;
	
}
