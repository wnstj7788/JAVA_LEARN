import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1600_말이되고픈원숭이Bfs {

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] HoresMove = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } }; // 오른쪽맨위부터
																														// 시계방향으로
																														// 8개
	static int k;
	static int w, h;
	static int[][] map;
	static boolean[][][] visit;
	

	static public class Monkey {
		int k;
		int x;
		int y;
		int cnt;

		public Monkey(int k, int cnt, int x, int y) {
			this.k = k;
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Queue<Monkey> queue = new LinkedList<>();

		k = sc.nextInt();
		w = sc.nextInt();
		h = sc.nextInt();

		map = new int[h][w];
		visit = new boolean[k + 1][h][w];

	
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				map[i][j] = sc.nextInt();

			}
		}

		visit[0][0][0] = true; 
		queue.add(new Monkey(0, 0, 0, 0)); 

		while (!queue.isEmpty()) {
			Monkey m = queue.poll();
	
			if (m.x == h - 1 && m.y == w - 1) { 
				System.out.println(m.cnt);
				return;

			}


			for (int d = 0; d < 4; d++) { 
				int nr = m.x + dr[d];
				int nc = m.y + dc[d];
				int cnt = m.cnt;
				int copyMap = m.k;
				if (nr < 0 || nc < 0 || nr >= h || nc >= w)
					continue; 
				// 벽인경우
				if (map[nr][nc] == 1)
					continue;

				if (visit[copyMap][nr][nc])
					continue; // 방문했으면

			
				visit[copyMap][nr][nc] = true ; // 방문처리
				queue.add(new Monkey(copyMap, cnt + 1, nr, nc)); 
			} 
		
			if ( m.k == k) continue;

			for (int d = 0; d < 8; d++) {
				int nr = m.x + HoresMove[d][0];
				int nc = m.y + HoresMove[d][1];
				int cnt = m.cnt;
				int copyMap = m.k + 1;
				if (nr < 0 || nc < 0 || nr >= h || nc >= w)
					continue; 
				// 벽인경우
				if (map[nr][nc] == 1)
					continue;
				
				if (visit[copyMap][nr][nc])
					continue; 
				visit[copyMap][nr][nc] = true ;
				queue.add(new Monkey(copyMap, cnt + 1, nr, nc)); 

			}

		}
		
		System.out.println("-1");
	}
}