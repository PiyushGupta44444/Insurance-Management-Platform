package com.insurancePolicy.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurancePolicy.Payloads.JwtAuthResponse;
import com.insurancePolicy.Payloads.JwtRequest;
import com.insurancePolicy.Security.JwtTokenHelper;
import com.insurancePolicy.Service.UserDetailsServiceImpl;


@RestController
public class AuthController {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private JwtTokenHelper jwtTokenHelper;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/generate-token")
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtRequest jwtRequest) {

		try {
			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
		}
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());

		String token = this.jwtTokenHelper.generateToken(userDetails);
		return ResponseEntity.ok(new JwtAuthResponse(token));

	}
}
