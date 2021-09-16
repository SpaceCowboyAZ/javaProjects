package com.example.demo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.student.Student;

@SpringBootApplication
@RestController //annotation that is itself annotated with @Controller and @ResponseBody. 
//The handler methods will return the JSON/XML response directly to client rather using view resolvers.
// makes hello class receive rest incomes
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@GetMapping 
 public List<Student> hello() {
	 return List.of(new Student(
					 1L, "Anakin",
					 "MasterSkyWalker@jediCouncil.com",
					 LocalDate.of(1983, 8, 15),
					 24)
			 );
 }
}
