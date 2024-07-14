package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.spring.dto.LoginDto;
import com.spring.service.LoginService;

import jakarta.validation.Valid;

@SessionAttributes("user")
@Controller
public class Logincontroller {

	@Autowired
	LoginService service;
	// 세션에 같은 이름으로 저장이 되어있는 경우 동작하지 않는다.
	// 세션에 저장되지 않는 경우 실행 후 리턴값을 세션에 저장한다.
   @ModelAttribute("user")
   public LoginDto getLoginDto() {
      System.out.println("getLoginDto()실행");
      return new LoginDto(); 
   }

	@GetMapping("/loginForm")
	public String form() {
		return "login/loginForm";
	}

	@PostMapping("/login")
	public String login(@Valid LoginDto dto, BindingResult result, Model m) {

		if (result.hasErrors()) {
			return "login/loginForm";
		}
		// db에서 id에 맞는 비번 꺼내옴
		String dbpw = service.login(dto.getUserid());
		if (dbpw == null) {
			// 글로벌 에러
			result.reject("nocode", "아이디 틀림");
			return "login/loginForm";
		} else if (!dbpw.equals(dto.getPassword())) {
			result.reject("nocode", "비밀번호 틀림");
			return "login/loginForm";
		} else {
			m.addAttribute("user", dto);
		}

		return "login/login";
	}
   @GetMapping("/logout")
   public String logout(SessionStatus status) {
      status.setComplete();
      return "redirect:/";
   }
   // @ModelAttribute("user") : session에 user라는 이름으로 저장된 데이터 가져옴
   @GetMapping("/checklogin")
   public String check(@ModelAttribute("user") LoginDto dto) {
      if(dto.getUserid() != null) {
         return "login/logincheck";
      }else {
         return "redirect:/loginForm"; 
      }
   }

}
