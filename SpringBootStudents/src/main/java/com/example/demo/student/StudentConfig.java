package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repositry) {
	return args -> {
		Student anakin = new Student(
				 1L, "Anakin",
				 "MasterSkyWalker@jediCouncil.com",
				 LocalDate.of(1983, 8, 15),
				 24);
		 
		 Student Ahsoka = new Student( //database will generate id
				 "Ahsoka",
				 "Ahsoka@jediCouncil.com",
				 LocalDate.of(1993, 5, 16),
				 21);
	
	
	//saves to database
	repositry.saveAll(
			List.of(anakin, Ahsoka));
			
	
};
}
}
