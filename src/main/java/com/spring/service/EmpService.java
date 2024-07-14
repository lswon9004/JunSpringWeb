package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.EmpDao;
import com.spring.dto.Emp;

@Service
public class EmpService {
	
	@Autowired
	EmpDao dao;
	
	public List<Emp> searchEmp(Emp emp){
		return dao.searchEmp(emp);
	}
	public List<Integer> getdeptnoAll(){
		return dao.getdeptnoAll();
	}
	public String[] getEname(int i) {
		return dao.getEname(i);
	}
	public List<Emp> getEmp(String ename) {
		return dao.getEmp(ename);
	}
	public Emp empOne(int empno) {
		return dao.empOne(empno);
	}
}
