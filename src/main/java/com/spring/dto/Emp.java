package com.spring.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Emp {//자식(다)
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private int sal;
	private Integer comm;
	private int deptno;
	
	private Dept dept;//부보(1)
}
