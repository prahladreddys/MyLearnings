package com.prahlad.hackerrank;

import java.util.Scanner;

public class Kangaroo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = kangaroo1(x1, v1, x2, v2);
        System.out.println(result);
        in.close();
	}

	private static String kangaroo(int x1, int v1, int x2, int v2) {
		String out = "NO";
		if(x2 > x1 && v2 > v1)
			return out;
		int k1 = x1 + v1;
		int k2 = x2 + v2;
		while(true){
			k1 = k1+v1;
			k2 = k2+v2;
			if(k1 == k2){
				out = "YES";
				break;
			} 
		}
		return out;
	}
	private static String kangaroo1(int x1,int v1,int x2,int v2){
		if(v1 < v2) return "NO";
        if(x1 < x2 && v1 > v2) {
            int xDiff = Math.abs(x1 - x2);
            int vDiff = Math.abs(v1 - v2);
            if(xDiff % vDiff == 0) {
                return "YES";
            } else {
                return "NO";
            }
        }
        return "NO";
	}

}
