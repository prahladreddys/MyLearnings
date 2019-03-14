package com.prahlad;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;

public class FileDirectoryStreamer {

	public static void main(String[] args) throws IOException, InterruptedException {
//		Files.newDirectoryStream(Paths.get(args[0]), path -> path.toFile().isFile()).forEach(System.out::println);
//		Thread.sleep(60000);
		readDir(args[0]);
	}

	private static void readDir(String dir) throws IOException, InterruptedException {
		try(DirectoryStream<Path> dirStream = Files.newDirectoryStream(Paths.get(dir))){
			Iterator<Path> it = dirStream.iterator();
			while(it.hasNext()){
				System.out.println(it.next());
			}			
		} finally{
			FileUtils.deleteDirectory(new File(dir));
		}
		//Thread.sleep(60000);
	}

}
