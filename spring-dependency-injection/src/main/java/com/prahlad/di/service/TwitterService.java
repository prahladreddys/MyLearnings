package com.prahlad.di.service;

public class TwitterService implements MessageService{

	@Override
	public boolean sendMessage(String message, String receiver) {
		System.out.println("Sending twitter message: "+ message + "to: "+ receiver);
		return false;
	}

}
