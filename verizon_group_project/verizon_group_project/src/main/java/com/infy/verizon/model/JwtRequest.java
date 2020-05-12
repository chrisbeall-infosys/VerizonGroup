package com.infy.verizon.model;

import java.io.Serializable;



public class JwtRequest implements Serializable {
	private static final long serialVersionUID = 5926468583005150707L;
	
	//@Getter @Setter
	private String username;
	
	//@Getter @Setter
	private String password;

	// need default constructor for JSON Parsing
	public JwtRequest() {
	}

	public JwtRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
}
