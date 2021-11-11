package com.example.SpringSecurity.auth;

import java.util.Optional;

public class ApplicationUserDao {

	Optional<ApplicationUser> selectApplicationUserByUsername(String username);
}
