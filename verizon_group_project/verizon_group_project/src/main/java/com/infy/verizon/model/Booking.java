package com.infy.verizon.model;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.infy.verizon.validator.AddNewBookingValidationGroup;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description="Details about a booking")
public class Booking {

	@ApiModelProperty(notes="Database generated ID")
	@NotNull
	private Integer bookingId;

	@ApiModelProperty(notes="The traveler that is making the booking.")
	@NotNull(message="The traveler was left null.", groups={AddNewBookingValidationGroup.class})
	private Traveler traveler;
	
	@ApiModelProperty(notes="Date of the flight")
	@NotNull(message="The date of travel was left null.", groups={AddNewBookingValidationGroup.class})
	private LocalDate dateOfTravel;
	
	@ApiModelProperty(notes="Number of people included in the booking.")
	@NotNull(message="Number of travelers was left null." ,groups={AddNewBookingValidationGroup.class}) @Min(value=1, groups={AddNewBookingValidationGroup.class})
	private Integer numberOfTravelers;
	
	@ApiModelProperty(notes="The flight that the traveler picked.")
	@NotNull(message="Flight was left null.", groups={AddNewBookingValidationGroup.class})
	private Flight flight;
	
	@ApiModelProperty(notes="The totcal cost of the booking")
	@NotNull(message="Cost was left null." , groups={AddNewBookingValidationGroup.class}) @Min(value=1, groups={AddNewBookingValidationGroup.class})

	private Double cost; 

}
