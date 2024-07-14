package com.spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.Random;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.command.ReportCommand;

@Controller
public class ReportSubmissionController {

//	@Autowired 
//	ResourceLoader resourceLoader;

	@GetMapping("/report/submission")
	public String form() {
		return "report/submissionForm";
	}

	@PostMapping(value = "/report/submitReport1")
	public String submitReport1(@RequestParam("studentNumber") String studentNumber,
			@RequestParam("report") MultipartFile report) {
		printInfo(studentNumber, report);
		System.out.println(upload(report));
		return "report/submissionComplete";
	}

	// f:/upload폴더 생성
	private String upload(MultipartFile tempfile) {
		String fileName = makeName(tempfile.getOriginalFilename());

		File newFile = new File("f:/upload/" + fileName);

		try {
			tempfile.transferTo(newFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return newFile.getPath();
	}

	private String makeName(String oName) {
		long currentTime = System.currentTimeMillis();
		Random random = new Random();
		int r = random.nextInt(50);// 0 ~ 49
		int index = oName.lastIndexOf(".");
		String ext = oName.substring(index + 1);

		return currentTime + "_" + r + "." + ext;
	}

	private void printInfo(String studentNumber, MultipartFile report) {
		System.out.println(studentNumber + "가 업로드 한 파일: " + report.getOriginalFilename());
	}

	@PostMapping("/report/submitReport2")
	public String submitReport2(MultipartHttpServletRequest request, Model m) {
		String studentNumber = request.getParameter("studentNumber");

		MultipartFile report = request.getFile("report");

		// 같은 이름으로 여러개의 파일이 전송되는 겨우
		// List<MultipartFile> flist = request.getFiles("report");
		// 프로젝트 내 mainImg 경로 찾아서 파일 만들고 데이터 이동
		String path = request.getServletContext().getRealPath("/mainImg");
		String newFileName = makeName(report.getOriginalFilename());
		File newFile = new File(path, newFileName);

		try {
			report.transferTo(newFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		m.addAttribute("path", newFileName);
		m.addAttribute("nm", studentNumber);
		return "report/submissionComplete";
	}

	@PostMapping("/report/submitReport3")
	public String submitReport3(ReportCommand command, Model m) {

		String newFileName = makeName(command.getReport().getOriginalFilename());
		File newFile = null;
		
		try {
			String path = ResourceUtils.getFile("classpath:static/upload/").toPath().toString();
			newFile = new File(path, newFileName);
			System.out.println(newFile.getPath());
			command.getReport().transferTo(newFile);
		} catch (IOException | IllegalStateException e) {
			e.printStackTrace();
		}
		if (newFile != null) {
			m.addAttribute("path", newFileName);
		}
		return "report/submissionComplete";
	}
}
