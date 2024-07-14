package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.command.Form;



@Controller
public class TestController {
	
	@GetMapping("/test/form")
	public String form() {
		return "/test/form";
	}

	@PostMapping("/test/submit")
	public String submit(@ModelAttribute("test") Form frompet) {
		
		return "/test/submit";
	}
	@GetMapping("/test/a")
	public String getMethodName() {
		return "/test/a";
	}
	
}
