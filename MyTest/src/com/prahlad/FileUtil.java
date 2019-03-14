package com.prahlad;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileUtil {
	public static void main(String[] args) throws IOException {
		System.out.println("Reading file using java 8 streas");
		//readFile();
		//readDirectory();
		readDirectoryUsingDirectoryStream();
	}

	

	private static void readFile(Path fileName) {
		//String fileName = "D:/log/output.txt";
		try(Stream<String> stream = Files.lines(fileName)){
			stream.forEach(FileUtil::getMsg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void getMsg(String s){
		System.out.println(s);
	}
	private static void readDirectory() throws IOException{
		String dirName = "D:/log/syslogs";
		//Files.list(Paths.get(dirName)).forEach(System.out::println);
		Files.list(Paths.get(dirName)).forEach(FileUtil::readFile);
	}
	private static void readDirectoryUsingDirectoryStream() throws IOException {
		String dirName = "D:/tmp/tmp1";
		Files.newDirectoryStream(Paths.get(dirName), path -> path.toFile().isFile()).forEach(System.out::println);
		deleteDir(dirName);
	}



	private static void deleteDir(String dirName) {
		Path path = Paths.get(dirName);
		try {
			Files.delete(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
