package com.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.spring.dto.Emp;

@Mapper
public interface EmpDao {
	
	List<Emp> searchEmp(Emp emp);
	List<Integer> getdeptnoAll();
	String[] getEname(int deptno);
	List<Emp> getEmp(String ename);
	
	@Select("select empno, ename, job, hiredate, dname as 'dept.dname', loc as 'dept.loc' "
			+"from emp e inner join dept d on e.deptno = d.deptno " 
			+"where empno = #{empno}")
	Emp empOne(int empno);
}
