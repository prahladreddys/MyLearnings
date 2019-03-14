package com.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SomeController {
	
	@RequestMapping("/ping")
	public String ping(){
		return "pong from api controller";
	}

}
