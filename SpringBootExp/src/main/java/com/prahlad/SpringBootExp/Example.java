package com.prahlad.SpringBootExp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class Example {
	@RequestMapping("/")
    String home() {
        return "Hello World!";
    }
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		SpringApplication.run(Example.class, args);
		Thread.currentThread().join();
	}

}
