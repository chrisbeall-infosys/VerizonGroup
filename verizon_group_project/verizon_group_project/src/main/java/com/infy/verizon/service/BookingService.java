package com.infy.verizon.service;

import java.util.Optional;

import com.infy.verizon.entity.BookingEntity;
import com.infy.verizon.model.Booking;

public interface BookingService {

	public Optional<BookingEntity> addNewBooking(Booking booking);
}
