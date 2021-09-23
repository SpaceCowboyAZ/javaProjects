package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service // use service for readability

// can also use @Component //indicates that an annotated class is a "component". 
//Such classes are considered as candidates for auto-detection when using annotation-based configuration and classpath scanning.
//used on autowire
public class StudentService {
	
	@Autowired
	private final StudentRepository studentRepository;
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
		
	}

	public List<Student> getStudents() {
		 return studentRepository.findAll();
		 
	}
		 
		 public void addNewStudent(Student student) { 
			Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
			
			if (studentByEmail.isPresent()) {
				throw new IllegalStateException("email taken");
			}
			
			 studentRepository.save(student); //saves student if email isn't present 
}

		public void deleteStudent(Long studentId) {
		boolean exists = studentRepository.existsById(studentId);
		if (!exists) {
			throw new IllegalStateException("student with id" + studentId + "does not exist");
			
		}

		studentRepository.deleteById(studentId);
			
		}	
		 
}
		
		
	
