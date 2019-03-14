package com.prahlad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author CipherCloud
 *
 */
/*
 * i/p : 
 * 2 4 3
 * 2 1 5
 * 1 4 6
 * 
 * o/p: 20
 */
public class FindMaxApples {

	public static void main(String[] args) throws IOException {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int rows = Integer.parseInt(br.readLine());
			int columns = Integer.parseInt(br.readLine());
			int[][] array = new int[rows][columns];
			for(int i=0;i<rows;i++){
				String value = br.readLine();
				String[] values = value.split("\\s");
				if(values.length != columns)
					System.exit(1);
				for(int j=0;j<values.length;j++)
					array[i][j] = Integer.parseInt(values[j]);
			}
			int[][] m = new int[rows][columns];
			for(int i=0;i<rows;i++){
				for(int j=0;j<columns;j++){
					System.out.print(array[i][j]+" ");
					if(i >0 && j>0){
						m[i][j] = Math.max(array[i-1][j], array[i][j-1])+array[i][j];
					} else if( j >0) {
						m[i][j] = array[i][j-1]+array[i][j];
					} else if( i >0){
						m[i][j] = array[i-1][j]+array[i][j];
					} else {
						m[i][j] = array[i][j];
					}
						
				}
				System.out.println();
			}
			
			for(int i=0;i<rows;i++){
				for(int j=0;j<columns;j++){
					System.out.print(m[i][j]+" ");
					
				}
				System.out.println();
			}
		}
		
	}

}
