package ndtinh.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {
	@GetMapping("/hello")
	public String printHello(ModelMap model) {
		model.addAttribute("message", "Hello RESTFUL API!");
		return "hello";
	}
}
