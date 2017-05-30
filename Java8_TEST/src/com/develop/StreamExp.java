package com.develop;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> li = new ArrayList<>();
		li.add("one");
		li.add("two");
		li.add("three");
		
		li.forEach(i -> System.out.println(i));
		
		Stream<String> st = li.stream();
		st.forEach(System.out::println);
		
		
		String[] arr = { "program", "creek", "is", "a", "java", "site" };
		Stream<String> stream = Stream.of(arr);
		stream.forEach(x -> System.out.println(x));
	}

}
