package com.infy.verizon.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Admin")
public class AdminEntity {
	
	@Id
	@Getter @Setter
	private String loginId;
	
	@Getter @Setter
	private String email;

	
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private String password;
	
	
	
}
