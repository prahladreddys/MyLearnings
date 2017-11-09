package com.prahlad.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.commons.lang3.StringUtils;

public class TCPServer {

	public static void main(String[] args) throws InterruptedException, IOException {
		ServerSocket server = new ServerSocket(8001);
		Socket socket = server.accept();
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\spooldir\\siem_tcpdata.txt"))) {
			
			int i =0;
//			DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
				do {
				BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String line = inFromClient.readLine();
				while (StringUtils.isNotBlank(line)) {
					bw.write(line);
					bw.newLine();
					line = inFromClient.readLine();
				} 
				System.out.println("Done");
				bw.flush();
				Thread.sleep(10000);
				i++;
				} while(i <10);
//				outToClient.writeBytes(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			server.close();
		}
		
	}

}
