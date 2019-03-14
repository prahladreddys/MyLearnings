package com.prahlad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@ComponentScan(basePackages="com.prahlad.app.controller")
public class FirstApp {
	
    @RequestMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String home() {
        return "Nothing here. Go to <a href='/welcome'>/sample</a>";
    }
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(FirstApp.class, args);	
		Thread.currentThread().join();
	}

}
