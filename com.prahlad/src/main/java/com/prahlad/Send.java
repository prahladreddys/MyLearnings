package com.prahlad;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.AMQP.Exchange;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.GetResponse;

public class Send {
	public static void main(String[] args) throws IOException, TimeoutException {
		send();
		receiv();
	}

	private static void send() throws IOException, TimeoutException {
		ConnectionFactory cf = new ConnectionFactory();
		cf.setHost("localhost");
		Connection con = cf.newConnection();
		Channel channel = con.createChannel();
		channel.exchangeDeclare("direct-exchange-example", "Direct");
		String message = "Hi vidit";
		channel.basicPublish("direct-exchange-example", "", null, message.getBytes());
		System.out.println(" [x] Sent '" + message + "'");

		channel.close();
		con.close();
	}

	private static void receiv() throws IOException, TimeoutException {
		System.out.println("Receiving..");
		ConnectionFactory cf = new ConnectionFactory();
		cf.setHost("localhost");
		Connection con = cf.newConnection();
		Channel channel = con.createChannel();
		channel.queueDeclare("hello-world-queue", false, false, false, null);
		GetResponse res = channel.basicGet("hello-world-queue", true);
		String message = res.getBody().toString();
		System.out.println(message);
		System.out.println("Message:: "+ res.toString());
//		Consumer consumer = new DefaultConsumer(channel) {
//			@Override
//			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
//					byte[] body) throws IOException {
//				String message = new String(body, "UTF-8");
//				System.out.println(" [x] Received '" + message + "'");
//			}
//		};
//		channel.basicConsume("MyQueue", true,consumer);
		channel.close();
		con.close();
		System.out.println("Done");
	}

}
