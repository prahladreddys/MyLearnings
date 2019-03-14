package com.test.dependencyinjection;

public class WithoutDI {
	public static void main(String[] args) {
		MyApplication app = new MyApplication();
		app.processMessage("HI", "psankepally@gmail.com");
	}
}
class EmailService1 {
	public void sendMessage(String message,String receiver){
		System.out.println("Sending : "+ message+" to the : "+ receiver);
	}
}
class MyApplication{
	private EmailService1 email = new EmailService1();
	
	public void processMessage(String message,String receiver){
		email.sendMessage(message, receiver);
	}
	
}