package com.infy.verizon.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter
@Table(name="Admin")
public class AdminEntity {
	
	@Id
	private String loginId;	
	
	private String email;
	
	private String name;
	
	private String password;
	
}
