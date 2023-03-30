import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_14502_연구소1_ver2 {
	static int[][] map;
	static int N, M, ans;

	static int[] di = { 0, 0, 1, -1 };
	static int[] dj = { 1, -1, 0, 0 };

	static ArrayList<Point> virus; // 초기 바이러스 따로 뽑아놓으면 BFS 돌릴때 좀 편함.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		virus = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 2)
					virus.add(new Point(i, j));
			}
		} // end input

		comb(0, 0);

		System.out.println(ans);
	}

	static void comb(int num, int cnt) { // num:칸번호, cnt:벽갯수
		if (cnt == 3) { // 벽 세개 선택함 시뮬레이션 시작
			int[][] copy = deepcopy(map);

			bfs(copy);
			return;
		}
		if(num == N*M) return; // 벽 안세우고 끝칸 넘어갔으면 돌아가라.

		int i = num / M;
		int j = num % M;

		if(map[i][j]==0) { // 빈칸이다!
			map[i][j] = 1; // 여기다 벽을 세워보자
			comb(num+1, cnt+1); // 여기다 벽 세운 상태로 기다려보면 벽 3개 됐을때 시뮬 돌거임.
			map[i][j] = 0;
		}
		comb(num+1, cnt); // 빈칸 아니면 그냥 넘어가라
	}

	private static void bfs(int[][] copy) {
		Queue<Point> queue = new LinkedList<>();
		queue.addAll(virus);

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];
				if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && copy[nexti][nextj] == 0) {
					copy[nexti][nextj] = 2; // 현재 now 바이러스 옆 빈칸이네? 바이러스 퍼짐!!
					queue.add(new Point(nexti, nextj));
				}
			}
		}

		int tmp = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp += copy[i][j] == 0 ? 1 : 0;
			}
		}
		ans = Math.max(ans, tmp);
	}

	static int[][] deepcopy(int[][] origin) {
		int[][] copy = new int[origin.length][origin[0].length];

		for (int i = 0; i < origin.length; i++) {
			for (int j = 0; j < origin[0].length; j++) {
				copy[i][j] = origin[i][j];
			}
		}
		return copy;
	}

	static class Point {
		int i, j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
