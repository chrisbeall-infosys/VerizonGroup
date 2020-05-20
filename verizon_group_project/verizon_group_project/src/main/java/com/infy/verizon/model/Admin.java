package com.infy.verizon.model;



import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@ApiModel(description="Details about admin")
public class Admin {
	
	@NotEmpty
	@Size(min=6, max=15)
	@Pattern(regexp="[a-zA-Z0-9]{6,15}",message="length must be between 6 and 15")  
	@ApiModelProperty(notes="The unique username of the admin")
	private String loginId;
	
	
	
	@Pattern(regexp="[a-zA-Z0-9._]+@[a-zA-Z]{2,}\\.[a-zA-Z][a-zA-Z.]+",message="valid email required")  
	@ApiModelProperty(notes="The admin's email")
	private String email;
	
	
	@Pattern(regexp="([A-Za-z])+(\\s[A-Za-z]+)*",message="only alphabet and space characters are allowed")  
	@ApiModelProperty(notes="The admin's name")
	private String name;
	
	@NotEmpty
	@Size(min=6)
	@Pattern(regexp="^(?=\\P{Ll}*\\p{Ll})(?=\\P{Lu}*\\p{Lu})(?=\\P{N}*\\p{N})(?=[\\p{L}\\p{N}]*[^\\p{L}\\p{N}])[\\s\\S]{6,}$",message="must contain at least 6 characters with 1 upper case, 1 lowercase, 1 special character and 1 digit")  
	@ApiModelProperty(notes="The admin's password")
	private String password;
	
}
