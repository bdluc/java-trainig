package com.spring.mvc.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Error not action  Why?

@RestController
public class SpringApiController {
	private List<Student> students = new ArrayList<Student>();
	
	@GetMapping("/students")
	public List<Student> getAll() {
		return students;
	}
}
