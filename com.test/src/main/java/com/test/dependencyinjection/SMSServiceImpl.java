package com.test.dependencyinjection;

public class SMSServiceImpl implements MessageService{

	@Override
	public void sendMessage(String message, String receiver) {
		System.out.println("Sending SMS : "+ message +"to : "+ receiver);
	}
	

}
