package com.example.SpringSecurity.auth;

import java.util.Optional;

public class fakeApplicationUserDaoService implements ApplicationUserDao {

	@Override
	public Optional<ApplicationUser> selectApplicationByUsername(String username) {
		return Optional.empty();	}
}
