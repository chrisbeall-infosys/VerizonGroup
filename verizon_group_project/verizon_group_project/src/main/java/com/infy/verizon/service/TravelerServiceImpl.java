package com.infy.verizon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.verizon.dao.TravelerDAO;
import com.infy.verizon.model.Traveler;

@Service(value="travelerService" )
@Transactional
public class TravelerServiceImpl implements TravelerService {

	@Autowired
	private TravelerDAO customerDAO;
	
	@Override
	public String registerNewTraveler(Traveler traveler) {
		
		return null;
	}

	@Override
	public String authenticateTraveler(String email, String password) {
		
		return null;
	}

}
