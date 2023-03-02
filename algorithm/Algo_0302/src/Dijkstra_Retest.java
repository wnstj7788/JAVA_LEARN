import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra_Retest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		
		int startNode = sc.nextInt();
		int endNode = sc.nextInt();
		
		int adjList[][] = new int[V][V];
		
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				adjList[i][j] = sc.nextInt();
			}
		}
		
		int INF = Integer.MAX_VALUE;
		boolean visited[] = new boolean[V];
		int distance[] = new int[V];
		
		
		Arrays.fill(distance, INF);
		// 노드 전체 순회
		int min, now;
		for (int node = 0; node < V; node++) {
			min = INF;
			now  =  -1;
			
			distance[startNode] = 0;
			// 노드별로 순회하면서 최기 값을 설정해주자 
			for (int i = 0; i < V; i++) {
				if(min > distance[i] && !visited[i]) {
					min = distance[i];
					//현재 값을 변경해주고 
					now = i;
				}
					
				
			}
			
			if(now == -1) {
				break; // 갈 수 없는 경우임으로 멈춰 
			}
			
			//갈 수 있었다면 현재 노드를 방문처리한다
			
			visited[now] = true;
			
			
		}
		
	}

}
