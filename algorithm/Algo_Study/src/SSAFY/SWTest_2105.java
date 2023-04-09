package SSAFY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://hesh1232.tistory.com/120
class SWEA_2105_디저트카페1 {
	static int N, answer;
	static int[][] map;
	static boolean[] check;
	static int[] dx = {1, 1, -1, -1};
	static int[] dy = {1, -1, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= tc; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			answer = -1;
			// input값 받기
			for (int row = 0; row < N; row++) {
				String[] input = br.readLine().split(" ");
				for (int col = 0; col < N; col++) {
					map[row][col] = Integer.parseInt(input[col]);
				}
			}
			// 0,0 부터 모든 경우의수 돌아보기
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					check = new boolean[101];
					dfs(row, col, row, col, 0, 0);
				}
			}

			bw.write("#" + test_case + " " + answer);
			bw.newLine();
		}

		bw.flush();
		bw.close();

	}

	private static void dfs(int x, int y, int finishX, int finishY, int dir, int cnt) {
		// 시작지점으로 돌아왔을 경우 종료
		if (x == finishX && y == finishY && dir == 3) {
			answer = Math.max(answer, cnt);
			return;
		}

		for (int i = dir; i < 4; i++) {
			// 두 방향의 상태트리 까지만 돌기
			if (i <= dir + 1) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					// 중복된 숫자가 아닌경우
					if (!check[map[nx][ny]]) {
						check[map[nx][ny]] = true;
						dfs(nx, ny, finishX, finishY, i, cnt + 1);
						check[map[nx][ny]] = false;
					}
				}
			}


		}

	}

}
    
