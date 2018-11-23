package com.prahlad.rest.service;


import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		return RandomStringUtils.randomAlphabetic(10);
	}
	public static void main(String[] args) {
		SimpleService m = new SimpleService();
		System.out.println(m.getNext());
	}
	@RequestMapping(value="/companies",method=RequestMethod.GET,produces="application/json")
	public String getCom(@RequestParam(value="city",defaultValue="hyd") String city){
		return "welcome "+city;
	}
}
