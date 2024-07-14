package com.spring.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class CookieController {

	@RequestMapping("/cookie/make")
	public String make(HttpServletResponse response){
		response.addCookie(new Cookie("auth", "abc123"));
		//return "cookie/made";
		return "redirect:/cookie/view";
	}

	@RequestMapping("/cookie/view")
	public void view(
		@CookieValue(value = "auth", defaultValue = "0") String auth) {
		System.out.println("auth 쿠키: " + auth);
	
		//return "cookie/view";
	}
}
