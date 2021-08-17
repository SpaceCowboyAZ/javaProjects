package registration;

import org.springframework.stereotype.Service;

import appUser.AppUser;
import appUser.AppUserRole;
import appUser.AppUserService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistrationService {

	private final AppUserService appUserService;
	private final EmailValidation emailValidation;
	
	
	public String register(registrationRequest request) {
		boolean isValidEmail = emailValidation.test(request.getEmail());
		
		if(!isValidEmail) {
			throw new IllegalStateException("Not a valid email");
		}
		return appUserService.signUp(new AppUser(
		request.getFirstName(),
		request.getLastName(),
		request.getEmail(),
		request.getPassword(),
		AppUserRole.USER));
	}

}
