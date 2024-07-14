package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping("/hello")//요청 uri
	public String hello(Model m) {//Model은 항상 view에 전달 된다.
		//비지니스 로직 & view에서 사용할 데이터 생성 및 저장
		m.addAttribute("hello","안녕 hellp,spring!");
		//view name 리턴(Jsp)
		return "hello";
	}
}
