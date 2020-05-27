package com.infy.verizon.model;

import javax.validation.constraints.Min;

import com.infy.verizon.validator.FlightValidationGroup;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class Flight {
	
	private Integer FlightId;
	
	@Min(1)
	@NotNull(message="Flight fare was null", groups={FlightValidationGroup.class})
	private Double fare;
	
	@Min(1)
	@NotNull(message="Flight taxes were null", groups={FlightValidationGroup.class})
	private Double taxes;
	
	@NotNull(message="Flight from airport was null", groups={FlightValidationGroup.class})
	private Airport fromAirport;
	
	@NotNull(message="Flight to airport was null", groups={FlightValidationGroup.class})
	private Airport toAirport;
	
}
