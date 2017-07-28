package com.prahlad.intv;

public class GridDisplay {
	private static int[][] prepare(int n) {
		int[][] in = new int[n][n];
		int d = 1;
		int i;
		int j;
		int offset = 0;
		while (offset < 2) {
			i = j = offset;
			for (; j < n; j++) {
				//System.out.println("i: " + i + " , j: "+ j);
				in[i][j] = d++;
			}
			
			for (i = offset; i < n; i++) {
				System.out.println("i: " + i + " , j: "+ j);
				in[i][j - 1] = d++;
			}

			//System.out.println("i: " + i + " , j: " + j);
			j = j - 2;
			for (; j >= 0; j--) {
				in[i - 1][j] = d++;
			}
			i = i - 2;
			j = 0;
			for (; i >= 1; i--) {
				in[i][j] = d++;
			}
			//System.out.println("i: " + i + " , j: " + j);
			offset++;
			n--;
		}
		return in;
	}

	private static int[][] prepare1(int n) {
		int[][] in = new int[n][n];
		int d = 1;
		auxPrep(in, 0, 0, d);
		return in;
	}

	private static void auxPrep(int[][] in, int i, int j, int d) {
		if (i == in.length - 1 || j == in.length - 1) {
			in[i][j] = d;
			return;
		}

		auxPrep(in, i + 1, j, d);
		auxPrep(in, i, j + 1, d);
	}

	private static void display(int[][] in) {
		for (int i = 0; i < in.length; i++) {
			for (int j = 0; j < in.length; j++) {
				System.out.print(in[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[][] in = prepare(n);
		display(in);
	}

}
