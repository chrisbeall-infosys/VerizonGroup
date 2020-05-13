package com.infy.verizon.model;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class Airport {
	

	@NotNull @Getter @Setter
	private String airportId;

	
}
