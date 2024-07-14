package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.crawling.command.BibleCommand;
import com.spring.crawling.command.NewsCommand;
import com.spring.crawling.service.CrawlingService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CrawlingController {
	
	@Autowired
	CrawlingService service;
	
	@GetMapping("/sportnews")
	public String sportsnewsCrawling(Model m) {
		List<NewsCommand> list = service.crawling();
		m.addAttribute("list", list);
		return "crawling/result";
	}
	@GetMapping("/test")
	public void downloadCrawling(@RequestParam("b") String b, Model m, HttpServletRequest request) {
		BibleCommand command = service.crawling2(b, request);
		m.addAttribute("bibles", command);
	}
	@GetMapping("/crawling/form")
	public String form() {
		return "form";
	}
}
