package com.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.dto.Dept;

@Mapper
public interface DeptDao {

	List<Dept> deptAll(); 
	
	Dept deptOne(int deptno);
	
	int deptCount();
	
	int insertDept(Dept dept);
	
	int getdeptno();
}  
