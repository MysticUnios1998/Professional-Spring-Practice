package co.edu.platzi.spring.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class AuthenticationResponse {

	private String jwt;
	
}
