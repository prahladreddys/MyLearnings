package com.prahlad.hackerrank;

import java.util.Scanner;

public class GradingStudents {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] in = new int[n];
		for(int i=0;i<n;i++)
			in[i] = s.nextInt();
		int[] result = updateGrades(in);
		for(int i=0;i<n;i++)
			System.out.print(result[i]+ (i != result.length - 1 ? "\n" : ""));
		s.close();
	}

	private static int[] updateGrades(int[] grades) {
		int[] result = new int[grades.length];
		for(int i=0;i<grades.length;i++){
			if(grades[i] < 38){
				result[i] = grades[i];
			} else {
				int div = ((grades[i]/5)+1)*5;
				int diff = div - grades[i]; 
				if(diff < 3){
					result[i] = grades[i] + diff;
				} else {
					result[i] = grades[i];
				}
			}
		}
		return result;
	}

	

}
