package id.bootcamp.pembekalan2024.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {

	@RequestMapping("/register")
	public String register() {
		return "user/register.html";
	}
	
}
