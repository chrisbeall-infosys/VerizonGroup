package com.infy.verizon.dao;


import com.infy.verizon.model.Admin;

public interface AdminDAO {
	
	public String registerNewAdmin(Admin admin);
	public String authenticateAdmin(String email, String password);
	public Admin getCustomerByLoginId(String loginId);
	
}
