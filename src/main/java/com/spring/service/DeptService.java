package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.DeptDao;
import com.spring.dto.Dept;

@Service
public class DeptService {
	
	@Autowired
	DeptDao dao;
	  
	public List<Dept> deptAll(){
		return dao.deptAll();
	}
	
	public Dept deptOne(int deptno) {
		return dao.deptOne(deptno);
	}
	public int deptCount() {
		return dao.deptCount();
	}
	public int insertDept(Dept dept) {
		return dao.insertDept(dept);
	}
	public int getdeptno() {
		return dao.getdeptno();
	}
}