package com.infy.verizon.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Flights")
public class FlightEntity {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer FlightId;
	
	
	private Double fare;
	
	
	private Double taxes;
	
	@ManyToOne
	@JoinColumn(name="from_airport")
	private AirportEntity fromAirportEntity;
<<<<<<< HEAD
	
	@ManyToOne(cascade = CascadeType.ALL)
=======
	@ManyToOne
>>>>>>> 4fed3ec43409b516710ac75a736770e5d62aa60b
	@JoinColumn(name="to_airport")
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
