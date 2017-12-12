package com.prahlad.SpringAnno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.prahlad.SpringAnno")
public class AppConfig {
//	@Bean
//	public Car getCar(){
//		return new Car();
//	}
//	@Bean
//	public Tyre getType(){
//		return new Tyre();
//	}
}
