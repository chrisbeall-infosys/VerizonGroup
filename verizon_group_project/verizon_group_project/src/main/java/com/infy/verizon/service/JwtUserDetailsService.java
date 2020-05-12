package com.infy.verizon.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.infy.verizon.dao.AdminDAO;
import com.infy.verizon.model.Admin;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	AdminDAO adminDAO;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Admin admin = null;
		try {
			admin = adminDAO.getAdminByLoginId(userName);
			if (admin == null) {
				throw new UsernameNotFoundException("AdminService.USER_NOT_FOUND" + userName);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new org.springframework.security.core.userdetails.User(admin.getLoginId(), admin.getPassword(),
				new ArrayList<>());
	}

	
}
