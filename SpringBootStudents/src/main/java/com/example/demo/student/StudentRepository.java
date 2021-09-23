package com.example.demo.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
//data access layer

@Repository // responsible for data access
public interface StudentRepository extends JpaRepository<Student, Long> { //object and PK (ID)
	
	//SELECT * FROM student WHERE email = ?
//	@Query("SELECT s FROM Student s  WHERE s.email = ?1") //jpql
	Optional<Student> findStudentByEmail(String email);
	

}
