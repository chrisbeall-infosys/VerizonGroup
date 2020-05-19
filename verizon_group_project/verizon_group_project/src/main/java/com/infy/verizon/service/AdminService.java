package com.infy.verizon.service;

import java.util.Optional;

import com.infy.verizon.model.Admin;

public interface AdminService {
	public Optional<Admin> registerNewAdmin(Admin admin) throws Exception;
	public Admin authenticateAdmin(String loginId, String password) throws Exception;
}
