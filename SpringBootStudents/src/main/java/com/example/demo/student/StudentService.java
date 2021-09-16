package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service // use service for readability

// can also use @Component //indicates that an annotated class is a "component". 
//Such classes are considered as candidates for auto-detection when using annotation-based configuration and classpath scanning.
//used on autowire
public class StudentService {

	public List<Student> getStudents() {
		 return List.of(new Student(
						 1L, "Anakin",
						 "MasterSkyWalker@jediCouncil.com",
						 LocalDate.of(1983, 8, 15),
						 24)
				 );
}
}