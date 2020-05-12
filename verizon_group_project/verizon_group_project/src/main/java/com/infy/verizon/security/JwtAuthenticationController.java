package com.infy.verizon.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.verizon.model.Admin;
import com.infy.verizon.model.JwtRequest;
import com.infy.verizon.model.JwtResponse;
import com.infy.verizon.service.JwtUserDetailsService;


//@RestController
//@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody Admin authenticationRequest) throws Exception {
		
		authenticate(authenticationRequest.getLoginId(), authenticationRequest.getPassword());
		
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getLoginId());
		
		final String token = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponse(token));
	}
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("AdminService.INVALID_CREDENTIALS", e);
		}
	}
}

