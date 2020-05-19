package com.infy.verizon.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.verizon.dao.BookingDAO;

import com.infy.verizon.entity.BookingEntity;
import com.infy.verizon.exception.BookingServiceException;
import com.infy.verizon.model.Booking;

@Service(value="bookingService")
@Transactional
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	private BookingDAO bookingDAO;
	 
	@Override
	public Optional<BookingEntity> addNewBooking(Booking booking){
		
		Optional<BookingEntity> newBooking = bookingDAO.addNewBooking(booking);
		
		if (!newBooking.isPresent()){ 
			throw new BookingServiceException("BookingService.NULL_FIELD");
		}
		return newBooking;
	}
}
