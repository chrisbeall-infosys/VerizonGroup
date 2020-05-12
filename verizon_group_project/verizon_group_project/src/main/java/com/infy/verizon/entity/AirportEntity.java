package com.infy.verizon.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Airport")
public class AirportEntity {
	
	@Id
	private String airportId;

	public String getAirportId() {
		return airportId;
	}

	public void setAirportId(String airportId) {
		this.airportId = airportId;
	}

	
	
	
}
