package com.prahlad.di.consumer;

import com.prahlad.di.service.MessageService;

public class MyXMLApplication {
	private MessageService service;
	
	public void setService(MessageService srv){
		this.service = srv;
	}
	public boolean processMessage(String msg,String rcv){
		return this.service.sendMessage(msg, rcv);
	}
}
