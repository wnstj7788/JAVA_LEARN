import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_5639 {
	public static int N, M;
	public static boolean visited[];
	public static int arr[][];
	public static int cnt =0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			
			arr[node1][node2] = arr[node2][node1] = 1; 
			
		}
		
		System.out.println(bfs(1));
		
		
	}
	
	static int bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for (int i = 1; i <=N; i++) {
				if(arr[now][i] == 1 && visited[i] == false) {
					q.offer(i);
					visited[i] = true;
					cnt++;
					
					
				}
				
			}
			
		}
		return cnt;
	}

}
