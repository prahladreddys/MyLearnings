package com.intv;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoverControl {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int matrixSize = s.nextInt();
		int commandSize = s.nextInt();
		List<String> cmds = new ArrayList<>();
		for(int i=0;i<=commandSize;i++){
			cmds.add(s.nextLine());
		}
		s.close();
		int result = roverMove(matrixSize,cmds);
		System.out.println(result);
	}

	private static int roverMove(int matrixSize, List<String> cmds) {
		int currentPosition = 0;
		for(String c:cmds){
			if(!isEdgeCellDirection(c)){
				currentPosition = moveInDirection(c,currentPosition,matrixSize);
			}
		}
		return currentPosition;
	}

	private static boolean isEdgeCellDirection(String c) {
		
		return false;
	}

	private static int moveInDirection(String c, int currentPosition, int matrixSize) {
		switch (c) {
		case "up": currentPosition = currentPosition - matrixSize;
			break;
		case "down": currentPosition = currentPosition + matrixSize;
			break;
		case "left": ++ currentPosition;
			break;
		case "right": --currentPosition;
			break;
		}
		return currentPosition;
	}

}
