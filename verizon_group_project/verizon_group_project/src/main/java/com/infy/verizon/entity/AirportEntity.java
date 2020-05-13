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

}
