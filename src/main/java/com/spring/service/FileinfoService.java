package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.FileinfoDao;
import com.spring.dto.FileinfoDto;



@Service
public class FileinfoService {
	@Autowired
	FileinfoDao dao;
	
	public int insertFile(FileinfoDto file) {
		System.out.println("전"+file.getFileid());
		int x = dao.insertFile(file);
		System.out.println("후"+file.getFileid());
		return x;
	}
	public List<FileinfoDto>  fileList(){
		return dao.fileList();
	}
	public FileinfoDto fileOne(int fileid) {
		return dao.fileOne(fileid);
	}
}