package com.infy.verizon.service;

import java.util.Optional;

import com.infy.verizon.model.Admin;

public interface AdminService {
	public Optional<Admin> registerNewAdmin(Admin admin) throws Exception;
	public Optional<Admin> authenticateAdmin(String loginId, String password) throws Exception;
}
