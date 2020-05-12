package com.infy.verizon.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.verizon.model.JwtRequest;
import com.infy.verizon.model.JwtResponse;
import com.infy.verizon.service.JwtUserDetailsService;
//
//@RestController
public class AuthenticateAPI {
	
//	@Autowired
//	private AuthenticationManager authenticationManager;
//	
//	@Autowired
//	private JwtTokenUtil jwtTokenUtil;
//	
//	@Autowired
//	private JwtUserDetailsService userDetailsService;
//	
//	@RequestMapping(value="/authenticate",method= RequestMethod.POST)
//	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authRequest) throws Exception {
//		try {
//			authenticationManager.authenticate(
//					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
//		} catch (BadCredentialsException e) {
//			throw new Exception("Incorrect username or password", e);
//		}
//		
//		final UserDetails userDetails = userDetailsService
//					.loadUserByUsername(authRequest.getUsername());
//			
//		final String jwt = jwtTokenUtil.generateToken(userDetails);
//		
//		return ResponseEntity.ok(new JwtResponse(jwt));
//		}
//	
}
