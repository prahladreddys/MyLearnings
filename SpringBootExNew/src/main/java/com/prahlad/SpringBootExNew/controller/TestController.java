package com.prahlad.SpringBootExNew.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@RequestMapping("/")
	public String getMsg(){
		return "Spring boot is working";
	}
}
