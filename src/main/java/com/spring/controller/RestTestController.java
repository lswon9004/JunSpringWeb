package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/rest")
public class RestTestController {
	
	@GetMapping
	public String form() {
		return "rest/form";
	}
	@PostMapping
	public String postSubmit(@ModelAttribute("name") String name) {
		System.out.println("name : "+ name);
		return "rest/test"; //index.html
	}
	@PutMapping
	public String putSubmit(@RequestParam("name") String name) {
		System.out.println("put name : "+name);
		return "redirect:/";
	}
	@DeleteMapping
	public String deleteSubmit(@RequestParam("name") String name) {
		System.out.println("delete name : "+name);
		return "redirect:/";
	}
}
