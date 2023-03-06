import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1916_최소비용구하기_인접핼렬 {
	static class Edge implements Comparable<Edge>{
		int node;
		long weight;
		public Edge(int node, long weight) {
			super();
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
	static int adjList[][];
	static int INF = -1;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		adjList = new int[N+1][N+1];
		
		for (int i = 0; i < N+1; i++) {
			for (int j = 0; j < N+1; j++) {
				adjList[i][j] = INF;
			}
		}
		//입력 값을 초기에 설정하고 지금보다 작은 값이 들어올 때 값을 수정하여 문제 해결 
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			adjList[a][b] = adjList[a][b] == INF ? c : Math.min(adjList[a][b], c);
		}
		
		//print();
		
		
		System.out.println(dijkstra(sc.nextInt(), sc.nextInt()));
		
	}
	
	
	private static long dijkstra(int start, int end) {
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
				if(!visited[i] && adjList[now.node][i] !=  INF) {
					pq.add(new Edge(i, now.weight+ adjList[now.node][i]));
				}
			}
			
			
		}
		return 0;
		
	}
	
	
	private static void print() {
		System.out.println();
		for (int i = 1; i < adjList.length; i++) {
			for (int j = 1; j < adjList[0].length; j++) {
				System.out.print(adjList[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------------------------");
		
	}

}
