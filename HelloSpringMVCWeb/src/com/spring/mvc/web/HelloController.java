package com.spring.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	@GetMapping("/hello")
	public String printHello(ModelMap model) {
		model.addAttribute("message", "Hi my name is Bydin");
		return "hellos";
	}
	
	@GetMapping("/index")
	public String index() {
	    return "index";
	}
	@GetMapping("/redirect")
	public String redirect() {
	    return "redirect:finalPage";
	}
	@GetMapping("/finalPage")
	public String finalPage() {
	   return "final";
	}
}
