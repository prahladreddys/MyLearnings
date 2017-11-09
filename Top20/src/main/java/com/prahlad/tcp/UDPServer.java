package com.prahlad.tcp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

	public static void main(String[] args) throws IOException, InterruptedException {
		DatagramSocket serverSocket = new DatagramSocket(9876);
		
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\spooldir\\siem_udpdata.txt"))) {

			int i = 0;
			// DataOutputStream outToClient = new
			// DataOutputStream(socket.getOutputStream());
			do{
				byte[] receiveData = new byte[2048];
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				serverSocket.receive(receivePacket);
				String line = new String(receivePacket.getData());
				System.out.println(line);
				bw.write(line);
				bw.newLine();
				System.out.println("Done");
				bw.flush();
				i++;
			} while (i < 500);
			
			
			
			// outToClient.writeBytes(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			serverSocket.close();
		}
	}

}
