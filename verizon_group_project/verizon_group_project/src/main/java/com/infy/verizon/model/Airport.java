package com.infy.verizon.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.infy.verizon.validator.AirportValidationGroup;


import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class Airport {
	
	@Size(min = 1, max = 4)
	@NotNull(message="Airport ID was null", groups={AirportValidationGroup.class})
	private String airportId;
	
}
