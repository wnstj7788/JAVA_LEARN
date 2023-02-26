import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1012_유기농배추 {
	static int M, N;
	static int map[][];
	static boolean visited[][];
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 0; tc < TC; tc++) {
			
			int cnt = 0;
			M = sc.nextInt();
			N = sc.nextInt();
			int R = sc.nextInt();
			map = new int[M][N];
			visited = new boolean[M][N];

			for (int i = 0; i < R; i++) {
				map[sc.nextInt()][sc.nextInt()] = 1;
			} // input end

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			} // for end

			System.out.println(cnt);
		} // tc end

	}// main end

	static void bfs(int si, int sj) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(si, sj));

		while (!q.isEmpty()) {
			Point now = q.poll();
			//System.out.println("2222");
			for (int d = 0; d < 4; d++) {
				int nextI = now.x + dx[d];
				int nextJ = now.y + dy[d];

				if (nextI >= 0 &&  nextI < M && nextJ >= 0 &&nextJ < N) {

					if (map[nextI][nextJ] == 1 && !visited[nextI][nextJ]) {
			
						//System.out.println("1111");
						q.add(new Point(nextI, nextJ));
						visited[nextI][nextJ] = true;

					}
				}
			}

		}
	}
	
	static void bfs1(int si, int sj) {
		// 4방 탐색을 위한 4방 탐색 조건 명시

		Queue<Point> q = new LinkedList<>();
		q.add(new Point(si,sj));
		
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			for(int d = 0; d < 4 ; d++) {
				int nextI = now.x + dx[d];
				int nextJ = now.y + dy[d];
				if(nextI >= 0 && nextI < M && nextJ >=0 && nextJ <N && map[nextI][nextJ] == 1 &&!visited[nextI][nextJ]) {
					q.add(new Point(nextI, nextJ));
					visited[nextI][nextJ] = true;
				}
		
			}
		}

	}

}
