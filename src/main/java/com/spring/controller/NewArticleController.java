package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.command.NewArticleCommand;
import com.spring.service.ArticleService;

@Controller
@RequestMapping("/article/newArticle")
public class NewArticleController {

	@Autowired
	private ArticleService articleService;

	// @RequestMapping 메서드의 리턴 타입이 String => return값을 viewname으로 사용
	// @RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public String form() {
		return "article/newArticleForm";
	}

	// 1. DispatcherServlet이 NewArticleCommand객체 생성
	// 2. NewArticleCommand객체의 변수명과 같은 파라미터값 저장
	// 3. @ModelAttribute("이름") - 파라미터 값이 저장된 객체를 이름을 지정해서 모델데이터에 추가
	// 데이터의 이름은 타입(클래스명)을 소문자로 바꿔서 사용함
	// NewArticleCommannd
	@PostMapping
	public String submit(NewArticleCommand command) {
		articleService.writeArticle(command);
		return "article/newArticleSubmit";
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

}
