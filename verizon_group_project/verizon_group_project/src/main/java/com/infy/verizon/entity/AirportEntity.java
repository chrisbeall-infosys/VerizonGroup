package com.infy.verizon.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter
@Table(name = "Airport")
public class AirportEntity {
	
	@Id
	private String airportId;
	
}
