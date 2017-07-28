package com.prahlad.graph;

public class ExploreAllPathsInGraph {
	public static void exploreAllPaths(int[][] in,int u,int v){
		boolean[] visit = new boolean[in.length];
		auxPaths(in,u,v,visit,""+u);
	}
	private static void auxPaths(int[][] in,int u,int v,boolean[] visit,String path){
		if(u == v) {
			System.out.println(path);
			return;
		}
		visit[u] = true;
		for(int w=0;w<in.length;w++){
			if(in[u][w] == 1 && visit[w] == false){
				auxPaths(in,w,v,visit,path+"->"+w);
			}
		}
		visit[u] = false;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		//int[][] in = GraphUtils.createCompleteGraph(n);
		int[][] in = GraphUtils.createRandomGraph(n);
		GraphUtils.displayGraph(in);
		exploreAllPaths(in, 0, n-1);
	}

}
