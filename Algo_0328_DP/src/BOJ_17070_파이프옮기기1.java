import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070_파이프옮기기1 {

	static int result = 0;
	static int map[][];
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(1, 2, 0); // x,y 초기 파이프 위치와 방향 지정
		System.out.println(result);

	}

	private static void dfs(int x, int y, int dir) {
		if (x == N && y == N) {
			result++;
			return;
		}

		switch (dir) {
		case 0: // 정면인 상황 -> 직선과 대각선 가능 0, 2
			if (y + 1 <= N && map[x][y + 1] == 0) {
				dfs(x, y + 1, 0);
			}

			break;

		case 1: // 아래인 상황 아래 방향 대각선 가능 1,2
			if (x + 1 <= N && map[x + 1][y] == 0) {
				dfs(x + 1, y, 1);
			}

			break;
		case 2: // 대각선인 상황 아래, 직선, 대각선 가능 0,1,
			if (y + 1 <= N && map[x][y + 1] == 0) {
				dfs(x, y + 1, 0);
			}
			if (x + 1 <= N && map[x + 1][y] == 0) {
				dfs(x + 1, y, 1);
			}

			break;
		}
		if (y + 1 <= N && x + 1 <= N && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
			dfs(x + 1, y + 1, 2);
		}

	}

}
