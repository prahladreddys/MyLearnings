package com.prahlad.di.service;

public class EmailService implements MessageService{

	@Override
	public boolean sendMessage(String message, String receiver) {
		System.out.println("Sending email message : "+ message + "to :"+receiver);
		return false;
	}

}
