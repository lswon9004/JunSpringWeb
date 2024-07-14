package com.spring.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.crawling.command.BookSearchResult;
import com.spring.crawling.command.Item1;
import com.spring.crawling.service.ExcelService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ExcelController {

	@Autowired
	ExcelService ser;

	@GetMapping("/crawling/title")
	public void form() {
	}

	@GetMapping("/crawling/bookExcel")
	public void bookExcel(@RequestParam("d_titl") String d_titl, HttpServletResponse response, Model m2) {
		BookSearchResult re = ser.bookExcel(d_titl);
		m2.addAttribute("re", re);
		m2.addAttribute("d_titl", d_titl);
		String fileName = "";
		try {
			fileName = new String((d_titl + "_검색.xlsx").getBytes("utf-8"), "iso-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 엑셀파일 다운로드 설정
		response.setContentType("ms-vnd/excel");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");

		Workbook workbook = new SXSSFWorkbook(); // excel문서
		Sheet sheet = workbook.createSheet(d_titl);
		Row row = null;
		Cell cell = null;
		int rowNum = 0;

		// Header
		row = sheet.createRow(rowNum++);
		cell = row.createCell(0);
		cell.setCellValue("title");
		cell = row.createCell(1);
		cell.setCellValue("link");
		cell = row.createCell(2);
		cell.setCellValue("author");
		cell = row.createCell(3);
		cell.setCellValue("publisher");
		cell = row.createCell(4);
		cell.setCellValue("pubdate");
		cell = row.createCell(5);
		cell.setCellValue("isbn");
		cell = row.createCell(6);
		cell.setCellValue("image");

		// Body
		for (Item1 m : re.getItems()) {
			row = sheet.createRow(rowNum++);

			cell = row.createCell(0);
			cell.setCellValue(m.getTitle());

			cell = row.createCell(1);
			cell.setCellValue(m.getLink());

			cell = row.createCell(2);
			cell.setCellValue(m.getAuthor());

			cell = row.createCell(3);
			cell.setCellValue(m.getPublisher());

			cell = row.createCell(4);
			cell.setCellValue(m.getPubdate());

			cell = row.createCell(5);
			cell.setCellValue(m.getIsbn());

			// cell = row.createCell(6);

			try {
				//웹주솔 이미지 가져옴
				URL url = new URL(m.getImage());
				InputStream is = url.openStream();
				byte[] bytes = IOUtils.toByteArray(is);
				//엑셀 문서에 이미지 추가
				int pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
				is.close();
				CreationHelper helper = workbook.getCreationHelper();
				Drawing<?> drawing = sheet.createDrawingPatriarch();
				ClientAnchor anchor = helper.createClientAnchor();
				// 이미지 출력할 셀 위치
				anchor.setCol1(6);
				anchor.setRow1(rowNum - 1);
				anchor.setCol2(7);
				anchor.setRow2(rowNum);

				drawing.createPicture(anchor, pictureIdx);
				//셀 크기 조절
				cell = row.createCell(6);
				int w = 20 * 256;
				sheet.setColumnWidth(1, w);

				short h = 120 * 20;
				cell.getRow().setHeight(h);

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		// Excel File Output
		try {
			workbook.write(response.getOutputStream());
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



}
