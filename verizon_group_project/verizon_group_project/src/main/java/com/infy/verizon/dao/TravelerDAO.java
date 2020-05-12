package com.infy.verizon.dao;

import com.infy.verizon.model.Traveler;

public interface TravelerDAO {
	public String registerNewTraveler(Traveler traveler) ;
	public String authenticateTraveler(String loginId, String password);
	public Traveler getTravelerByLoginId(String loginId);
	public String getPasswordOfTraveler(String loginId);
	public Boolean checkAvailabilityOfLoginId(String loginId);
}
