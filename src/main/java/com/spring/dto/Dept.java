package com.spring.dto;

import lombok.Data;

@Data
public class Dept {//클래스명 == 테이블명
	private int deptno;//변수명 == 컬럼명
	private String dname;
	private String loc; 
}