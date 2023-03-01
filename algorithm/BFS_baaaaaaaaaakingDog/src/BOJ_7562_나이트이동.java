
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7562_나이트이동 {
	static class Point {
		int x;
		int y;
		int cnt;

		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	static int map[][];
	static boolean visited[][];
	static int N;
	static int dx[] = { -2, -2, 2, 2, 1, 1, -1, -1 };
	static int dy[] = { 1, -1, 1, -1, 2, -2, 2, -2 };
	static int endI, endJ;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();

		for (int tc = 0; tc < TC; tc++) {
			N = sc.nextInt();

			map = new int[N][N];
			visited = new boolean[N][N];

			int startI = sc.nextInt();
			int startJ = sc.nextInt();

			map[startI][startJ] = 1;// 시작점

			 endI = sc.nextInt();
			 endJ = sc.nextInt();
			map[endI][endJ] = 2; // 도착점

			bfs(startI, startJ, 0);
		}

	}

	private static void bfs(int startI, int startJ, int cnt) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(startI, startJ, cnt));
		visited[startI][startJ] = true;

		while (!q.isEmpty()) {
			Point now = q.poll();
			if (now.x == endI && now.y == endJ) {
				System.out.println(now.cnt);
				return;
			}

			for (int d = 0; d < dx.length; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {

					map[nx][ny] = 1;
					map[now.x][now.y] = 0;
					visited[nx][ny] = true;
					q.add(new Point(nx, ny, now.cnt + 1));

				}
				//print();
			}
		}

	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------------------------");
	}
}
