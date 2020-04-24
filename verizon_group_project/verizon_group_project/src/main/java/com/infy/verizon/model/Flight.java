package com.infy.verizon.model;

public class Flight {
	
	private Integer FlightId;
	private Double fare;
	private Double taxes;
	private Airport fromAirport;
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
	
}
