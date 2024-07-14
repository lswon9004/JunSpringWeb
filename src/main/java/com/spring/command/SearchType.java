package com.spring.command;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchType {
	private int code;
	private String text;
}