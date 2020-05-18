package com.infy.verizon.dao;

import java.util.Optional;

import com.infy.verizon.entity.BookingEntity;
import com.infy.verizon.model.Booking;

public interface BookingDAO {
	public Optional<BookingEntity> addNewBooking(Booking booking);
}
