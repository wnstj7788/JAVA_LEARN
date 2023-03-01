import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1926_그림 {
	static int N, M;
	static int result = Integer.MIN_VALUE;
	static int map[][];
	static boolean visited[][];
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		} // end input
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					bfs(i,j);
					cnt++;
				}	
			}
		} //start bfs end 
		
		System.out.println(cnt);
		System.out.println(result == Integer.MIN_VALUE ? 0 : result);
	}

	private static void bfs(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		visited[i][j] = true;
		int drawcnt = 1;
		
		q.add(new Point(i,j));
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			for (int d = 0; d < dx.length; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];
				
				if(nx >=0 && nx  < N && ny >=0 && ny <M) {
					if(!visited[nx][ny] && map[nx][ny] == 1) {
						visited[nx][ny] = true;
						drawcnt ++;
						
						q.add(new Point(nx, ny));	
					}
				}
				
				
			}//for end
		}//while end 
		result = Math.max(result, drawcnt);
	}//bfs end

}
