package com.prahlad;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FilesMove {

	public static void main(String[] args) {
		Path movefrom = FileSystems.getDefault().getPath("D:\\dwnload_new\\Macfee22.txt");
		Path to = FileSystems.getDefault().getPath("D:\\dwnload_new\\12312312312.txt");
		Path target_dir = FileSystems.getDefault().getPath("");
		//method 1
        try {
            Files.move(movefrom, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println(e);
        }

	}

}
