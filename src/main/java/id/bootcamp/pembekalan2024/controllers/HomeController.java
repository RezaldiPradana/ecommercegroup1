package id.bootcamp.pembekalan2024.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String loadHomePage(HttpServletRequest servlet, Model model) {
		return "index.html";
	}
	
	@RequestMapping("/product")
	public String loadDetailProductPage() {
		return "product/detail.html";
	}

}
