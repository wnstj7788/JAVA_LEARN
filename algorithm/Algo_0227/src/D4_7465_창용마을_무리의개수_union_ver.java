import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class D4_7465_창용마을_무리의개수_union_ver {
	static int N,M;
	static int relation[][];
	static boolean visited[];
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			result = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 창용 마을에 사는 사람의 수 
			M = Integer.parseInt(st.nextToken()); // 사람들의 관계 수 
			
			relation = new int[N+1][N +1]; // 사람의 번호 1번부터 시작
			visited = new boolean[N+1];
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				relation[a][b] = relation[b][a] = 1;
				
			}//input end 
			
			for (int i = 1; i <= N; i++) {
				if(!visited[i]) {//방문한적없으면 = 누군가의 무리가 되지 않았다면 
					dfs(i); // 이 정점부터 시작해서 하나의 무리로 묶어주기
					result++;
				}
			}
			
			
		System.out.println("#" + t + " " + result);	
		}
	
	}
	
	//dfs 탐색하면서 아는 사람들을 모두 하나의 무리로 묶어주기
	static void dfs(int idx) {
		if(!visited[idx]) {
			visited[idx] = true;
			for (int i = 1; i <= N ; i++) {
				if(relation[idx][i] == 1 && !visited[i])
					dfs(i);
			}
		}
		
	}
	
	
	

}