package com.infy.verizon.model;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

public class Flight {
	
	@Getter @Setter
	private Integer FlightId;
	
	@Getter @Setter
	@NotNull
	private Double fare;
	
	@Getter @Setter
	@NotNull
	private Double taxes;
	
	@Getter @Setter
	@NotNull
	private Airport fromAirport;
	
	@Getter @Setter
	@NotNull
	private Airport toAirport;
	
}
