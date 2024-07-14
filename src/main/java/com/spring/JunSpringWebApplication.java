package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
@ComponentScan(basePackages = {"com.spring","com.example"})
public class JunSpringWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(JunSpringWebApplication.class, args);
	}
	@Bean
	HiddenHttpMethodFilter hiddenHttpMethodFilter(){
		return new HiddenHttpMethodFilter();
	}
	// _method 라는 이름으로 전달된 값을 요청방식으로 인식한다.
	@Bean
	RestTemplate restTemplate() {
	    return new RestTemplate();
	}//외부 도메인(server)에서 데이터를 가져오는 용도
}
