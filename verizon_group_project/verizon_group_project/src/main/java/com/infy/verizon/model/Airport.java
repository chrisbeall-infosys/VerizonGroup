package com.infy.verizon.model;

import javax.validation.constraints.NotNull;

public class Airport {
	
	@NotNull
	private String airportId;

	public String getAirportId() {
		return airportId;
	}

	public void setAirportId(String airportId) {
		this.airportId = airportId;
	}
	
	
	
}
