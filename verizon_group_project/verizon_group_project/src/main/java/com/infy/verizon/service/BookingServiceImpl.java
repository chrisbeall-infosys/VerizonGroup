package com.infy.verizon.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.verizon.dao.BookingDAO;

import com.infy.verizon.entity.BookingEntity;

import com.infy.verizon.model.Booking;

@Service(value="bookingService")
@Transactional
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	private BookingDAO bookingDAO;
	
	@Override
	public Integer addNewBooking(Booking booking) throws Exception{
		System.out.println(bookingDAO);
		
		BookingEntity value = bookingDAO.addNewBooking(booking);
		
		if (value == null){ 
			throw new Exception("BookingService.NULL_FIELD");
		}
		return value.getBookingId();
	}
}
