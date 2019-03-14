package com.prahlad;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMQClient {

	public static void main(String[] args) throws JMSException {
		sendMessage();
		receiveMessage();
	}

	private static void sendMessage() throws JMSException {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
		Connection conn = factory.createConnection();
		conn.start();
		Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination dest = session.createQueue("MyQ");
		MessageProducer producer = session.createProducer(dest);
		TextMessage msg = session.createTextMessage();
		msg.setText("HI Hello... prahlad ...\n hi from java client");
		
		producer.send(msg);
		
		System.out.println("Sent: " + msg.getText());
		conn.close();
	}
	private static void receiveMessage() throws JMSException{
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
		Connection conn = factory.createConnection();
		conn.start();
		Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination dest = session.createQueue("MyQ");
		MessageConsumer consume = session.createConsumer(dest);
		Message msg = consume.receive();
		
		if(null != msg){
			TextMessage text = (TextMessage)msg;
			System.out.println(text.getText());
		}
		
		conn.close();
	}
}
