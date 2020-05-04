package com.infy.verizon.dao;



import com.infy.verizon.model.Admin;

public interface AdminDAO {
	
	public String registerNewAdmin(Admin admin);
	
	public Admin getAdminByLoginId(String loginId) throws Exception;
	public String getPasswordOfAdmin(String emailId);
	public Boolean checkAvailabilityOfLoginId(String loginId);
	
	
}
