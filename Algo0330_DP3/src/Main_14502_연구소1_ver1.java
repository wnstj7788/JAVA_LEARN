
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_14502_연구소1_ver1 {
	static int[][] map;
	static int N, M, ans;

	static int[] di = { 0, 0, 1, -1 };
	static int[] dj = { 1, -1, 0, 0 };

	static ArrayList<Point> virus; // 초기 바이러스 따로 뽑아놓으면 BFS 돌릴때 좀 편함.
	static ArrayList<Point> space; // 빈칸을 따로 쭉 뽑아놓고 여기서 벽세울거 3개 뽑는 조합

	static boolean[] select;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		virus = new ArrayList<>();
		space = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 0)
					space.add(new Point(i, j));
				if (map[i][j] == 2)
					virus.add(new Point(i, j));
			}
		} // end input

		select = new boolean[space.size()]; // 빈칸중에 3개 뽑을거임.
		comb(0, 0);
		
		System.out.println(ans);
	}

	static void comb(int idx, int cnt) {
		if (cnt == 3) { // 벽 세개 선택함 시뮬레이션 시작
			int[][] copy = deepcopy(map);

			for (int i = 0; i < select.length; i++) {
				if (select[i]) {
					Point wall = space.get(i); // 벽 세우기로 선택받은 빈칸좌표
					copy[wall.i][wall.j] = 1;
				}
			}

			bfs(copy);
			return;
		}
		if (idx == select.length)
			return;

		select[idx] = true;
		comb(idx + 1, cnt + 1);
		select[idx] = false;
		comb(idx + 1, cnt);
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
				tmp += copy[i][j]==0?1:0;
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

