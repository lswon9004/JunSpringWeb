package com.spring.crawling.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.crawling.command.BookSearchResult;


@Service
public class ExcelService {
	@Autowired
	RestTemplate restTemplate;
	
	public BookSearchResult  bookExcel(String d_titl) {
		URI uri = UriComponentsBuilder
				.fromUriString("https://openapi.naver.com")
				.path("/v1/search/book_adv.json")
				.queryParam("d_titl", d_titl)
				.queryParam("display", "10")
				.queryParam("start", "1")
				.queryParam("sort", "sim")
				.encode().build().toUri();
		
		RequestEntity<Void> req = RequestEntity
				.get(uri)
				.header("X-Naver-Client-Id", "hysa_dpJm2ciS7VokKF5")
				.header("X-Naver-Client-Secret", "e9D1Xq_F8o")
				.build();
		ResponseEntity<BookSearchResult> response 
        = restTemplate.exchange(req, BookSearchResult.class);
		//System.out.println(response.getBody());
		return response.getBody();
	}
	
}
