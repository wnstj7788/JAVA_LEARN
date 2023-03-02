package baaaaaaaaaakingDog_Dijkstra;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1916_최소비용구하기 {
	static class Edge implements Comparable<Edge>{
		int node;
		int weight;
		public Edge(int node, int weight) {
			super();
			this.node = node;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}
	static int N;
	static int M;
	static int adjList[][];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		adjList = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			adjList[sc.nextInt()][sc.nextInt()] = sc.nextInt();
		}
		
		System.out.println(dijkstra(sc.nextInt(), sc.nextInt()));
		
	}
	
	
	private static int dijkstra(int start, int end) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean visited[] = new boolean[N +1];
		
		
		pq.add(new Edge(start,0));
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			if(visited[now.node]) continue;
			
			visited[now.node] = true;
			
			if(now.node == end) {
				return now.weight;
			}
			
			for(int i = 1; i <= N; i++) {
				if(!visited[i] && adjList[now.node][i] > 0) {
					pq.add(new Edge(i, now.weight+ adjList[now.node][i]));
				}
			}
			
			
		}
		return 0;
		
	}

}
