import java.util.Scanner;

public class BOJ_16926_for4개 {
	static int N, M, R;

	static int map[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

	}

	static void rotate() {
		int depth = Math.min(N, M) / 2;

		for (int i = 0; i < depth; i++) {
			int tmp = map[i][i]; // 현재 레이어의 좌상 뽑아놓기

			for (int j = i; j < N - i - 1; j++) {
				map[i][j] = map[i][j + 1];

			}

			for (int j = i; j < N - i - 1; j++) {
				map[i][M - 1 - i] = map[i + 1][M - 1 - i];
			}

			for (int j = M - 1 - i; j > 1 + i; j--) {
				map[N - 1 - i][j] = map[N - 1 - i][j - 1];
			}

			for (int K = N - 1 - i; K >= 1 + i; K--) {
				map[K][i] = map[K - 1][i];
			}
		}
	}

}
