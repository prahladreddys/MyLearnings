package com.prahlad;

public class ExcelColumnName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findExcelColumnTitle(26);
		findExcelColumnTitle(27);
		int n = 101 % 20;
		System.out.println(n);
	}

	private static void findExcelColumnTitle(int n) {
		StringBuilder sb = new StringBuilder();
		while(n>0){
			n--;
			char ch = (char)(n%26+'A'); // 25%26 + 65 = 90 , char at 90 values is 'Z'
			n/=26;
			sb.append(ch);
		}
		char ch1 = (char)65;
		System.out.println(ch1);
		System.out.println(sb.toString());
	}

}
