package com.prahlad;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class TestSMTPMail {
	public static void main(String[] args) {
		System.out.println("Testing send mail from java standalone");
		sendmail();
	}
	
	    public static void sendmail() {

	        final String username = "";
	        final String password = "";
	        
	       

	        Properties props = new Properties();
	        props.put("mail.smtp.auth", "false");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.debug", "true");
	        props.put("mail.smtp.port", "587");

	        Session session = Session.getInstance(props,
	          new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(username, password);
	            }
	          });
	        session.setDebug(true);

	        try {

	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress("ccclouddisc@gmail.com"));
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("psankepally@ciphercloud.com"));
	            message.setSubject("Testing Subject");
	            message.setText("Dear Mail Crawler,"
	                + "\n\n No spam to my email, please!");

	            Transport.send(message);

	            System.out.println("Done");

	        } catch (MessagingException e) {
	            throw new RuntimeException(e);
	        }
	    }
	
}
