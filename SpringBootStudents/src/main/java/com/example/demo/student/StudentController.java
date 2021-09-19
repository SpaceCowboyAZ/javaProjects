package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //annotation that is itself annotated with @Controller and @ResponseBody. 
//The handler methods will return the JSON/XML response directly to client rather using view resolvers.
//makes hello class receive rest incomes

@RequestMapping(path = "api/v1/student") //can be applied to class-level and/or method-level in a controller.
//maps a specific request path on controller.can apply additional method-level annotations to make mappings more specific to handler methods.



//controller will have all resources for the API
public class StudentController {
	
	//reference for studentService
	private final StudentService studentService;
	
	@Autowired
public StudentController(StudentService studentService) {
	this.studentService = studentService;
}
	
	@GetMapping //composed annotation that acts as a shortcut for @RequestMapping (method = RequestMethod.GET)
	// used both at the class and at the method level.
 public List<Student> getStudents() {
	 return studentService.getStudents();
 }
	//post
	@PostMapping
	public void addNewStudent(@RequestBody Student student) { //This annotation indicates that Spring should deserialize a request body into an object. 
															  // This object is passed as a handler method parameter.
	System.out.println(student);
	
	}
	

}

