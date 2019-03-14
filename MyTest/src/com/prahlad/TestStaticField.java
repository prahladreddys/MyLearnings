package com.prahlad;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestStaticField {
	
	public static String val;
	
	static {
		val = "one";
	}

	public static void main(String[] args) {
		System.out.println(val);
		val = "two";
		System.out.println(val);
		Path p = Paths.get("D:/spooldir/splunk/p.txt");
		System.out.println(356701/1000);
		try(BufferedWriter bw = Files.newBufferedWriter(p)){
			bw.write("asdasas");
			bw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
