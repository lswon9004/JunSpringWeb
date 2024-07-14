package com.spring.service;

import org.springframework.stereotype.Service;

import com.spring.command.SearchCommand;

@Service
public class SearchService {
	public SearchResult search(SearchCommand command) {
		return new SearchResult();
	}
}


