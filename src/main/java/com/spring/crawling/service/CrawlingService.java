package com.spring.crawling.service;

//import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.spring.crawling.command.BibleCommand;
import com.spring.crawling.command.NewsCommand;

import jakarta.servlet.http.HttpServletRequest;
import kr.solde.DownloadBroker;

@Service
public class CrawlingService {
	public BibleCommand crawling2(String bible, HttpServletRequest request ) {
		BibleCommand command = new BibleCommand();
		String url = "https://sum.su.or.kr:8888/bible/today/Ajax/Bible/BosyMatter?qt_ty=QT1";
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			url = url + "&Base_de=" + bible + "&bibleType=1";
			System.out.println("================================");
			Document doc = Jsoup.connect(url).post();
			Element bible_text = doc.select(".bible_text").first();
			command.setBible_text(bible_text.text());

			Element bibleinfo_box = doc.select(".bibleinfo_box").first();
			command.setBibleinfo_box(bibleinfo_box.text());
		
			Elements liList = doc.select(".body_list > li");
			for (Element li : liList) {
				String n = li.select(".num").first().text() + ":";
				String text =  li.select(".info").first().text();
				command.getLiList().add(n + text);
			}
			// 리소스 다운로드(mp3, image)
			/*
			 * Element tag=doc.select("source").first(); String
			 * dPath=tag.attr("src").trim(); //
			 * http://meditation.su.or.kr/meditation_mp3/2019/20191010.mp3 String
			 * fileName=dPath.substring(dPath.lastIndexOf("/")+1);
			 */
			Element tag = doc.select(".img > img").first();
			String dPath = "https://sum.su.or.kr:8888" + tag.attr("src").trim();
			System.out.println(dPath); // https://sum.su.or.kr:8888/attach/X07/2c06c62f3695489a8ff525a6ed138395.jpg
			String fileName = dPath.substring(dPath.lastIndexOf("/") + 1);
			String path = request.getServletContext().getRealPath("/mainImg/"); //webapp안에 mainImg폴더 생성
			System.out.println(path+fileName);
			command.setFilename(fileName);
			Runnable r = new DownloadBroker(dPath, path+fileName);
			Thread dLoad = new Thread(r);
			dLoad.start();
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.print("" + (i + 1));
			}
			System.out.println();
			System.out.println("===============================");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return command;
	}
	public List<NewsCommand> crawling(){
		String url = "https://sports.news.naver.com/wfootball/index";
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements element = doc.select("div.home_news");
		List<NewsCommand> list = new ArrayList<>();
		for(Element li : element.select("li")) {
			NewsCommand news = new NewsCommand(li.text(), li.select("a").attr("href"));
			list.add(news);
		}
		
		return list;
	}

}
