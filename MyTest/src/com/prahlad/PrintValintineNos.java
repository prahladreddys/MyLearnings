package com.prahlad;

public class PrintValintineNos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Printing");
		print(100);
	}

	private static void print(int n) {
		for(int i=1;i<n;i++){
			if(i % 10 == 0){
				System.out.print((i-3) +","+(i-2)+","+(i-1)+",");
			}
		}
		
	}

}
