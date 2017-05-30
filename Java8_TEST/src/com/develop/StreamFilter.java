package com.develop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamFilter {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("c");
		list.add("c#");
		list.add("ASP");
		list.add("PHP");
		list.add("java");
		
		Stream<String> stream = list.stream();
		
		stream.parallel().forEach(l -> System.out.println(l));
		
		System.out.println("After filtering");
		//Filter function
		stream = list.stream().filter(p -> p.length() > 2);
		
		String[] arr = stream.toArray(String[]::new);
		System.out.println(Arrays.toString(arr));
	}

}
