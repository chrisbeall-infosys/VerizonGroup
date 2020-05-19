package com.infy.verizon.dao;



import java.util.Optional;

import com.infy.verizon.model.Admin;

public interface AdminDAO {
	
	public Optional<Admin> registerNewAdmin(Admin admin);
	
	public Admin getAdminByLoginId(String loginId) throws Exception;
	public String getPasswordOfAdmin(String emailId);
	public Boolean checkAvailabilityOfLoginId(String loginId);
	
	
}
