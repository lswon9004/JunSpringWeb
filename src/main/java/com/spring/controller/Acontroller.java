package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Acontroller {
	
	@RequestMapping(value = "/a",method = RequestMethod.GET)
	public String isa() {
		
		
		return "a";
	}
}
