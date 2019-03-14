package com.prahlad;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class FolderDelete {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String dirName = "D:\\spooldir\\splunk\\ford7";
		deleteFolder(dirName);
	}

	private static void deleteFolder(String dirName) throws IOException {
		Path rootPath = Paths.get(dirName);
		if(Files.notExists(rootPath, LinkOption.NOFOLLOW_LINKS)){
			return;
		}
		Files.walk(rootPath, FileVisitOption.FOLLOW_LINKS)
		    .sorted(Comparator.reverseOrder())
		    .map(Path::toFile)
		    .forEach(File::delete);
	}

}
