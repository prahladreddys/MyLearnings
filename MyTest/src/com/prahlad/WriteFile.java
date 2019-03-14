package com.prahlad;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		writeToFile();
		writeTofile_java8();
	}

	private static void writeTofile_java8() {
		String data = "Writing to file";
		try {
			Files.write(Paths.get("D:/spooldir/squid/2.txt"), data.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void writeToFile() {
		String data = "writing to file";
		try(BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\spooldir\\squid\\1.txt"))){
			bw.write(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
