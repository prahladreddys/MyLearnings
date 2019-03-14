package com.prahlad;

import java.io.File;

public class TestFileName {
	public static void main(String[] args) {
		String folderName = "D:/spooldir/splunk/090318/15032018_0230_UTC/32f1790b-4146-4375-b174-88c49df61950.log";
		
		System.out.println(new File(folderName).getParent());
	}
}
