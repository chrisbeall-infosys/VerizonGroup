package com.infy.verizon.entity;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Flights")
public class FlightEntity {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter @Setter
	private Integer FlightId;
	
<<<<<<< HEAD
	
	private Double fare;
	
	
=======
	@Getter @Setter
	private Double fare;
	
	@Getter @Setter
>>>>>>> bbd3cd511fc00561e7299fd1da2a54821ae2d9a0
	private Double taxes;
	
	@ManyToOne
	@JoinColumn(name="from_airport")
	@Getter @Setter
	private AirportEntity fromAirportEntity;
<<<<<<< HEAD
<<<<<<< HEAD
	
	@ManyToOne(cascade = CascadeType.ALL)
=======
=======
	
>>>>>>> bbd3cd511fc00561e7299fd1da2a54821ae2d9a0
	@ManyToOne
>>>>>>> 4fed3ec43409b516710ac75a736770e5d62aa60b
	@JoinColumn(name="to_airport")
	@Getter @Setter
	private AirportEntity toAirportEntity;

<<<<<<< HEAD
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
=======
>>>>>>> bbd3cd511fc00561e7299fd1da2a54821ae2d9a0

	
	
	

}
