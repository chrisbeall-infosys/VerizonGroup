package com.infy.verizon.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.verizon.dao.TravelerDAO;
import com.infy.verizon.exception.TravelerServiceException;
import com.infy.verizon.model.Traveler;
import com.infy.verizon.utility.HashingUtility;

@Service(value="travelerService" )
@Transactional
public class TravelerServiceImpl implements TravelerService {

	@Autowired
	private TravelerDAO travelerDAO;
	
	@Override
	public Optional<Traveler> registerNewTraveler(Traveler traveler) throws Exception {
		
		
		Optional<Traveler> newTraveler = Optional.empty();
		
		Boolean available = travelerDAO.checkAvailabilityOfLoginId(traveler.getLoginId());
		if(available){
			
				String loginIdToDB = traveler.getLoginId();
				String passwordToDB = HashingUtility.getHashValue(traveler.getPassword());
				
				traveler.setLoginId(loginIdToDB);
				traveler.setPassword(passwordToDB);
				
				newTraveler = travelerDAO.registerNewTraveler(traveler);
				
		} else{
			throw new TravelerServiceException("TravelerService.LOGIN_ID_ALREADY_IN_USE");
		}
		
		return newTraveler;
	}

	@Override
	public Optional<Traveler> authenticateTraveler(String loginId, String password) throws Exception {
		
		Optional<Traveler> traveler = Optional.empty();
		
		String passwordToDB = HashingUtility.getHashValue(password);
		String travelerLoginIdFromDAO = travelerDAO.authenticateTraveler(loginId, passwordToDB);
		
		if(travelerLoginIdFromDAO !=null){
			
				traveler  = travelerDAO.getTravelerByLoginId(travelerLoginIdFromDAO);
		}
		else
			throw new TravelerServiceException("TravelerService.INVALID_CREDENTIALS");
		
		return traveler;
	}

}
