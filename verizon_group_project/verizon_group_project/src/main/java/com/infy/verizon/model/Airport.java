package com.infy.verizon.model;

<<<<<<< HEAD

public class Airport {
	//@Getter @Setter
=======
import javax.validation.constraints.NotNull;

public class Airport {
	
	@NotNull
>>>>>>> 4fed3ec43409b516710ac75a736770e5d62aa60b
	private String airportId;

	public String getAirportId() {
		return airportId;
	}

	public void setAirportId(String airportId) {
		this.airportId = airportId;
	}

	
	
}
