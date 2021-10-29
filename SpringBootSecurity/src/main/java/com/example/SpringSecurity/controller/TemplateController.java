package com.example.SpringSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TemplateController {
	
	
	@GetMapping("login")
	public String getLoginView() {
		
		return "login"; //has to be same name as html in template
	}
	
	@GetMapping("courses")
	public String getCourses() {
		
		return "courses";

}

}