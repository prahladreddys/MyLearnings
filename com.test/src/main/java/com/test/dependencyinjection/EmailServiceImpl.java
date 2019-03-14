package com.test.dependencyinjection;

public class EmailServiceImpl implements MessageService{

	@Override
	public void sendMessage(String message, String receiver) {
		System.out.println("Sending : "+ message +" to : "+ receiver);
	}

}
