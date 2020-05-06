package com.infy.verizon.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.verizon.dao.BookingDAOImpl;
import com.infy.verizon.entity.BookingEntity;
import com.infy.verizon.model.Booking;
import com.infy.verizon.validator.BookingValidator;

@Service(value="bookingService")
@Transactional
public class BookingServiceImpl implements BookingService{
	@Autowired
	private BookingDAOImpl bookingDAO;
	
	@Override
	public Integer addNewBooking(Booking booking) throws Exception{
		BookingValidator.validateBooking(booking);
		
		BookingEntity value = bookingDAO.addNewBooking(booking);
		
		if (value == null){
			throw new Exception("A field was left null");
		}
		return value.getBookingId();
	}
}
