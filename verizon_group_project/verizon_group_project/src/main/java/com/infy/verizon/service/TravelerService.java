package com.infy.verizon.service;

import com.infy.verizon.model.Traveler;

public interface TravelerService {
	public String registerNewTraveler(Traveler traveler);
	public String authenticateTraveler(String email, String password);
}
