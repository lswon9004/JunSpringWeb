package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class GetDataController {
	//@ResponseBody : view 없이 리턴값을 response에 담아서 클라이언트에 전달
						//주로 ajax통신때 tkdydgka
	@GetMapping("/jsondata")
	public String getData() {
		List<String> list = new ArrayList<>();
		list.add("melon");
		list.add("fig");
		list.add("복숭아");
		list.add("apple");
		
		Gson gson = new Gson();
		return gson.toJson(list);//javaObject - > JSON test
	}
}
