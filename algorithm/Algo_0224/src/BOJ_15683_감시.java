import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15683_감시 {
	public static class CCTV {
		int cctvNum;
		int x;
		int y;

		public CCTV(int cctvNum, int x, int y) {
			this.cctvNum = cctvNum;
			this.x = x;
			this.y = y;
		}

	}

	static int N, M;
	static int map[][];
	static int temp_map[][];
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	static ArrayList<CCTV> cctvNum = new ArrayList<>();
	static int combResult[];
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp != 0 && temp != 6) {
					// cctv담아두기
					cctvNum.add(new CCTV(temp, i, j));
				}
				map[i][j] = temp;
			}
		} // input end
		//System.out.println(cctvNum.size());

		combResult = new int[cctvNum.size()];
		
		comb(0, cctvNum.size());
		
		System.out.println(result);

	}// main end

	private static void bfs(CCTV cctv, int d) {
		Queue<CCTV> q = new LinkedList<>();
		
		boolean[][] visited = new boolean[N][M];
		

		q.add(cctv);

		visited[cctv.x][cctv.y] = true;

		while (!q.isEmpty()) {
			int nx = q.peek().x + dx[d];
			int ny = q.poll().y + dy[d];

			// 범위를 벗어나거나 벽을 만나면 끝
			if (nx < 0 || nx >= N || ny < 0 || ny >= M || temp_map[nx][ny] == 6) {
				break;
			}

			if (temp_map[nx][ny] == 0) {
				temp_map[nx][ny] = -1; // 방문 할 수 는 곳이라 감시할 수 있다는 의미로 -1
				q.add(new CCTV(cctv.cctvNum, nx, ny));
			} else { // 방문 할 수 없는 경우 체크
				q.add(new CCTV(cctv.cctvNum, nx, ny));
			}
		}
	
	}//bfs end 

	private static void direction(CCTV cctv, int d) {
		int cctvtype = cctv.cctvNum;
//		print();

		if (cctvtype == 1) {
			if (d == 0)
				bfs(cctv, 0); // 상
			else if (d == 1)
				bfs(cctv, 1); // 우
			else if (d == 2)
				bfs(cctv, 2); // 하
			else if (d == 3)
				bfs(cctv, 3); // 좌
		} else if (cctvtype == 2) {
			if (d == 0 || d == 2) {
				bfs(cctv, 0);
				bfs(cctv, 2); // 상하
			} else {
				bfs(cctv, 1);
				bfs(cctv, 3); // 좌우
			}
		} else if (cctvtype == 3) {
			if (d == 0) {
				bfs(cctv, 0); // 상우
				bfs(cctv, 1);
			} else if (d == 1) {
				bfs(cctv, 1); // 우하
				bfs(cctv, 2);
			} else if (d == 2) {
				bfs(cctv, 2); // 하좌
				bfs(cctv, 3);
			} else if (d == 3) {
				bfs(cctv, 0); // 좌상
				bfs(cctv, 3);
			}
		} else if (cctvtype == 4) {
			if (d == 0) {
				bfs(cctv, 0); // 좌상우
				bfs(cctv, 1);
				bfs(cctv, 3);
			} else if (d == 1) {
				bfs(cctv, 0); // 상우하
				bfs(cctv, 1);
				bfs(cctv, 2);
			} else if (d == 2) {
				bfs(cctv, 1); // 좌하우
				bfs(cctv, 2);
				bfs(cctv, 3);
			} else if (d == 3) {
				bfs(cctv, 0); // 상좌하
				bfs(cctv, 2);
				bfs(cctv, 3);
			}
		} else if (cctvtype == 5) { // 상우하좌
			bfs(cctv, 0);
			bfs(cctv, 1);
			bfs(cctv, 2);
			bfs(cctv, 3);
		}
	}// direction end

	private static void comb(int start, int R) {

		if (start == R) {
			// 원본 배열 회손 없이 여러가지 경우를 계산해야함으로 deepCopy 사용
			deepCopy();

			// cctv 넘버랑 방향 전송
			for (int i = 0; i < cctvNum.size(); i++) {
				direction(cctvNum.get(i), combResult[i]);

			}
			count();
			return;
		}

		// cctv 회전에 대한 모든 경우의 수 보내기
		for (int i = 0; i < 4; i++) {
			combResult[start] = i;
			comb(start + 1, R);
		}

	}// comb end

	private static void deepCopy() {
		temp_map  = new int[N][M];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				temp_map[i][j] = map[i][j];
			}
		}

	}

	private static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(temp_map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("------------------------------------------");

	}
	
	
	private static void count() {
		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(temp_map[i][j]  == 0) {
					cnt++;
				}
			}
		}
		result = Math.min(cnt, result);

	}

}
