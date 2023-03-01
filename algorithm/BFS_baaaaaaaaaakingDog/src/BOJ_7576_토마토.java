import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7576_토마토 {

	static class Tomato {
		int x;
		int y;
		int time;

		public Tomato(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}

	}

	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	static int M, N;
	static int map[][];
	static boolean[][] visited;
	static int TomatoTotal;
	static int cntTomato;
	static int TomatoTime = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[M][N];
		visited = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 0) {
					TomatoTotal++; // 우리가 익혀야할 토마토
				}
			}
		}

		bfs();

		if (TomatoTotal == 0) {
			System.out.println(0);
		} else if (TomatoTotal == cntTomato) {
			System.out.println(TomatoTime);
		} else
			System.out.println(-1);

	}

	static void bfs() {
		Queue<Tomato> q = new LinkedList<>();

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					q.add(new Tomato(i, j, 0));
					visited[i][j] = true;
				}
			}
		}

		while (!q.isEmpty()) {
			Tomato now = q.poll();
			for (int i = 0; i < dx.length; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
					if (!visited[nx][ny] && map[nx][ny] == 0) {

						map[nx][ny] = 1;
						visited[nx][ny] = true;
						cntTomato++;
						q.add(new Tomato(nx, ny, now.time + 1));
					}
				}
			} // for end
			//print();
			TomatoTime = Math.max(TomatoTime, now.time);
		} // while end

	}

	static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println("-----------------");
	}

}
