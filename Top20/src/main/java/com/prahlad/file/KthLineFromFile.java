package com.prahlad.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.Map;

import org.apache.commons.io.input.ReversedLinesFileReader;

import com.prahlad.map.HashMap;

public class KthLineFromFile {
	// Getting kth line from the file from bottom
	public static void kthLineReadFromFile(String path,int k) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(path));
			int noOfLines = 0;
			String line = null;
			while( (line = br.readLine() ) != null)
				noOfLines++;
			br.close();
			br = new BufferedReader(new FileReader(path));
			int currentLine = 0;
			while((line=br.readLine())!=null){
				currentLine++;
				if(currentLine == noOfLines - k+1)
					break;
			}
			System.out.println(line);
	
	}
	// Reading file in revere order using apache commons api
	public static void readFileReverseOrder(String path, int k) throws IOException{
		ReversedLinesFileReader rfr = new ReversedLinesFileReader(new File(path),Charset.defaultCharset());
		int reverseLineNo = 0;
		String line;
		while((line = rfr.readLine()) != null){
			//System.out.println(line);
			if(reverseLineNo == k-1){
				break;
			}
			reverseLineNo++;
		}
		System.out.println(line);
		rfr.close();
	}
	// Reading file and maintain cache data with offset values in data structure
	// Going directly to offset to read the line
	// Using RandomAccessFile
	public static void readFileMaintainCacheOffset(String path,int k) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(path, "r");
		String line;
		Map<Long,Long> line_index = new java.util.HashMap<>();
		long lineNo = 1;
		line_index.put(lineNo, 0L);
		while((line = raf.readLine()) !=null){
			//System.out.print(line +"\t"+raf.getFilePointer());
			line_index.put(lineNo++, raf.getFilePointer());
		}
		System.out.println(line_index);
		System.out.println("Total lines: " + lineNo);
		raf.seek(line_index.get(lineNo - k));
		System.out.println(raf.readLine());
		raf.close();
	}
	public static void main(String[] args) throws IOException {
		int k = Integer.parseInt(args[1]);
		kthLineReadFromFile(args[0], k);
		readFileReverseOrder(args[0], k);
		readFileMaintainCacheOffset(args[0], k);
	}

}
