package com.prahlad.di.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prahlad.di.service.MessageService;

@Component
public class MyApplication {
	//field-based dependency injection
	//@Autowired
	MessageService service;
	
	@Autowired
	public void setService(MessageService svc){
		this.service=svc;
	}
	
	public boolean processMessage(String msg, String rec){
		//some magic like validation, logging etc
		return this.service.sendMessage(msg, rec);
	}
}
