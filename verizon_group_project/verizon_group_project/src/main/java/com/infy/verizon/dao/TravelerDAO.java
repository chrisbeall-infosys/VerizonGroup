package com.infy.verizon.dao;



import com.infy.verizon.model.Traveler;

public interface TravelerDAO {
	public String registerNewTraveler(Traveler traveler)  throws Exception;
	public String authenticateTraveler(String loginId, String password) throws Exception;
	public Traveler getTravelerByLoginId(String loginId) throws Exception;
	public String getPasswordOfTraveler(String loginId) throws Exception;
	public Boolean checkAvailabilityOfLoginId(String loginId) throws Exception;
}
