package com.prahlad.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {

	public static void main(String[] args) {
		try{
			Socket clientSocket = null;
			BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
			clientSocket = new Socket("127.0.0.1",8001);
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			while(true){				
				String sentence = inFromUser.readLine();
				outToServer.writeBytes(sentence + '\n');
				String modifiedSentence = inFromServer.readLine();
				System.out.println("FROM SERVER: " + modifiedSentence);
				clientSocket.close();
			}
		
		
		} catch(Exception e){
			
		}
	}

}
