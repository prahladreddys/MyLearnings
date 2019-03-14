package com.prahlad.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.prahlad.configuration.DIConfiguration;
import com.prahlad.di.consumer.MyApplication;

public class ClientApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfiguration.class);
		MyApplication app = context.getBean(MyApplication.class);
		app.processMessage("hi", "p@gmail.com");
		context.close();
	}
}
