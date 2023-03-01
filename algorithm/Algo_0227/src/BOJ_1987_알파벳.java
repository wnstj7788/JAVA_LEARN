import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
	static int R, C;
	static char map[][];
	static boolean visited[][];
	static int visited_ABC[];
	static int ans;                  
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];
		visited_ABC = new int[26];

		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		visited_ABC[(map[0][0] -  'A' )] =1; 
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				 bfs(0, 0);
//			}
//		}
		ans = 0;
		 //bfs(0, 0);
		dfs(0,0,1);
		System.out.println(ans);
		//System.out.println(Arrays.deepToString(map));

	}
	
	
	private static void dfs(int si, int sj , int cnt) {
		ans = Math.max(ans, cnt);
		
		for (int d = 0; d < 4; d++) {
			int nextI = si+ dx[d];
			int nextJ = sj + dy[d];
			if (nextI >= 0 && nextI < R && nextJ >= 0 && nextJ < C) {
				if (visited_ABC[(map[nextI][nextJ] -  'A' )] == 0) {
					visited_ABC[map[nextI][nextJ] - 'A'] = 1;
					dfs(nextI, nextJ, cnt+1);
					visited_ABC[map[nextI][nextJ] - 'A'] = 0;
				}
			}
			}
	}
	

	// 우선순위를 겨ㅑㄹ정해야함 ...
	private static void  bfs(int si, int sj) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(si, sj));
		visited[si][sj] = true;
		visited_ABC[(map[si][sj] - 'A' )] = 1;
		//System.out.println("debug");
		//System.out.println(Arrays.toString(visited_ABC));

		while (!q.isEmpty()) {
			Point now = q.poll();

			for (int d = 0; d < 4; d++) {
				int nextI = now.x + dx[d];
				int nextJ = now.y + dy[d];
				if (nextI >= 0 && nextI < R && nextJ >= 0 && nextJ < C) {
	
					if (!visited[nextI][nextJ] &&visited_ABC[(map[nextI][nextJ] -  'A' )] != 1) {
						System.out.println("I :"+ nextI + "J :" + nextJ);
						ans++;
						visited[nextI][nextJ] = true;
						visited_ABC[(map[nextI][nextJ] - 'A')] = 1;
						//System.out.println(Arrays.toString(visited_ABC));
						q.add(new Point(nextI, nextJ));

					}
				}

			}

		}


	}//bfs종료 
	
}