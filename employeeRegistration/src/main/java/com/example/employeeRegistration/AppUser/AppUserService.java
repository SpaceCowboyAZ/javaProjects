package com.example.employeeRegistration.AppUser;


import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.employeeRegistration.token.ConfirmationToken;
import com.example.employeeRegistration.token.ConfirmationTokenService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

	private final static String USER_NOT_FOUND =
			"user with email %s not found";
	
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder cryptPassword;
	private final ConfirmationTokenService confirmationTokenService;
	
	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {

		return userRepository.findByEmail(email)
				.orElseThrow(() ->
				new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));	
		}
	
	public String signUp(AppUser appUser) {
	boolean userExists = userRepository.findByEmail(appUser.getEmail()).isPresent();
	
	if (userExists) {
		throw new IllegalStateException("email already taken");
	
	}
	
	String encodedPassword = cryptPassword.encode(appUser.getPassword());
	
	appUser.setPassword(encodedPassword);
	
	userRepository.save(appUser);
	
	
    String token  = UUID.randomUUID().toString();
    //TODO: Send confirm token
	ConfirmationToken confirmationToken = new ConfirmationToken(
			token, 
			LocalDateTime.now(),
			LocalDateTime.now().plusMinutes(15),
			appUser);
		
	confirmationTokenService.saveConfirmationToken(confirmationToken);
	
	//TODO: Send Email
	
	return token;
	}
	
	 public int enableAppUser(String email) {
	        return UserRepository.enableAppUser(email);
}
}