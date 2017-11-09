package com.prahlad.rest.service;


import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simple")
public class SimpleService {
	@RequestMapping("/ping")
	public String getPingResponse(){
		return "Ping from Simple Service..";
	}
	@RequestMapping("/next")
	public String getNext(){
		return RandomStringUtils.randomAlphabetic(3);
	}
	public static void main(String[] args) {
		SimpleService m = new SimpleService();
		System.out.println(m.getNext());
	}
}
