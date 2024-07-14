package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.dto.Dept;
import com.spring.service.DeptService;

@Controller
public class DeptController {
	
	@Autowired
	DeptService dservice;
	
	@GetMapping("/deptAll")
	public String deptAll(Model m) {
		List<Dept> dlist = dservice.deptAll();
		m.addAttribute("deptAll",dlist);

		return "dept/deptAll";
	}
	@GetMapping("/dept/form")
	public void goForm(Model m) {
		int i = dservice.getdeptno();
		m.addAttribute("deptno", i);
		
	}
	@PostMapping("/dept/insert")
	public String insert(Dept dept, Model m) {
		int count = dservice.insertDept(dept);
		System.out.println(count);
		List<Dept> dlist = dservice.deptAll();
		m.addAttribute("deptAll",dlist);
		
		return "/dept/result";
	}
}