package com.infy.verizon.model;

<<<<<<< HEAD

public class Flight {
	
	//@Getter @Setter
	private Integer FlightId;
	
	//@Getter @Setter
	private Double fare;
	
	//@Getter @Setter
	private Double taxes;
	
	//@Getter @Setter
	private Airport fromAirport;
=======
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

public class Flight {
	
	@Getter @Setter
	private Integer FlightId;
	
	@Getter @Setter
	@NotNull
	private Double fare;
	
	@Getter @Setter
	@NotNull
	private Double taxes;
	
	@Getter @Setter
	@NotNull
	private Airport fromAirport;
	
	@Getter @Setter
	@NotNull
	private Airport toAirport;
>>>>>>> 4fed3ec43409b516710ac75a736770e5d62aa60b
	
<<<<<<< HEAD
	//@Getter @Setter
	private Airport toAirport;

	public Integer getFlightId() {
		return FlightId;
	}

	public void setFlightId(Integer flightId) {
		FlightId = flightId;
	}

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}

	public Double getTaxes() {
		return taxes;
	}

	public void setTaxes(Double taxes) {
		this.taxes = taxes;
	}

	public Airport getFromAirport() {
		return fromAirport;
	}

	public void setFromAirport(Airport fromAirport) {
		this.fromAirport = fromAirport;
	}

	public Airport getToAirport() {
		return toAirport;
	}

	public void setToAirport(Airport toAirport) {
		this.toAirport = toAirport;
	}
	
	
	
=======
>>>>>>> bbd3cd511fc00561e7299fd1da2a54821ae2d9a0
}
