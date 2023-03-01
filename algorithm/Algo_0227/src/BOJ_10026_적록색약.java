import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026_적록색약 {

	// i는
	static char[][] map;
	static int normal, rgError;
	static int N;
	static boolean[][] visit;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new char[N][];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		} // end input

		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					bfs(i, j);
					normal++;
				}
			}
		}
		
		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'G') {
					map[i][j] = 'R';
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					dfs(i, j);
					rgError++;
				}
			}
		}
		
		System.out.println(normal + " " + rgError);

	}

	private static void dfs(int i, int j) {
		visit[i][j] = true;
		for (int d = 0; d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visit[nx][ny] &&map[i][j] == map[nx][ny]) {
//				visit[nx][ny] = true;
				dfs(nx,ny);
				
				
			}
		}
		
	}

	private static void bfs(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(i, j));
		visit[i][j] = true;

		while (!q.isEmpty()) {
			Point now = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visit[nx][ny] &&map[now.x][now.y] == map[nx][ny]) {
					visit[nx][ny] = true;
					q.add(new Point(nx,ny));
					
				}
			}
		}

	}

}
