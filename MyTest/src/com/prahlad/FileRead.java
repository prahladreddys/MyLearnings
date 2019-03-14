package com.prahlad;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Optional;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

public class FileRead {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		readFile();
	}

	private static void readFile() throws IOException {
		String filePath = "D:/log/squid_regex.txt";
		try(Stream<String> stream = Files.lines(Paths.get(filePath))){
			
			Iterator<String> it = stream.iterator();
			String line = null;
			while(it.hasNext()){
				line = it.next();
				if(StringUtils.isEmpty(line.toString()) || line.startsWith("#") || line.startsWith("$"))
					continue;
				break;
			}
			if(StringUtils.isBlank(line)){
				try (Stream<String> streams = Files.lines(Paths.get(filePath))) {
					line = streams.findFirst().get();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			System.out.println(line);
			
		}
		Path path1 = Paths.get(filePath);
		System.out.println("Absolute:"+path1.toAbsolutePath());
		System.out.println("Name:"+path1.getFileName().toString());
	}
	
}
