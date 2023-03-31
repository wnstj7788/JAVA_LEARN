import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4485_녹새옷입은애가젤다지 {
	static int N, map[][];
	static boolean visited[][];
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	
	static class Point{
		int x, y, cnt;

		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}
			map = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // input end

			System.out.println(bfs(0, 0));

		} // while end

	}// main end

	private static int bfs(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(i, j, 0));
		visited[i][j] = true;
		int cost = 0;
		while (!q.isEmpty()) {
			Point now = q.poll();
			for (int k = 0; k < dx.length; k++) {
				int nx = now.x + dx[k];
				int ny = now.y + dy[k];
				if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new Point(nx,ny,now.cnt + map[nx][ny]));
					cost = now.cnt + map[nx][ny];
				}
			}

		}
		return cost;

	}

}
