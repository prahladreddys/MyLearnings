package com.prahlad.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@RequestMapping("/welcome")
	public String welcome(){
		return ".. Welcome to my world..";
	}
	@RequestMapping("/ping")
	public String ping(){
		return ".. Pong from the spring boot application";
	}
}
