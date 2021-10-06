package com.example.SpringSecurity.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity 
// annotated at class level with @Configuration annotation to enable web securities in our application
//defined by WebSecurityConfigurer implementations
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter { 
//To override web securities defined by WebSecurityConfigurerAdapter in our Java configuration class,
	//we need to extend this class and override its methods.
	
private final PasswordEncoder passwordEncoder;	

@Autowired
public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
	this.passwordEncoder = passwordEncoder;
}
	
	
@Override //make sure the public class extends WebSecurityConfigurerAdapter or THIS WON'T WORK
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/", "index", "/css/*", "/js/*") // allow requests go thorugh root, index, css, and javascript
		.permitAll()  //permits patterns above
		.antMatchers("/api/**").hasRole(ApplicationUserRole.STUDENT.name())
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic(); //forces authenticity of client
	}

@Override
@Bean
protected UserDetailsService userDetailsService() {  //UserDetailsService retreives users from database
	UserDetails AnakinSkyWalkerUser = User.builder()
			.username("Anakin SkyWalker")
			.password(passwordEncoder.encode("password"))
			.roles(ApplicationUserRole.STUDENT.name()) //ROLE_STUDENT
			.build();
//			return new InMemoryUserDetailsManager(
//					AnakinSkyWalkerUser);

			UserDetails obiUser = User.builder()
			.username("Obi Won Kenobi")
			.password(passwordEncoder.encode("password123"))
			.roles(ApplicationUserRole.ADMIN.name())
			.build();
			return new InMemoryUserDetailsManager(AnakinSkyWalkerUser, obiUser);
}

}
