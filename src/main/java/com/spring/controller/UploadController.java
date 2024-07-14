package com.spring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spring.dto.FileinfoDto;
import com.spring.service.FileinfoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class UploadController {

	@Autowired
	FileinfoService service;

	@GetMapping("/filedownload/{fileid}")
	public void fileDownload(@PathVariable("fileid") int id, HttpServletResponse response) throws IOException {

		FileinfoDto dto = service.fileOne(id);
		String path = null;
		path = ResourceUtils.getFile("classpath:static").toPath().toString();
		File file = new File(path, dto.getPath());

		String fileName = new String(dto.getName().getBytes("utf-8"), "iso-8859-1");

		response.setContentType("application/octet-stream; charset=utf-8");
		// 응답결과의 리턴 타입 - application/octet-stream가 다운로드 타입임
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
		// attachment : 보여줄수 있는 형식의 파일도 무조선 다운로드
		// filename : 다운로드 받을 파일명 지정
		response.setHeader("Content-Transfer-Encoding", "binary");

		OutputStream out = response.getOutputStream();

		try (FileInputStream fis = new FileInputStream(file);) {
			FileCopyUtils.copy(fis, out);
		} catch (IOException ex) {
			System.out.println("파일 없음");
		}

		out.flush();
	}

	@GetMapping("/list")
	public String list(Model m) {
		List<FileinfoDto> fList = service.fileList();
		m.addAttribute("fList", fList);
		return "file/list";
	}

	@GetMapping("/upload")
	public String form() {
		return "file/fileform";
	}

	@PostMapping("/upload")
	public String submit(@ModelAttribute("dto") FileinfoDto dto, @RequestParam("file") MultipartFile file, Model m) {
		if (!file.getOriginalFilename().equals("")) {
			String fileName = upload(file);

			dto.setName(file.getOriginalFilename());
			dto.setPath("/upload/" + fileName);
			dto.setFilesize(file.getSize());

			service.insertFile(dto);

		}
		return "file/result";
	}

	private String upload(MultipartFile file) {

		String fileName = makeName(file.getOriginalFilename());
		File f = null;
		try {
			String path = ResourceUtils.getFile("classpath:static/upload/").toPath().toString();

			f = new File(path, fileName);
			System.out.println(f.getPath());
			file.transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}

	private String makeName(String oName) {
		long currentTime = System.currentTimeMillis();
		Random random = new Random();
		int r = random.nextInt(50);// 0 ~ 49
		int index = oName.lastIndexOf(".");
		String ext = oName.substring(index + 1);

		return currentTime + "_" + r + "." + ext;
	}
}