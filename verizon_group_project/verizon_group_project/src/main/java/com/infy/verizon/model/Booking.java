package com.infy.verizon.model;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.infy.verizon.validator.AddNewBookingValidationGroup;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class Booking {

	private Integer bookingId;


	@NotNull(message="The traveler was left null.", groups={AddNewBookingValidationGroup.class})
	private Traveler traveler;
	

	@NotNull(message="The date of travel was left null.", groups={AddNewBookingValidationGroup.class})
	private LocalDate dateOfTravel;
	

	@NotNull(message="Number of travelers was left null." ,groups={AddNewBookingValidationGroup.class}) @Min(value=1, groups={AddNewBookingValidationGroup.class})
	private Integer numberOfTravelers;
	

	@NotNull(message="Flight was left null.", groups={AddNewBookingValidationGroup.class})
	private Flight flight;
	

	@NotNull(message="Cost was left null." , groups={AddNewBookingValidationGroup.class}) @Min(value=1, groups={AddNewBookingValidationGroup.class})
	private Double cost; 

}
