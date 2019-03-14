package com.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {
	
	@RequestMapping("/note")
	public String welcome(){
		return "Welcome to Rest World";
	}
	
	@RequestMapping("/ping1")
	public String ping(){
		return "pong from rest service";
	}
}
