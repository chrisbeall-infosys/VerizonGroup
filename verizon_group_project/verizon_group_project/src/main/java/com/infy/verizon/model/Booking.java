package com.infy.verizon.model;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;


public class Booking {

	
	@Getter @Setter
	private Integer bookingId;

	@Getter @Setter
	@NotNull(message="The traveler was left null.")
	private Traveler traveler;
	
	@Getter @Setter
	@NotNull(message="The date of travel was left null.")
	private LocalDate dateOfTravel;
	
	@Getter @Setter
	@NotNull(message="Number of travelers was left null.") @Min(1)
	private Integer numberOfTravelers;
	
	@Getter @Setter
	@NotNull(message="Flight was left null.")
	private Flight flight;
	
	@Getter @Setter
	@NotNull(message="Cost was left null.") @Min(1)
	private Double cost; 

}
