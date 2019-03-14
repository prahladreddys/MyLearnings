package com.prahlad;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SSLPoke {

	public static void main(String[] args) {
		if(args.length != 2){
			System.out.println("Usage:" + SSLPoke.class.getName() + " <host> <port>");
			System.exit(1);
		}
		try{
			SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
			SSLSocket socket = (SSLSocket) sslSocketFactory.createSocket(args[0], Integer.parseInt(args[1]));
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			out.write(1);
			while(in.available() >0){
				System.out.println(in.read());
			}
			System.out.println("Successfully Connected.");
		} catch(Exception e){
			e.printStackTrace();
		}

	}

}
