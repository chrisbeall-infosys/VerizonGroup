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

<<<<<<< HEAD
	@NotNull(message="The traveler was left null.")
	private Traveler traveler;
	

	@NotNull(message="The date of travel was left null.")
	private LocalDate dateOfTravel;
	
	
	@NotNull(message="Number of travelers was left null.") @Min(1)
	private Integer numberOfTravelers;
	

	@NotNull(message="Flight was left null.")
	private Flight flight;
	

	@NotNull(message="Cost was left null.") @Min(1)
=======
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
>>>>>>> e1e0128c900216af56eec1eeee1755b457f91b29
	private Double cost; 

}
