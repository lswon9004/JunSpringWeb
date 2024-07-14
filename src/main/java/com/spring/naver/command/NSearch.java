package com.spring.naver.command;

import java.util.List;

import lombok.Data;

@Data
public class NSearch {
	int total;
	List<Item> items;
}
