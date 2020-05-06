package com.infy.verizon.validator;

import org.springframework.validation.Validator;

import com.infy.verizon.model.Booking;

public class BookingValidator{
	
	
	public boolean supports(Class clazz) {
        return Booking.class.equals(clazz);
    }
	
	public static void validateBooking(Booking booking) throws Exception{
		if (booking == null){
			throw new Exception("Booking is null");
		}
		else if (!BookingValidator.checkIfTravelerIsNull(booking)) {
			throw new BookingValidatorException("BookingValidator.TRAVELER_IS_NULL");
		}
		else if (!BookingValidator.checkIfCostIsNull(booking)) {
			throw new BookingValidatorException("BookingValidator.COST_IS_NULL");
		}
		else if (!BookingValidator.checkIfFlightIsNull(booking)) {
			throw new BookingValidatorException("BookingValidator.FLIGHT_IS_NULL");
		}
		else if (!BookingValidator.checkIfDateOfTravelIsNull(booking)) {
			throw new BookingValidatorException("BookingValidator.DATE_IS_NULL");
		}
		else if (!BookingValidator.checkIfNumberOfTravelersIsNull(booking)){
			throw new BookingValidatorException("BookingValidator.NUMBER_OF_TRAVELERS_IS_NULL");
		}
		
	}

	public static boolean checkIfTravelerIsNull(Booking booking) {
		if (booking.getTraveler() == null) {
			return false;
		}
		return true;
	}

	public static boolean checkIfFlightIsNull(Booking booking) {
		if (booking.getFlight() == null) {
			return false;
		}
		return true;
	}

	public static boolean checkIfCostIsNull(Booking booking) {
		if (booking.getCost() == null) {
			return false;
		}
		return true;
	}

	public static boolean checkIfDateOfTravelIsNull(Booking booking) {
		if (booking.getDateOfTravel() == null) {
			return false;
		}
		return true;
	}
	public static boolean checkIfNumberOfTravelersIsNull(Booking booking){
		if (booking.getNumberOfTravelers() == null){
			return false;
		}
		return true;
	}
	
}

class BookingValidatorException extends Exception {
	BookingValidatorException(String str) {
		super(str);
	}
}
