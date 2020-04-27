package com.infy.verizon.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Flights")
public class FlightEntity {
	
	@Id
	private Integer FlightId;
	private Double fare;
	private Double taxes;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "airport_id", insertable=false, updatable=false)
	private AirportEntity fromAirport;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "airport_id", insertable=false, updatable=false)
	private AirportEntity toAirport;
	
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
	public AirportEntity getFromAirport() {
		return fromAirport;
	}
	public void setFromAirport(AirportEntity fromAirport) {
		this.fromAirport = fromAirport;
	}
	public AirportEntity getToAirport() {
		return toAirport;
	}
	public void setToAirport(AirportEntity toAirport) {
		this.toAirport = toAirport;
	}

}
