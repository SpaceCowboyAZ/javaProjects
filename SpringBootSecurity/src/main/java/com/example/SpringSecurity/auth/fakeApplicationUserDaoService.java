package com.example.SpringSecurity.auth;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.SpringSecurity.security.ApplicationUserRole;
import com.google.common.collect.Lists;


@Repository("fake")
public class fakeApplicationUserDaoService implements ApplicationUserDao {

	
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public fakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	@Override
	public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
		return getApplicationUsers().stream().filter(applicationUser -> username.equals(applicationUser.getUsername())).findFirst();
		
	}
	
	private List<ApplicationUser> getApplicationUsers() {
		List<ApplicationUser> applicationUsers = Lists.newArrayList(
				new ApplicationUser("AnakinSkyWalker",
						passwordEncoder.encode("password"),
						 ApplicationUserRole.STUDENT.getGrantedAuthorities(),
						true, true, true, true), 

							new ApplicationUser("Ahsoka",
									passwordEncoder.encode("password123"),
									 ApplicationUserRole.ADMINTRAINEE.getGrantedAuthorities(),
									true, true, true, true),

							new ApplicationUser("Obi Won",
									passwordEncoder.encode("password123"),
									 ApplicationUserRole.ADMIN.getGrantedAuthorities(),
									true, true, true, true)
				
				);
				
		
		return applicationUsers;
		
	}
}
