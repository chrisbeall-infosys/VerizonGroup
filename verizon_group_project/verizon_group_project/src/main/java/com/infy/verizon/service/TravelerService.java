package com.infy.verizon.service;

import com.infy.verizon.model.Traveler;

public interface TravelerService {
	public String registerNewTraveler(Traveler traveler) throws Exception;
	public Traveler authenticateTraveler(String loginId, String password) throws Exception;
}
