package com.prahlad;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestNew {
	public static void main(String[] args) throws IOException {
		for(int i=0;i<10;i++)
			System.out.println((Integer)i);
		
		String s = "CC%2F%2F";
		System.out.println(URLDecoder.decode(s,"UTF-8"));
		File f = new File("D:\\dwnload_new\\1.csv");
		f.createNewFile();
		
		String content = "Hello World !!";
		Files.write(Paths.get(f.getAbsolutePath()), content.getBytes());
	}

}
