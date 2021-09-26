package com.example.SpringSecurity.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity // annotated at class level with @Configuration annotation to enable web securities in our application
//defined by WebSecurityConfigurer implementations
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter { 
//To override web securities defined by WebSecurityConfigurerAdapter in our Java configuration class,
	//we need to extend this class and override its methods.
	
@Override //make sure the public class extends WebSecurityConfigurerAdapter or THIS WON'T WORK
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic(); //forces authenticity of client
	}

}
