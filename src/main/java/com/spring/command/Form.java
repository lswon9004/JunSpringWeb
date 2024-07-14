package com.spring.command;

import lombok.Data;

@Data
public class Form {
	private String id;
	private String pwd;
	private String name;
	private String phone;
	
	private String[] pet;
}
