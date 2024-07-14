package com.spring.crawling.command;

import java.util.List;

import lombok.Data;

@Data
public class BookSearchResult {
	String lastBuildDate;
	int total;
	int start;
	int display;
	List<Item1> items;
}
