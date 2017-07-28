package com.prahlad.graph;

public class Connectivity {
	public static boolean isConnected1(int[][] in, int u, int v){
		boolean[] visit = new boolean[in.length];
		return auxConnected1(in,u,v,visit);
	}
	private static boolean auxConnected1(int[][] in, int u, int v, boolean[] visit) {		
		if(u == v) return true;
		visit[u] = true;
		for(int w=0;w<in.length;w++){
			if(in[u][w] == 1 && visit[w] == false){
				if(auxConnected1(in, w, v, visit)){
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[][] in = GraphUtils.createRandomGraph(n);
		GraphUtils.displayGraph(in);
		System.out.println(isConnected1(in, 0, n-1));
	}

}
