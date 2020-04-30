package com.infy.verizon.service;

import com.infy.verizon.model.Admin;

public interface AdminService {
	public String registerNewAdmin(Admin admin) throws Exception;
	public Admin authenticateAdmin(String loginId, String password) throws Exception;
}
