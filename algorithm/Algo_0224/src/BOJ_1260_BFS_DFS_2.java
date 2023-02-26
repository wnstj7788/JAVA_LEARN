import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.swing.text.Position.Bias;

public class BOJ_1260_BFS_DFS_2 {

	static boolean[] visited; // 방문 배열 
	static int map[][]; // 2차원 배열 선언 
	static int N, M, start;
	static StringBuilder sb = new StringBuilder();

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		 N = Integer.parseInt(st1.nextToken());
		 M = Integer.parseInt(st1.nextToken());
		 start = Integer.parseInt(st1.nextToken());
		
		map = new int [N+1][N+1]; 
		visited = new boolean[N +1];
		
		// 간선 입력 받기
		for(int i= 0 ; i< M ;i++) {
			StringTokenizer st2= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			
			map[a][b] = map[b][a] =1; // 양뱡향 그래프 
		}
		 
		dfs(start);
		
		visited = new boolean[N +1]; // 배열 초기화 
		
		sb.append("\n");
		bfs(start);
		
		System.out.println(sb);
		
	}

	private static void bfs(int start2) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start2);
		visited[start2] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			sb.append(now + " ");
			
			for(int i = 1; i <=N; i ++) {
				if(map[now][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
			
		}
		
		
	}
	
	
	
	
	

	private static void dfs(int start2) {
		visited[start2] = true;
		sb.append(start2 + " " );
		
		for(int i = 1; i <=N; i ++) {
			if (map[start2][i] == 1 &&!visited[i]) {
				dfs(i);
				
			}
	}
	

	}
}