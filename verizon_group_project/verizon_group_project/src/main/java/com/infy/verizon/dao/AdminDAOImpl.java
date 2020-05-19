package com.infy.verizon.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infy.verizon.entity.AdminEntity;
import com.infy.verizon.model.Admin;

@Repository(value = "adminDAO")
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Optional<Admin> registerNewAdmin(Admin admin) {
		
		Optional<Admin> newAdmin = Optional.ofNullable(admin);
		AdminEntity adminEntity = new AdminEntity();

		adminEntity.setEmail(admin.getEmail());
		adminEntity.setName(admin.getName());
		adminEntity.setPassword(admin.getPassword());
		adminEntity.setLoginId(admin.getLoginId());
		
		entityManager.persist(adminEntity);
		
		
		
		return newAdmin;
	}


	@Override
	public Admin getAdminByLoginId(String loginId) throws Exception {
		
		AdminEntity adminEntity = entityManager.find(AdminEntity.class, loginId);
		
			Admin admin = null;
			if (adminEntity != null) {
				admin = new Admin();
				admin.setEmail(adminEntity.getEmail());
				admin.setName(adminEntity.getName());
				admin.setPassword(adminEntity.getPassword());
				admin.setLoginId(adminEntity.getLoginId());
			}
		return admin;
	}

	@Override
	public String getPasswordOfAdmin(String loginId) {
		
		String password = null;
		
		AdminEntity adminEntity = entityManager.find(AdminEntity.class, loginId);
		
		if (adminEntity!=null){
			password = adminEntity.getPassword();
		}
		
		return password;
	}

	@Override
	public Boolean checkAvailabilityOfLoginId(String loginId) {
		Boolean flag = false;
		
		Query query = entityManager.createQuery("select a from AdminEntity a where a.loginId =: loginId");
		query.setParameter("loginId", loginId);
		
		@SuppressWarnings("unchecked")
		List<AdminEntity> adminEntities = query.getResultList();

		if(adminEntities.isEmpty())
			flag = true;

		return flag;
	}

}
