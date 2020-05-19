package com.infy.verizon.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter
@Table(name="Traveler")
public class TravelerEntity {
	
	@Id
	private String loginId;
	
	private String email;
	
	private String name;
	
	private String password;
	

}

