package com.infy.verizon.model;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.infy.verizon.validator.AddNewBookingValidationGroup;

import lombok.Getter;
import lombok.Setter;


public class Booking {

	
	@Getter @Setter
	private Integer bookingId;

	@Getter @Setter
	@NotNull(message="The traveler was left null.", groups={AddNewBookingValidationGroup.class})
	private Traveler traveler;
	
	@Getter @Setter
	@NotNull(message="The date of travel was left null.", groups={AddNewBookingValidationGroup.class})
	private LocalDate dateOfTravel;
	
	@Getter @Setter
	@NotNull(message="Number of travelers was left null." ,groups={AddNewBookingValidationGroup.class}) @Min(value=1, groups={AddNewBookingValidationGroup.class})
	private Integer numberOfTravelers;
	
	@Getter @Setter
	@NotNull(message="Flight was left null.", groups={AddNewBookingValidationGroup.class})
	private Flight flight;
	
	@Getter @Setter
	@NotNull(message="Cost was left null." , groups={AddNewBookingValidationGroup.class}) @Min(value=1, groups={AddNewBookingValidationGroup.class})
	private Double cost; 

}
