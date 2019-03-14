package com.prahlad;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("D:\\log\\pan\\resmade");
		List<File> list = new ArrayList<>();
		list.add(f);
		
		System.out.println(list);
	}

}
