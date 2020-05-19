package com.infy.verizon.model;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class Booking {

	private Integer bookingId;

	@NotNull(message="The traveler was left null.")
	private Traveler traveler;
	

	@NotNull(message="The date of travel was left null.")
	private LocalDate dateOfTravel;
	
	
	@NotNull(message="Number of travelers was left null.") @Min(1)
	private Integer numberOfTravelers;
	

	@NotNull(message="Flight was left null.")
	private Flight flight;
	

	@NotNull(message="Cost was left null.") @Min(1)
	private Double cost; 

}
