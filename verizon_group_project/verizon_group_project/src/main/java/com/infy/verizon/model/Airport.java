package com.infy.verizon.model;

<<<<<<< HEAD

public class Airport {
	//@Getter @Setter
=======
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

public class Airport {
	
<<<<<<< HEAD
	@NotNull
>>>>>>> 4fed3ec43409b516710ac75a736770e5d62aa60b
	private String airportId;

	public String getAirportId() {
		return airportId;
	}

	public void setAirportId(String airportId) {
		this.airportId = airportId;
	}

	
=======
	@NotNull @Getter @Setter
	private String airportId;
>>>>>>> bbd3cd511fc00561e7299fd1da2a54821ae2d9a0
	
}
