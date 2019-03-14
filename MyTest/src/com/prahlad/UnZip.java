package com.prahlad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnZip {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		unzip();
	}

	private static void unzip() throws IOException {
		String fileZip = "C:\\opt\\ciphercloud\\logagent\\wsg\\ford7\\processed_logs\\recognized_6d5cc892-a6ef-439e-9f3a-c8d7d09295c5.zip";
		File f = new File(fileZip);
		System.out.println(f.getAbsolutePath());
		System.out.println(f.getCanonicalPath());
		System.out.println(f.getParent());
		byte[] buffer = new byte[1024];
        ZipInputStream zis = new ZipInputStream(new FileInputStream(f));
        ZipEntry zipEntry = zis.getNextEntry();
        while(zipEntry != null){
            String fileName = zipEntry.getName();
            File newFile = new File(f.getParent()+File.separator+fileName);
            System.out.println("Unzipping to "+newFile.getAbsolutePath());
            FileOutputStream fos = new FileOutputStream(newFile);
            int len;
            while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            fos.close();
            zipEntry = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();
	}

}
