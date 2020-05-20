package com.infy.verizon.dao;



import java.util.Optional;

import com.infy.verizon.model.Traveler;

public interface TravelerDAO {
	public Optional<Traveler> registerNewTraveler(Traveler traveler);
	
	public String authenticateTraveler(String loginId, String password);
	
	public Optional<Traveler> getTravelerByLoginId(String loginId);
	
	public String getPasswordOfTraveler(String loginId);
	
	public Boolean checkAvailabilityOfLoginId(String loginId);
}
