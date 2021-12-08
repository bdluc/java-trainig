package com.spring.mvc.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class SpringApiController {
	Student student = new Student(19, "Con meo" ,10);
	@RequestMapping(value = "/students")
	public Student getProduct() {
		return student;
	}
}
