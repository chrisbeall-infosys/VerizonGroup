package com.infy.verizon.dao;

import com.infy.verizon.model.Traveler;

public interface TravelerDAO {
	public String registerNewTraveler(Traveler traveler);
	public String authenticateAdmin(String email, String password);
	public Traveler getCustomerByLoginId(String loginId);
}
