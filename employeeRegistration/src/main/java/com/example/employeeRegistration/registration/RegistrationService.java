package com.example.employeeRegistration.registration;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.employeeRegistration.AppUser.AppUser;
import com.example.employeeRegistration.AppUser.AppUserRole;
import com.example.employeeRegistration.token.ConfirmationToken;
import com.example.employeeRegistration.token.ConfirmationTokenService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistrationService {

	private final com.example.employeeRegistration.AppUser.AppUserService appUserService;
	private final EmailValidation emailValidation;
	 private final ConfirmationTokenService confirmationTokenService;
	
	
	public String register(registrationRequest request) {
		boolean isValidEmail = emailValidation.test(request.getEmail());
		
		if(!isValidEmail) {
			throw new IllegalStateException("Not a valid email");
		}
		 String token = appUserService.signUp(
	                new AppUser(
	                        request.getFirstName(),
	                        request.getLastName(),
	                        request.getEmail(),
	                        request.getPassword(),
	                        AppUserRole.USER));
		 
		 return token;
	
	}
	

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(
                confirmationToken.getAppUser().getEmail());
        return "confirmed";
    }
}