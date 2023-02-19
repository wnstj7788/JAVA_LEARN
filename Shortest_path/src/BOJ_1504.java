import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504 {
	static int distance[];
	static boolean visited[];
	static ArrayList<ArrayList<Node>> graph;
	static int N, M;
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		distance = new int[N + 1];
		visited = new boolean[N +1];
		graph = new ArrayList<>();
		
		
		Arrays.fill(distance, INF);
		
		for(int i = 0; i<= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			// 시작점에서 도착 지점까지
			graph.get(start).add(new Node(end, cost));
			// 도착에서 시작까지 ( 양방향 그래프)
			graph.get(end).add(new Node(start, cost));

		}
			// v1,v2
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			// start - v1 - v2 - end
			int distance_case1 = 0;
			distance_case1 += dijkstra(1, v1);
			distance_case1 += dijkstra(v1, v2);
			distance_case1 += dijkstra(v2, N);

			// start - v2 - v1 - end
			int distance_case2 = 0;
			distance_case2 += dijkstra(1, v2);
			distance_case2 += dijkstra(v2, v1);
			distance_case2 += dijkstra(v1, N);
			
			System.out.println(distance_case1);
			System.out.println(distance_case2);
			
			if(distance_case1 >= INF && distance_case2 >= INF) {
				System.out.println("-1");
			}else
				System.out.println(Math.min(distance_case1, distance_case2));
		

	}


	public static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		distance[start] = 0;

		while (!pq.isEmpty()) {
			Node curindex = pq.poll();
			int index = curindex.index;
			if (!visited[index]) {
				visited[index] = true;

				for (Node x : graph.get(index)) {
					if (!visited[x.index] && distance[x.index] > distance[index] + x.cost) {
						distance[x.index] = distance[index] + x.cost;
						pq.add(new Node(x.index, distance[x.index]));
					}

				}
			}
		}
		return distance[end];

	}
}

class Node implements Comparable<Node> {
	int index;
	int cost;
	
	Node(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return cost - o.cost;
	}
}