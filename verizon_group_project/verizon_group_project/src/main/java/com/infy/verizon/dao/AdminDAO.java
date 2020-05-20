package com.infy.verizon.dao;



import java.util.Optional;

import com.infy.verizon.model.Admin;

public interface AdminDAO {
	
	public Optional<Admin> registerNewAdmin(Admin admin);
	
	public String authenticateAdmin(String loginId, String password);
	
	public Optional<Admin> getAdminByLoginId(String loginId);
	
	public String getPasswordOfAdmin(String loginId);
	
	public Boolean checkAvailabilityOfLoginId(String loginId);
	
	
}
