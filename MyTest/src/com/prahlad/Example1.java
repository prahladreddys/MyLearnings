package com.prahlad;

public class Example1 {

	public static void main(String[] args) {
		String str1 = "Java";
		String str2 = "Java";
		System.out.println("----- Creating strings str1 & str2 using string literal -----");
		System.out.println("str1 == str2 is " + (str1 == str2));
		System.out.println("str1.equals(str2) is " + str1.equals(str2));

		String str3 = new String("Java");
		String str4 = new String("Java");
		System.out.println("----- Creating strings str3 & str4 using new operator -----");
		System.out.println("str3 == str4 is " + (str3 == str4));
		System.out.println("str3.equals(str4) is " + str3.equals(str4));

		String str5 = "Jav" + "a";
		String str6 = "Ja" + "va";
		System.out.println("----- Creating strings str5 & str6 using string constant expression -----");
		System.out.println("str5 == str6 is " + (str5 == str6));
		System.out.println("str5.equals(str6) is " + str5.equals(str6));

		String s = "a";
		String str7 = "Jav" + s;
		String str8 = "Ja" + "va";
		System.out.println("----- String str7 is computed at runtime -----");
		System.out.println("----- Creating string str8 using string constant expression -----");
		System.out.println("str7 == str8 is " + (str7 == str8));
		System.out.println("str7.equals(str8) is " + str7.equals(str8));
		
		
		String s1 = "Java";
        String s2 = new StringBuffer("Ja").append("va").toString();
        String s3 = s2.intern();
        System.out.println("----- Creating string str1 using string literal -----");
        System.out.println("----- Creating string str2 using new operator -----");
        System.out.println("----- Creating string str3 using intern method -----");
        System.out.println("s1 == s2 is " + (s1 == s2));
        System.out.println("s1 == s3 is " + (s1 == s3));
	}
}
