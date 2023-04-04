import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_2382_미생물격리 {

	static class mimi {
		int x, y, cnt, d;

		public mimi(int x, int y, int cnt, int d) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.d = d;
		}

	}

	static int map[][];
	static int N, M, K;
	static Queue<mimi> q;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	static int result;
	static mimi visited[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			q = new LinkedList<>();
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				map[x][y] = cnt;
				q.add(new mimi(x, y, cnt, d -1));

			}
			bfs();
			System.out.println("#" +tc+" " + result);

		}

	}

	private static void bfs() {
		result = 0;
		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			cnt ++;
			if(cnt == M ) {
//				System.out.println("나 도착함?");
				result = cal();
				break;
				
			}
			for (int s = 0; s < size; s++) {
				visited = new mimi[N][N];

				mimi now = q.poll();
				
				int nx = now.x + dx[now.d];
				int ny = now.y + dy[now.d];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (nx == 0 || nx == N - 1 || ny == 0 || ny == N - 1) {
						int d = (now.d +2) % 4;
						q.add(new mimi(nx, ny, now.cnt / 2, d));
						map[now.x][now.y] = 0;
						map[nx][ny] = now.cnt;
					} else {
						// 기존의 들어온 녀석과 시간이 같은 녀석이라면 비교를 해야하는데 이를 위한 변수를 선언해주자
						// 어떤 변수가 적합하지>
						// 리스트 변수를 만들어서 해결하자 
						visited[nx][ny] = new mini(nx,ny,)
						
						q.add(new mimi(nx, ny, now.cnt + map[nx][ny], now.d));
						
						map[now.x][now.y] = 0;
						map[nx][ny] = now.cnt;
					}
				}

			}
		}

	}

	private static int cal() {
		int total = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				total += map[i][j];
				
			}
		}
		
		return total;
	}
	
	
	
	

}
