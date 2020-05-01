package com.infy.verizon.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.infy.verizon.model.Booking;
import com.infy.verizon.service.BookingService;

@CrossOrigin
@RestController
@RequestMapping("BookingAPI")
public class BookingAPI {
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private Environment environment;
	
	static Logger logger = LogManager.getLogger(BookingAPI.class.getName());
	
	@PostMapping(value="addNewBooking")
	public ResponseEntity<String> addNewBooking(@RequestBody Booking booking){
		try
		{
			logger.info("Registering new booking");
			
			Integer newBookingId = bookingService.addNewBooking(booking);
			
			logger.info("Booking Successful, ID: " + newBookingId);
			
			String bookingMessage = environment.getProperty("BookingAPI.NEW_BOOKING_SUCCESS")+ newBookingId;
			
			return new ResponseEntity<String>(bookingMessage, HttpStatus.OK);
			
		}
		catch (Exception e){
			if(e.getMessage().contains("Validator")){
				throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, environment.getProperty(e.getMessage()));
			}
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()));
		}
	}

}

