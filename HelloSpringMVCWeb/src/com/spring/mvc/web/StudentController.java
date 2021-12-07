package com.spring.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

@Controller
public class StudentController {
   @GetMapping("/student")
   public ModelAndView student() {
      return new ModelAndView("student", "command", new Student());
   }
   @PostMapping("/addStudent")
   public String addStudent(@ModelAttribute("SpringWeb")Student student, ModelMap model) {
	  model.addAttribute("name", student.getName());
      model.addAttribute("age", student.getAge());
      model.addAttribute("id", student.getId());
      
      return "result";
   }
}