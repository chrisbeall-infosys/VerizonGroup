package com.infy.verizon.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.infy.verizon.model.Airport;

@Entity
@Table(name = "Flights")
public class FlightEntity {
	
	@Id
	private Integer FlightId;
	private Double fare;
	private Double taxes;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "airport_id", unique = true)
	private Airport fromAirport;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "airport_id", unique = true)
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
