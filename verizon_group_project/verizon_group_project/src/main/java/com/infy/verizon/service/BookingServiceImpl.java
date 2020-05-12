package com.infy.verizon.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.verizon.dao.BookingDAO;
import com.infy.verizon.model.Booking;
import com.infy.verizon.validator.BookingValidator;

@Service(value="bookingService")
@Transactional
public class BookingServiceImpl implements BookingService{
	@Autowired
	private BookingDAO bookingDAO;
	
	@Override
	public Integer addNewBooking(Booking booking) throws Exception{
		BookingValidator.validateBooking(booking);
		
		Integer value = bookingDAO.addNewBooking(booking);
		
		if (value.equals(-1)){
			throw new Exception("A field was left null");
		}
		return value;
	}
}
