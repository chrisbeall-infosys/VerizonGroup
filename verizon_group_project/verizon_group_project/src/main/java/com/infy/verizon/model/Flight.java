package com.infy.verizon.model;

import javax.validation.constraints.Min;

import com.infy.verizon.validator.FlightValidationGroup;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

public class Flight {
	
	@Getter @Setter
	private Integer FlightId;
	
	@Getter @Setter
	@Min(1)
	@NotNull(message="Flight fare was null", groups={FlightValidationGroup.class})
	private Double fare;
	
	@Getter @Setter
	@Min(1)
	@NotNull(message="Flight taxes were null", groups={FlightValidationGroup.class})
	private Double taxes;
	
	@Getter @Setter
	@NotNull(message="Flight from airport was null", groups={FlightValidationGroup.class})
	private Airport fromAirport;
	
	@Getter @Setter
	@NotNull(message="Flight to airport was null", groups={FlightValidationGroup.class})
	private Airport toAirport;
	
}
