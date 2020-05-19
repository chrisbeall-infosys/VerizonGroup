package com.infy.verizon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.verizon.dao.TravelerDAO;
import com.infy.verizon.model.Traveler;
import com.infy.verizon.utility.HashingUtility;
import com.infy.verizon.validator.TravelerValidator;

@Service(value="travelerService" )
@Transactional
public class TravelerServiceImpl implements TravelerService {

	@Autowired
	private TravelerDAO travelerDAO;
	
	@Override
	public String registerNewTraveler(Traveler traveler) throws Exception {
		
		String registeredWithLoginId = null;
		
		//TravelerValidator.validateTravelerForRegistration(traveler);
		Boolean available = travelerDAO.checkAvailabilityOfLoginId(traveler.getLoginId());
		if(available){
			
				String loginIdToDB = traveler.getLoginId();
				String passwordToDB = HashingUtility.getHashValue(traveler.getPassword());
				
				traveler.setLoginId(loginIdToDB);
				traveler.setPassword(passwordToDB);
				
				registeredWithLoginId = travelerDAO.registerNewTraveler(traveler);
				
		} else{
			throw new Exception("TravelerService.LOGIN_ID_ALREADY_IN_USE");
		}
		
		return registeredWithLoginId;
	}

	@Override
	public Traveler authenticateTraveler(String loginId, String password) throws Exception {
		
		Traveler traveler = null;
		//TravelerValidator.validateTravelerForLogin(loginId, password);
		String passwordToDB = HashingUtility.getHashValue(password);
		String travelerLoginIdFromDAO = travelerDAO.authenticateTraveler(loginId, passwordToDB);
		
		if(travelerLoginIdFromDAO!=null){
			
				traveler  = travelerDAO.getTravelerByLoginId(travelerLoginIdFromDAO);
		}
		else
			throw new Exception ("TravelerService.INVALID_CREDENTIALS");
		
		return traveler;
	}

}
