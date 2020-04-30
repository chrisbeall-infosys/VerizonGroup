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
	@JoinColumn(name="from_airport", insertable = false, updatable = false, unique = true)
	private AirportEntity fromAirportEntity;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="to_airport", insertable = false, updatable = false, unique = true)
	private AirportEntity toAirportEntity;

	
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

	public AirportEntity getFromAirportEntity() {
		return fromAirportEntity;
	}
	public void setFromAirportEntity(AirportEntity fromAirportEntity) {
		this.fromAirportEntity = fromAirportEntity;
	}
	public AirportEntity getToAirportEntity() {
		return toAirportEntity;
	}
	public void setToAirportEntity(AirportEntity toAirportEntity) {
		this.toAirportEntity = toAirportEntity;
	}

}
