package baaaaaaaaaakingDog_Dijkstra;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1916_최소비용구하기_인접리스트버전 {
	static class Edge implements Comparable<Edge> {
		int node;
		long weight;

		public Edge(int node, long weight) {
			this.node = node;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Long.compare(this.weight, o.weight);
		}
	}

	static int N;
	static int M;
//	static int adjList[][]
	static LinkedList<Edge>[] adjList;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		adjList = new LinkedList[N + 1];
		
		for(int i=1; i<=N; i++)
			adjList[i] = new LinkedList<>();

		for (int i = 0; i < M; i++) {
			adjList[sc.nextInt()].add(new Edge(sc.nextInt(), sc.nextInt()));
		}

		System.out.println(dijkstra(sc.nextInt(), sc.nextInt()));

	}

	private static long dijkstra(int start, int end) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean visited[] = new boolean[N + 1];

		pq.add(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			if (visited[now.node])
				continue;

			visited[now.node] = true;

			if (now.node == end) {
				return now.weight;
			}

			for (Edge edge: adjList[now.node]) {
				if (!visited[edge.node]) {
					pq.add(new Edge(edge.node, now.weight +edge.weight ));
				}
			}

		}
		return 0;

	}

}