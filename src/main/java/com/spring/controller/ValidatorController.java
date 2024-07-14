package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.command.ContentCommand;


@Controller
public class ValidatorController {

	@GetMapping("/valid/insertForm")
	public String form() {
		return "validator/createPage";
	}

	@PostMapping("/valid/create")
	public String submit(@ModelAttribute("command") @Validated ContentCommand command, BindingResult result) {
		String view = "validator/createDonePage";
		
		if(result.hasErrors()) {
			if(result.getFieldError("writer") != null) {
				System.out.println("writer : "+ result.getFieldError("writer").getDefaultMessage());
			}
			view = "validator/createPage";
		}

		return view;
	}

}