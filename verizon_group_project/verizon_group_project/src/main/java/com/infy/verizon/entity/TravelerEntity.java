package com.infy.verizon.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Traveler")
public class TravelerEntity {
	
	@Id
	@Getter @Setter
	private String loginId;
	
<<<<<<< HEAD

	private String email;
	
	
=======
	@Getter @Setter
	private String email;
	
	@Getter @Setter
>>>>>>> bbd3cd511fc00561e7299fd1da2a54821ae2d9a0
	private String name;
	
	@Getter @Setter
	private String password;
	
<<<<<<< HEAD
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
>>>>>>> bbd3cd511fc00561e7299fd1da2a54821ae2d9a0


}

