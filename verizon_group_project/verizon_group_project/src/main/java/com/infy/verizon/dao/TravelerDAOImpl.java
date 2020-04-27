package com.infy.verizon.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infy.verizon.entity.TravelerEntity;
import com.infy.verizon.model.Traveler;

@Repository(value = "travelerDAO")
public class TravelerDAOImpl implements TravelerDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public String registerNewTraveler(Traveler traveler) {
		String registeredWithEmail = null;

		TravelerEntity travelerEntity = new TravelerEntity();

		travelerEntity.setEmail(traveler.getEmail());
		travelerEntity.setName(traveler.getName());
		travelerEntity.setPassword(traveler.getPassword());
		travelerEntity.setLoginId(traveler.getLoginId());
		
		entityManager.persist(travelerEntity);
		
		registeredWithEmail = travelerEntity.getEmail();
		
		return registeredWithEmail;
	}

	@Override
	public String authenticateTraveler(String loginId, String password) {

		Query query = entityManager.createQuery("select t from TravelerEntity t where t.email = '"+loginId+"' and t.password = '"+password+"'");
		
		@SuppressWarnings("unchecked")
		List<TravelerEntity> travelerEntities = query.getResultList();
		if(travelerEntities.isEmpty())
			return null;

		return travelerEntities.get(0).getEmail();
	}

	@Override
	public Traveler getTravelerByLoginId(String loginId) {

		return null;
	}

	@Override
	public String getPasswordOfTraveler(String loginId) {
		String password = null;
		loginId = loginId.toLowerCase();
		TravelerEntity travelerEntity = entityManager.find(TravelerEntity.class, loginId);
		if (travelerEntity!=null){
			password = travelerEntity.getPassword();
		}
		
		return password;
	}

	@Override
	public Boolean checkAvailabilityOfLoginId(String loginId) {
		Boolean flag = false;

		TravelerEntity customerEntity = null;

		customerEntity = entityManager.find(TravelerEntity.class, loginId);

		if(customerEntity == null)
			flag = true;

		return flag;
	}

}
