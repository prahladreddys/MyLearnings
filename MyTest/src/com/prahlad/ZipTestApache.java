package com.prahlad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.compress.utils.IOUtils;

public class ZipTestApache {
	private static final DateTimeFormatter dtm = DateTimeFormatter.ofPattern("yyyy-MM-dd_HHmm");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String folderName = "D:\\log\\test\\t1\\processed_logs";
		String outputFile = "D:\\log\\test\\t1\\";
		compressFolder(folderName,outputFile);
	}

	private static void compressFolder(String sourceDir, String outputFile) {
		try {
			ZipOutputStream zipFile = new ZipOutputStream(new FileOutputStream(sourceDir+"_"+dtm.format(LocalDateTime.now())+".zip"));
			 compressDirectoryToZipfile(sourceDir, sourceDir, zipFile); 
			 IOUtils.closeQuietly(zipFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void compressDirectoryToZipfile(String rootDir, String sourceDir, ZipOutputStream out) throws IOException {
		for(File file : new File(sourceDir).listFiles()){
			if(file.isDirectory()){
				compressDirectoryToZipfile(rootDir, sourceDir + File.separator + file.getName(), out);
			} else {
				ZipEntry entry = new ZipEntry(sourceDir.replace(rootDir, "") + file.getName().replace(".log", ".csv"));
				out.putNextEntry(entry);
				FileInputStream in = new FileInputStream(sourceDir + File.separator+file.getName());
				IOUtils.copy(in, out);
	            IOUtils.closeQuietly(in);
	            // Deleting the unrecognized domains file as we have added to zip file
	            Files.deleteIfExists(file.toPath());
			}
		}
	}

}
