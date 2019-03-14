package com.prahlad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.compress.utils.IOUtils;

public class ZipFile {

	public static void main(String[] args) throws IOException {
		int BUFFER = 2048;
		File f = new File("D:\\opt\\ciphercloud\\logagent\\processedData\\unrecognized_2a3ed22f-ce04-4507-bf25-91cc07e721bb.log");
		System.out.println(f.getName());
		System.out.println(f.getParent());
		FileOutputStream fos = null;
		ZipOutputStream zos = null;
		FileInputStream in = null;
		String zipName = f.getParent()+File.separator+f.getName().replaceAll(".log", "")+".zip";
		try{
			fos = new FileOutputStream(zipName);
			zos = new ZipOutputStream(fos);
    		ZipEntry ze= new ZipEntry(f.getName());
    		zos.putNextEntry(ze);
    		in = new FileInputStream(f);
    		int len;
    		byte data[] = new byte[BUFFER];
    		while ((len = in.read(data)) > 0) {
    			zos.write(data, 0, len);
    		}
    		zos.flush();
    		zos.closeEntry();
		} finally{
			IOUtils.closeQuietly(zos);
			IOUtils.closeQuietly(fos);
			IOUtils.closeQuietly(in);
		}
		System.out.println(new File(zipName).getName());
	}

}
