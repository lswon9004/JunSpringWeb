package com.spring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.command.OrderCommand;

@Controller
@RequestMapping("/order/order") 
public class OrderController {

	@GetMapping
	public String form() {
		return "order/orderForm";
	}
	
	@PostMapping
	public String submit(@ModelAttribute("order") OrderCommand orderCommand) {
		return "order/orderCompletion";
	}
}