package appUser;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

	private final static String USER_NOT_FOUND =
			"user with email %s not found";
	
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder cryptPassword;
	
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
	//TODO: Send confirm token
	
	return "";
	}
}
