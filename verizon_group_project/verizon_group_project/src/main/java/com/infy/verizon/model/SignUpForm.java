package com.infy.verizon.model;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

public class SignUpForm {
	@NotBlank
	@Size(min = 3, max = 50)
	@Getter
	@Setter
	private String name;

	@NotBlank
	@Size(min = 3, max = 50)
	@Getter
	@Setter
	private String username;

	@NotBlank
	@Size(max = 60)
	@Email
	@Getter
	@Setter
	private String email;

	@Getter
	@Setter
	private Set<String> role;

	@NotBlank
	@Size(min = 6, max = 40)
	@Getter
	@Setter
	private String password;
}
