package com.prahlad;

public class TestLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		outer: 	    
			for(int i = 0; i < 3; i++) 
			{
				for(int j = 3; j <= 0; j--) 
				{
					 if(i == j) continue outer;
					 System.out.println(i + " " + j);
				}
			}

	}

}
