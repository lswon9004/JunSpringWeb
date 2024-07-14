package com.spring.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.naver.command.NSearch;

@Controller
public class LocalSearchController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/naverlocal")
	public String form() {
		return "local/localform";
	}
	@PostMapping("/naverlocal")
	//@ResponseBody
	public String naver(@RequestParam(value = "query", defaultValue = "갈비집") String query, Model m) {
		URI uri = UriComponentsBuilder
				.fromUriString("https://openapi.naver.com")
				.path("/v1/search/local.json")
				.queryParam("query", query)
				.queryParam("display", "5")
				.queryParam("start", "1")
				.queryParam("sort", "random")
				.encode().build().toUri();
		RequestEntity<Void> req = RequestEntity
				.get(uri)
				.header("X-Naver-Client-Id", "hysa_dpJm2ciS7VokKF5")
				.header("X-Naver-Client-Secret", "e9D1Xq_F8o")
				.build();
		 ResponseEntity<NSearch> response 
	        = restTemplate.exchange(req, NSearch.class);
		 m.addAttribute("result", response.getBody());
		 m.addAttribute("query", query);
		return "local/local";
	}
}
