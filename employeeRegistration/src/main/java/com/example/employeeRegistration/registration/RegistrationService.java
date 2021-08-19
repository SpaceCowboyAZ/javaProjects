package com.example.employeeRegistration.registration;

import org.springframework.stereotype.Service;

import com.example.employeeRegistration.AppUser.AppUserRole;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistrationService {

	private final com.example.employeeRegistration.AppUser.AppUserService appUserService;
	private final EmailValidation emailValidation;
	
	
	public String register(registrationRequest request) {
		boolean isValidEmail = emailValidation.test(request.getEmail());
		
		if(!isValidEmail) {
			throw new IllegalStateException("Not a valid email");
		}
		return appUserService.signUp(new com.example.employeeRegistration.AppUser.AppUser(
		request.getFirstName(),
		request.getLastName(),
		request.getEmail(),
		request.getPassword(),
		AppUserRole.USER));
	}

}
