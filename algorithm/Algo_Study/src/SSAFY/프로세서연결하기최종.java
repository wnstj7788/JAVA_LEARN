package SSAFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 프로세서연결하기최종 {
	public static class cell {
		int x, y;

		public cell(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static ArrayList<cell> mycell;

	static int N, ans, map[][], maxCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			mycell = new ArrayList<>();
			N = Integer.parseInt(br.readLine());
			StringTokenizer st;
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int temp = Integer.parseInt(st.nextToken());

					if (temp == 1) {
						if (!(i == 0 || i == N - 1 || j == 0 || j == N - 1)) {
							mycell.add(new cell(i, j)); // 가능한 범위 안에 있다면 넣어버리기
						}
					}
					map[i][j] = temp;

				}
			} // input end

			maxCnt = -1;
			ans = Integer.MAX_VALUE;
			dfs(0, 0, 0);
			System.out.println("#" + tc + " "+ ans);
		} // tc end

	}// main end

	private static void dfs(int idx, int connectionCnt, int len) {
		if (idx == mycell.size()) {
			if (maxCnt < connectionCnt) {
				maxCnt = connectionCnt;
				ans = len;

			} else if (maxCnt == connectionCnt) {
				ans = Math.min(ans, len);
			}

			return;
		}
	

        int x = mycell.get(idx).x;
        int y = mycell.get(idx).y;

		for (int d = 0; d < 4; d++) {
			int nx = x;
			int ny = y;
			int cnt = 0;
			while (true) { // 한 방향으로 쭉 가야함
				nx += dx[d];
				ny += dy[d];

				// 도착
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					break;
				}
				// 이미 전선거나 이동 불가한 칸
				if (map[nx][ny] == 1) {
					cnt = 0;
					break;
				}
				// 진행중
				cnt++;

			}
			// 전선 매설하기
			int moveI = x;
			int moveJ = y;
			for (int i = 0; i < cnt; i++) {
				moveI += dx[d];
				moveJ += dy[d];
				map[moveI][moveJ] = 1;

			}

			// 0이면 카운트 안늘리고 가고
			if (cnt == 0) {
				dfs(idx + 1, connectionCnt, len);
			} else {
				dfs(idx + 1, connectionCnt + 1, len + cnt);
				moveI = x;
				moveJ = y;
				for (int i = 0; i < cnt; i++) {
					moveI += dx[d];
					moveJ += dy[d];
					map[moveI][moveJ] = 0;

				}

			}
			// 아니면 늘리기

		}

	}

}
