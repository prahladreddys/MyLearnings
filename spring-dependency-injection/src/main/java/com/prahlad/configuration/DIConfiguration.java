package com.prahlad.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.prahlad.di.service.EmailService;
import com.prahlad.di.service.MessageService;

@Configuration
@ComponentScan(value={"com.prahlad.di.consumer"})
public class DIConfiguration {
	@Bean
	public MessageService getMessageService(){
		return new EmailService();
	}
}
