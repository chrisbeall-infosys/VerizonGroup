package com.infy.verizon.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Airport")
public class AirportEntity {
	
	@Id
	@Getter @Setter
	private String airportId;
<<<<<<< HEAD

	public String getAirportId() {
		return airportId;
	}

	public void setAirportId(String airportId) {
		this.airportId = airportId;
	}

	
	
=======
>>>>>>> bbd3cd511fc00561e7299fd1da2a54821ae2d9a0
	
}
