package com.infy.verizon.model;


import javax.validation.constraints.NotNull;


import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class Airport {
	
	@NotNull 
	private String airportId;
	
}
