package com.infy.verizon.model;

<<<<<<< HEAD

public class Traveler {
	
	//@Getter @Setter
	private String loginId;
	
	//@Getter @Setter
	private String email;
	
	//@Getter @Setter
	private String name;
	
	//@Getter @Setter
	private String password;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
=======
import lombok.Getter;
import lombok.Setter;

public class Traveler {
	
	@Getter @Setter
	private String loginId;
	
	@Getter @Setter
	private String email;
	
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private String password;
>>>>>>> bbd3cd511fc00561e7299fd1da2a54821ae2d9a0
	
	
}

