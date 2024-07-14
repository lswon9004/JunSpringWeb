package com.spring.movie.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.movie.command.MovieInfo;
import com.spring.movie.command.MovieList;

@Controller
public class MovieBoxController {
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/boxOffice/oneday")
	public String getMovie(Model m) {
		//String uri = "https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20240618";
		URI uri = UriComponentsBuilder
                .fromUriString("http://www.kobis.or.kr")
                .path("/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json")
                .queryParam("key","f5eef3421c602c6cb7ea224104795888")
                .queryParam("targetDt","20240619")
                .encode()
                .build()
                .toUri();
		
		MovieList list = restTemplate.getForObject(uri, MovieList.class);
		m.addAttribute("boxOfficeList", list);
		return "movie/boxOffice";
	}
	@GetMapping("/boxOffice/movienifo/{movieCd}")
	public String dm(@PathVariable("movieCd") String movieCd, Model m) {
		String uri ="https://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=f5eef3421c602c6cb7ea224104795888&movieCd=";
		uri += movieCd;
		MovieInfo list = restTemplate.getForObject(uri, MovieInfo.class);
		m.addAttribute("movieInfo", list);
		return "movie/movieInfo";
	}
}
