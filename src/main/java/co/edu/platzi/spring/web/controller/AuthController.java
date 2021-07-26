package co.edu.platzi.spring.web.controller;

import co.edu.platzi.spring.domain.dto.AuthenticationResponse;
import co.edu.platzi.spring.domain.service.PlatziUserDetailsService;
import co.edu.platzi.spring.web.security.JWTUtil;
import co.edu.platzi.spring.domain.dto.AuthenticationRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private PlatziUserDetailsService platziUserDetails;
	
	@Autowired
	private JWTUtil jwtUtil;

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest authRequest) {
		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
			var userDetails = platziUserDetails.loadUserByUsername(authRequest.getUsername());
			var jwt = jwtUtil.generateToken(userDetails);
			
			return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
			
		} catch (BadCredentialsException authEx) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}
	
}
