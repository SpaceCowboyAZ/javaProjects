package com.example.demo.student;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table
public class Student {
	@Id
	@SequenceGenerator(name = "student_sequence",
	sequenceName = "student_sequence",
	allocationSize = 1
	)

	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator = "student_sequence"
	)
private Long id;
private String name;
private String email;
private LocalDate dob;
private Integer age;


//constructors

public Student() {
	
}
public Student (Long id,
		String name,
		String email,
		LocalDate dob,
		Integer age) {
	this.id = id;
	this.name = name;
	this.email = email;
	this.dob = dob; 
	this.age = age;
}
//database will generate id for us so no need right here
public Student (String name,
		String email,
		LocalDate dob,
		Integer age) {
	
	this.name = name;
	this.email = email;
	this.dob = dob; 
	this.age = age;
}

//getters and setters 
//two methods used for fetching and updating the value of a variable.
//Getter methods are concerned with fetching the updated value of a variable, 
// setter methods are used to set or update an existing variable’s value
public Long getId() {
	return id;
	
}

public void setId(Long id) {
	this.id = id;
} 

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
 public LocalDate getDob() {
	 return dob;
 }

 public void setDob(LocalDate dob) {
	 this.dob = dob;
 }
 
 public Integer getAge() {
	 return age;
 }
 
 public void setAge(Integer age) {
	 this.age = age;
 }
 
 @Override //annotation indicates that the child class method is over-writing its base class method.
 //Useful reasons: It extracts a warning from the compiler if the annotated method doesn't actually override anything.
// It can improve the readability of the source code.
 public String toString() {
	 return "Student{" +
 "id=" + id + ", name ='" + name + '\'' + ", email='" + email + '\'' + ", dob=" + dob + ", age=" + age +
 '}';
 }
}
