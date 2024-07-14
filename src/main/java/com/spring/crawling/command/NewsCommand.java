package com.spring.crawling.command;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewsCommand {
	private String text;
	private String link;
}
