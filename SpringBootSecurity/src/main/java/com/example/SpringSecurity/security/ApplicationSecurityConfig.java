package com.example.SpringSecurity.security;


import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity 
@EnableGlobalMethodSecurity(prePostEnabled = true)
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
//		.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())    Sets up csrf. reference*

		.csrf().disable() //csrf - Cross Site Request Forgery
		.authorizeRequests()
		.antMatchers("/", "index", "/css/*", "/js/*") // allow requests go through root, index, css, and javascript
		.permitAll()  
		.antMatchers("/api/**").hasRole(ApplicationUserRole.STUDENT.name()) //** selects all
	.antMatchers(HttpMethod.DELETE, "management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.name())
	.antMatchers(HttpMethod.POST, "management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.name())		
		.antMatchers(HttpMethod.PUT, "management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.name())
		.antMatchers(HttpMethod.GET, "/api/**").hasRole(ApplicationUserRole.STUDENT.name())
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()		// form based auth
		.loginPage("/login").permitAll()
		.defaultSuccessUrl("/courses", true)
				//.passwordParameter("passwordxyz")  //* can change default paramater names but need to match in HTML file
				//.usernameParameter("usernamexyz")
		.and()
		.rememberMe() //defaults to 2 weeks
		.tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(21))
		.key("somethingverysecured")
		.rememberMeParameter("remember-me")
		.and()
		.logout()
		.logoutUrl("/logout")
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")) //if csrf is enabled, you want this to be POST to prevent attacks
		.clearAuthentication(true)
		.invalidateHttpSession(true)
		.deleteCookies("JSESSIONID", "remember-me")
		.logoutSuccessUrl("/login");
				
		
		//.httpBasic(); //forces authenticity of client *reference
	}

@Override
@Bean
protected UserDetailsService userDetailsService() {  //UserDetailsService retrieves users from database
	UserDetails AnakinSkyWalkerUser = User.builder()
			.username("Anakin SkyWalker")
			.password(passwordEncoder.encode("password"))
			//.roles(ApplicationUserRole.STUDENT.name()) //ROLE_STUDENT
			.authorities(ApplicationUserRole.STUDENT.getGrantedAuthorities())
			.build();
//			return new InMemoryUserDetailsManager(
//					AnakinSkyWalkerUser);

			UserDetails obiUser = User.builder()
			.username("Obi Won Kenobi")
			.password(passwordEncoder.encode("password123"))
			//.roles(ApplicationUserRole.ADMIN.name()) //ROLE_ADMIN
			.authorities(ApplicationUserRole.ADMIN.getGrantedAuthorities())
			.build();
			
			
			UserDetails ahsokaUser = User.builder()
					.username("Ahsoka Tanyo")
					.password(passwordEncoder.encode("password123"))
					//.roles(ApplicationUserRole.ADMINTRAINEE.name()) //ROLE_ADNINTRAINEE
					.authorities(ApplicationUserRole.ADMINTRAINEE.getGrantedAuthorities())
					.build();
					return new InMemoryUserDetailsManager(AnakinSkyWalkerUser, obiUser, ahsokaUser);
}

}
