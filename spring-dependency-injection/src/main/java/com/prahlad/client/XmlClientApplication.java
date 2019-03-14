package com.prahlad.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.prahlad.di.consumer.MyXMLApplication;

public class XmlClientApplication {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MyXMLApplication app = context.getBean(MyXMLApplication.class);
		app.processMessage("hi", "p@gmail.com");
		context.close();
	}
}
