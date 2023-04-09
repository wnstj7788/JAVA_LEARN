package SSAFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3055_탈출 {

	static class go {
		int x, y, cnt;

		public go(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

	}

	static Queue<go> water;
	static int R, C;
	static int si, sj, ei, ej;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	static int map[][];
	static boolean visited[][];
	static boolean waterVisited[][];
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		water = new LinkedList<>();
		waterVisited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				char tmp = temp[j];
				if (tmp == '.') {
					map[i][j] = 0;
				} else if (tmp == '*') {
					map[i][j] = 1;
					water.add(new go(i, j, 0));
					waterVisited[i][j] = true;
				} else if (tmp == 'X') {
					map[i][j] = 2;
				} else if (tmp == 'D') {
					map[i][j] = 10;
					ei = i;
					ej = j;
				} else if (tmp == 'S') {
					map[i][j] = 9;
					si = i;
					sj = j;
				}

			}
		} // input end
//		for (int temp[] : map) {
//			System.out.println(Arrays.toString(temp));
//		}
//		System.out.println("================원본===================");

		bfs(si, sj, ei, ej);

		if (result == Integer.MAX_VALUE) {
			System.out.println("KAKTUS");
		} else 
			System.out.println(result + 1);

	}

	private static void bfs(int si, int sj, int ei, int ej) {
		Queue<go> q = new LinkedList<>();
		visited = new boolean[R][C];

		visited[si][sj] = true;
		q.add(new go(si, sj, 0));

		while (true) {
			if (q.isEmpty()) {
				break;
			}

			if (!water.isEmpty()) {
				int waterSize = water.size();
				for (int s = 0; s < waterSize; s++) {

					go now = water.poll();
					for (int i = 0; i < 4; i++) {
						int nx = now.x + dx[i];
						int ny = now.y + dy[i];
						if (nx >= 0 && nx < R && ny >= 0 && ny < C && !waterVisited[nx][ny]) {
							if (map[nx][ny] == 1 || map[nx][ny] == 0) {
								map[nx][ny] = 1;
								waterVisited[nx][ny] = true;
								water.add(new go(nx, ny, now.cnt + 1));
							}
						}
					}
				}
			}
//			for (int temp[] : map) {
//				System.out.println(Arrays.toString(temp));
//			}
//			System.out.println("================water==================");

			if (!q.isEmpty()) {
				int DochiSize = q.size();
				for (int s = 0; s < DochiSize; s++) {

					go nowDochi = q.poll();
					for (int i = 0; i < dx.length; i++) {
						int nx = nowDochi.x + dx[i];
						int ny = nowDochi.y + dy[i];
						if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny] && map[nx][ny] != 1
								&& map[nx][ny] != 2) {
							if (map[nx][ny] == 0 || map[nx][ny] == 10) {
								if (map[nx][ny] == 10) {
									result = Math.min(result, nowDochi.cnt);
								}
								visited[nx][ny] = true;
								map[nx][ny] = 9;
								map[nowDochi.x][nowDochi.y] = 0;
								q.add(new go(nx, ny, nowDochi.cnt + 1));
							}
						}
					}
				}

			}

//			for (int temp[] : map) {
//				System.out.println(Arrays.toString(temp));
//			}
//			System.out.println("================또치==================");
		}

	}
}
