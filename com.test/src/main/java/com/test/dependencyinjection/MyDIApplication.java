package com.test.dependencyinjection;

public class MyDIApplication implements Consumer{
	MessageService service;
	public MyDIApplication(MessageService srv) {
		this.service = srv;
	}
	@Override
	public void processMessage(String message, String receiver) {
		this.service.sendMessage(message, receiver);
	}

}
