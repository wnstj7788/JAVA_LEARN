import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class AdjMatrixTest_dfs {

	static int[][] AdjMatrix;
	static int V;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		 V = sc.nextInt();
		int E = sc.nextInt();

		AdjMatrix = new int[V][V]; // 모두 0으로 초기화된 상태

		int from, to;
		for (int i = 0; i < E; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			
			
			AdjMatrix[to][from] = AdjMatrix[from][to] = 1; // 무향 그래프인 경우
		}
		//bfs(0);
		dfs(0, new boolean[V]);
		//print();
	}
	 
	
	static void dfs(int now, boolean[] visited) {
		visited[now] = true;
		System.out.println((char)(now + 65)); // 탐색해때 해야 할일
		
		for (int i = 0; i < V; i++) {
			if(AdjMatrix[now][i] != 0 && !visited[i]) {
				dfs(i,visited);
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
			
			for (int i = 0; i < V; i++) {
				if(AdjMatrix[now][i] != 0 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
			
		}
		
		
	}
	
	static void print() {
		for(int[] am : AdjMatrix) {
			System.out.println(Arrays.toString(am));
		}
	}

}
