package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.spring.dto.Emp;
import com.spring.service.EmpService;

@Controller
public class EmpController {
	@Autowired
	EmpService eser;
	
	@GetMapping("/emp/form")
	public void form() {
		
	}
	@GetMapping("/emp/search")
	public void search(Emp emp, Model m) {
		List<Emp> elist = eser.searchEmp(emp);
		m.addAttribute("ename", elist);
	}
	@GetMapping("/emp/dept")
	public void dform(Model m) {
		List<Integer> ilist = eser.getdeptnoAll();
		m.addAttribute("deptno", ilist);
	}
	@GetMapping("/emp/ename")
	@ResponseBody
	public String getEname(@RequestParam("deptno") int deptno) {
		String[] sarr = eser.getEname(deptno);
		Gson gson = new Gson();
		return gson.toJson(sarr);
	}
	@GetMapping("/emp/emp")
	@ResponseBody
	public String getEmp(@RequestParam("ename") String ename) {
		List<Emp> emp = eser.getEmp(ename);
		Gson gson = new Gson();
		return gson.toJson(emp);
	}
	@GetMapping("/emp/{empno}")
	@ResponseBody
	public String empOne(@PathVariable("empno") int empno) {
		Emp emp = eser.empOne(empno);
		Gson gson = new Gson();
		return gson.toJson(emp);
	}
}
