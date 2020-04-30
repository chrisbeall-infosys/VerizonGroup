package com.infy.verizon.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.verizon.dao.BookingDAOImpl;
import com.infy.verizon.model.Booking;
import com.infy.verizon.validator.BookingValidator;

@Service(value="bookingServiceImpl")
@Transactional
public class BookingServiceImpl implements BookingService{
	@Autowired
	private BookingDAOImpl bookingDAO;
	
	@Override
	public Integer addNewBooking(Booking booking) throws Exception{
		BookingValidator.validateBooking(booking);
		return bookingDAO.addNewBooking(booking);
	}
}
