import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class AdjListTest {
	
	static class Node{
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
		
	}
	

	static Node[] adjList;
	static int V;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		 V = sc.nextInt();
		int E = sc.nextInt();

		adjList = new Node[V]; // head가ㅣ 모두 null인 상태 

		int from, to;
		for (int i = 0; i < E; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			
			
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
//		print();
		//bfs(0);
		dfs(0,new boolean[V]);

	}
	
	
	
	static void dfs(int now, boolean[] visited) {
		visited[now] = true;
		System.out.println((char)(now + 65)); // 탐색해때 해야 할일
		
		//자신의 인접 리스트 확인 : adjlist
		for (Node temp = adjList[now]; temp != null ; temp = temp.link){
			if(!visited[temp.vertex]) {
				dfs(temp.vertex,visited);
			}
		}
		
	}
	
	
	
	static void bfs(int start) {	
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[V];
		
		q.offer(start);
		visited[start] = true;
		int now = 0;
		
		while(!q.isEmpty()) {
			now = q.poll();
			System.out.println((char)(now + 65)); // 탐색해때 해야 할일
			
			for (Node temp = adjList[now]; temp != null; temp = temp.link) {
				if(!visited[temp.vertex]) {
					q.offer(temp.vertex);
					visited[temp.vertex] = true;
				}
			}
			
		}
		
		
	}
		
	
	static void print() {
		for(Node node : adjList) { // node 각 인접 리스트의 해드 
			System.out.println(node);
		}
	}
	

}
