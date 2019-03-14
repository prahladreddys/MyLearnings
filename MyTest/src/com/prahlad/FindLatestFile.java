package com.prahlad;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class FindLatestFile {

	public static void main(String[] args) throws IOException {
		String dirName = "D:\\dwnload_new\\unreco";
		
		Path dir = Paths.get(dirName);
		
//		Optional<Path> latest = Files.list(dir)
//				.filter(f -> Files.isDirectory(f) == false)
//				.filter(f -> f.endsWith(".txt"))
//				.max((f1, f2) -> (int)(f1.toFile().lastModified() - f2.toFile().lastModified()));
		File[] files = new File(dirName).listFiles();
		System.out.println(files.length);
		Optional<Path> latest = Files.list(dir)
										.filter(Files::isRegularFile)
										.filter(f -> f.toString().endsWith(".zip"))
										.max((f1,f2) -> (int)(f1.toFile().lastModified() - f2.toFile().lastModified()));
		
		if(latest.isPresent()){
			System.out.println(latest.get().toString());
		} else {
			System.out.println("No files");
		}
		

	}

}
