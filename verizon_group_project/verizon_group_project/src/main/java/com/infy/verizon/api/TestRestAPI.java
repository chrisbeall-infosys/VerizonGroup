package com.infy.verizon.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TestRestAPI {
	@GetMapping("/api/test/traveler")
	@PreAuthorize("hasRole('TRAVELER') or hasRole('ADMIN')")
	public String userAccess() {
		return ">>> Traveler Contents!";
	}


	@GetMapping("/api/test/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return ">>> Admin Contents";
	}
}
