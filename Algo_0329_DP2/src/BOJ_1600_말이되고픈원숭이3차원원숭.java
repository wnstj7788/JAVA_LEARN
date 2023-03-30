import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1600_말이되고픈원숭이3차원원숭 {

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] HoresMove = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } }; // 오른쪽맨위부터
																														// 시계방향으로
																														// 8개
	static int K;
	static int W, H;
	static int[][] map;
	static boolean[][][] visit;
	

	static public class MonKey {
		int K;
		int x;
		int y;
		int cnt;

		public MonKey(int K, int cnt, int x, int y) {
			this.K = K;
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Queue<MonKey> queue = new LinkedList<>();

		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();

		map = new int[H][W];
		visit = new boolean[K + 1][H][W];

	
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = sc.nextInt();

			}
		}

		visit[0][0][0] = true; 
		queue.add(new MonKey(0, 0, 0, 0)); 

		while (!queue.isEmpty()) {
			MonKey m = queue.poll();
	
			if (m.x == H - 1 && m.y == W - 1) { 
				System.out.println(m.cnt);
				return;

			}


			for (int d = 0; d < 4; d++) { 
				int nr = m.x + dr[d];
				int nc = m.y + dc[d];
				int cnt = m.cnt;
				int copyMap = m.K;
				if (nr < 0 || nc < 0 || nr >= H || nc >= W)
					continue; 
				// 벽인경우
				if (map[nr][nc] == 1)
					continue;

				if (visit[copyMap][nr][nc])
					continue; // 방문했으면
			
				visit[copyMap][nr][nc] = true ; // 방문처리
				queue.add(new MonKey(copyMap, cnt + 1, nr, nc)); 
			} 
		
			if ( m.K == K) continue;

			for (int d = 0; d < 8; d++) {
				int nr = m.x + HoresMove[d][0];
				int nc = m.y + HoresMove[d][1];
				int cnt = m.cnt;
				int copyMap = m.K + 1;
				if (nr < 0 || nc < 0 || nr >= H || nc >= W)
					continue; 
				// 벽인경우
				if (map[nr][nc] == 1)
					continue;
				
				if (visit[copyMap][nr][nc])
					continue; 
				visit[copyMap][nr][nc] = true ;
				queue.add(new MonKey(copyMap, cnt + 1, nr, nc)); 

			}

		}
		
		System.out.println("-1");
	}
}