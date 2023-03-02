package sample;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dijkstra_test {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int V = Integer.parseInt(br.readLine());
		
		StringTokenizer st  = new StringTokenizer(br.readLine(), " ");
		
		int start =  Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		
		int [][] adjMatrix = new int[V][V];
		
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		final int INF = Integer.MAX_VALUE;
		int distance[] = new int [V]; // 출발지에서 나에게 오는 최단경로 저장 
		
		boolean[] visited = new boolean[V]; // 경유지로 고려된 정점 여부
		Arrays.fill(distance,INF); // 최소값 생신 로직을 반영해야하므오 큰값으로 초기화 
		distance[start] = 0;
		
		
		int min, current;
		for (int c = 0; c < V; c++) {
			
			
			// step1 : 경우지로 처리되지 않은 정점 중 출발지에서 가장 가까운 정점 선택
			current = -1;
			min = INF;
			
			for (int i = 0; i < V; i++) {
				if(!visited[i] && min > distance[i]) {
					min = distance[i];
					current = i;
					
				}
			}
			
			if(current == -1) {
				break;
			}
			visited[current] = true;
			
			//step2 : 위에서 선택된 정점을 경유지로 해서 갈 수 있는 다른 인접정점과 비용 최소값 갱신
			for (int i = 0; i < V; i++) {
				if(!visited[i] && adjMatrix[current][i] != 0 && distance[i] > min + adjMatrix[current][i]) {
					distance[i] =  min + adjMatrix[current][i];
				}
			}
			
			
			//step3
		}
		System.out.println(distance[end] != INF? distance[end] : -1);
		
	}
}
