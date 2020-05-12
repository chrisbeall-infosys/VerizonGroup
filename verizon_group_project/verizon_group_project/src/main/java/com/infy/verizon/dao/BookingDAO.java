package com.infy.verizon.dao;

import com.infy.verizon.entity.BookingEntity;
import com.infy.verizon.model.Booking;

public interface BookingDAO {
	public BookingEntity addNewBooking(Booking booking);
}
