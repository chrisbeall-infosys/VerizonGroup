package com.infy.verizon.validator;

import com.infy.verizon.model.Booking;

public class BookingValidator {

	public static void validateBooking(Booking booking) throws Exception{
		if (!BookingValidator.checkIfRequiredFieldsAreNull(booking)){
			throw new Exception("BookingValidator.FIELD_IS_NULL");
		}
	}
	
	public static boolean checkIfRequiredFieldsAreNull(Booking booking){
		if(booking.getDateOfTravel() == null){
			return false;
		}
		if (booking.getFlight() == null){
			return false;
		}
		if (booking.getNumberOfTravelers() == null){
			return false;
		}
		if (booking.getTraveler() == null){
			return false;
		}
		return true;
	}
}
