package com.infy.verizon.api;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.infy.verizon.entity.BookingEntity;
import com.infy.verizon.exception.BookingAPIException;

import com.infy.verizon.model.Booking;
import com.infy.verizon.service.BookingService;
import com.infy.verizon.validator.AddNewBookingValidationGroup;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@Api(tags = {"Booking API"})
@SwaggerDefinition(tags = {
    @Tag(name = "Booking API", description = "Booking API, used to create new bookings.")
})
@CrossOrigin
@RestController
public class BookingAPI {
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private Environment environment;
		
	
	@PostMapping(value="booking")
	@ApiOperation(value="Add a new booking", response= Iterable.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 400, message="Bad request, most likely a field was left null."),
	        @ApiResponse(code=201, message="Successful new booking")
	})

	public ResponseEntity<String> addNewBooking(
			@ApiParam(value = "Booking object used to create a new booking for a specific traveler", required = true)
			@RequestBody @Validated(AddNewBookingValidationGroup.class) Booking booking){
					
			Optional<BookingEntity> newBooking = bookingService.addNewBooking(booking);
			if (!newBooking.isPresent()){
				throw new BookingAPIException("BookingAPI.BOOKING_IS_NULL");
			}
			
			String bookingMessage = environment.getProperty("BookingAPI.NEW_BOOKING_SUCCESS")+ newBooking.get().getBookingId();
			
			return new ResponseEntity<>(bookingMessage, HttpStatus.CREATED);
			
		
	
	}
	

}

