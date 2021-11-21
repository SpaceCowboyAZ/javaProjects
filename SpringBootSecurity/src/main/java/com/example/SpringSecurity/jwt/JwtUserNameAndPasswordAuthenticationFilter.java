package com.example.SpringSecurity.jwt;

import java.io.IOException;
import java.net.http.HttpResponse;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

//spring security does this for us but we can make our own implementation

public class JwtUserNameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private final AuthenticationManager autheticationManager;
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpResponse response) throws AuthenticationException {
		
		try {
			
		authenticationManager.
		UsernameAndPasswordAuthenticationRequest authenticationRequest = new ObjectMapper()
											.readValue(request.getInputStream(), UsernameAndPasswordAuthenticationRequest.class);
		
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return super.attemptAuthentication(request, response);
	}
}
