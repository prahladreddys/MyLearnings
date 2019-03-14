package com.prahlad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipTest {
	private static final DateTimeFormatter dtm = DateTimeFormatter.ofPattern("yyyy-MM-dd_HHmm");
	public static void main(String[] args) {
		String folderName = "D:\\log\\test\\t1\\processed_logs";
		createZip(folderName,new File(folderName));
	}

	private static void createZip(String folderName,File dir) {
		 try {
	            List<String> filesListInDir = populateFilesList(dir);
	            //now zip files one by one
	            //create ZipOutputStream to write to the zip file
	            FileOutputStream fos = new FileOutputStream(folderName+"_"+dtm.format(LocalDateTime.now())+".zip");
	            ZipOutputStream zos = new ZipOutputStream(fos);
	            for(String filePath : filesListInDir){
	                System.out.println("Zipping "+filePath);
	                //for ZipEntry we need to keep only relative file path, so we used substring on absolute path
	                ZipEntry ze = new ZipEntry(filePath.substring(dir.getAbsolutePath().length()+1, filePath.length()));
	                zos.putNextEntry(ze);
	                //read the file and write to ZipOutputStream
	                FileInputStream fis = new FileInputStream(filePath);
	                byte[] buffer = new byte[1024];
	                int len;
	                while ((len = fis.read(buffer)) > 0) {
	                    zos.write(buffer, 0, len);
	                }
	                zos.closeEntry();
	                fis.close();
	            }
	            zos.close();
	            fos.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

	private static List<String> populateFilesList(File dir) {
		File[] files = dir.listFiles();
		List<String> filesListInDir = new ArrayList<String>();
        for(File file : files){
            if(file.isFile()) filesListInDir.add(file.getAbsolutePath());
            else populateFilesList(file);
        }
		return filesListInDir;
	}

}
