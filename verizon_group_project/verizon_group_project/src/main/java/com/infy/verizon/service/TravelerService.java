package com.infy.verizon.service;

import java.util.Optional;

import com.infy.verizon.model.Traveler;

public interface TravelerService {
	public Optional<Traveler> registerNewTraveler(Traveler traveler) throws Exception;
	public Optional<Traveler> authenticateTraveler(String loginId, String password) throws Exception;
}
