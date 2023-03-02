import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌깨기 {
	/*
	 * 1. 순서가 중요하고 같은 자리에 계속해서 볼을 던지 수 있다 = 중복을 허용하는 순열이다 2. BFS를 돌면서 4방을 깨는데 -1한
	 * 결과가 0이 아니라면 queue에 넣어버려 3. 다양한 부분을 테스트해봐야하니까 원본배열을 회손하지 않는 복사 배열을 만들어서 실행을
	 * 할거다
	 */

	static int map[][];
	static int W, H, N;
	static int card[];
	static int selected[];
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	static int result = Integer.MAX_VALUE;
	static boolean[][] visited;

	static class Point {
		int x;
		int y;
		int len;

		public Point(int x, int y, int len) {
			super();
			this.x = x;
			this.y = y;
			this.len = len;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			result = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 공의 개수
			W = Integer.parseInt(st.nextToken()); // x
			H = Integer.parseInt(st.nextToken()); // y

			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			card = new int[W];
			for (int i = 0; i < W; i++) {
				card[i] = i;
			}
			selected = new int[N];

			perm(0);

			System.out.println("#" + tc + " " + result);

		} // tc end;

	}

	static void perm(int idx) {
		if (idx == N) {
			// bfs도 실행해줄거고
//			for (int i = 0; i < N; i++) {
//				System.out.print(selected[i] + " ");
//			}
//			System.out.println();
			int cnt = 0;
			int temp[][] = deepcopy(map);
//			
			for (int i = 0; i < N; i++) {
				visited = new boolean[H][W];
				bfs(temp, selected[i]);
				compact(temp);
			}
			cnt = count(temp);
			result = Math.min(cnt, result);
			return;
		}
		// 우리의 재료는 W까지가 우리의 재료
		for (int i = 0; i < card.length; i++) {
			selected[idx] = card[i];
			perm(idx + 1);
		}

	}

	static void bfs(int temp[][], int selected) {
		// 4방 무한 탐색
		// 큐에 순차적으로 넣어? ㄴㄴ 큐가 비면 다시 넣어줘 '
		// 복제 본이들어와서 테스트를 해야겠지
		Queue<Point> q = new LinkedList<>();
		for (int h = 0; h < H; h++) {
			if (temp[h][selected] > 0) {
				q.add(new Point(h, selected, temp[h][selected])); // 0,x형태로 넣어주기 왜? 무조건 0좌표부터 시작하니까
				break;
			}
		}

		while (!q.isEmpty()) {
			Point now = q.poll();

			// 4방 탐색을 시작하는거야 현재 자리의 값만큼 반복하면서
			for (int d = 0; d < dx.length; d++) {
				for (int k = 0; k < now.len; k++) {
					int nx = now.x + dx[d] * k;
					int ny = now.y + dy[d] * k;
					// 나중에 값 변경 필수
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visited[nx][ny]) {
//								if(temp[nx][ny] != 0 ) {
//									if( temp[nx][ny] - temp[now.x][now.y] < 0) {
//										temp[nx][ny] = 0;
//										now.x = nx;
//										now.y = ny;
//									}
//									if(temp[nx][ny] >0 ) {
//										q.add(new Point(nx,ny));
//									}
//								}
						visited[nx][ny] = true;
						q.add(new Point(nx, ny, temp[nx][ny]));
						temp[nx][ny] = 0;

					}

				}

			}

		}
	}

	private static int count(int[][] temp) {
		int cnt = 0;
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				if (temp[i][j] > 0) {
					cnt++;
				}

			}
		}
		return cnt;
	}

	static int[][] deepcopy(int arr[][]) {
		int temp[][] = new int[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		return temp;

	}

	private static void compact(int[][] copy) {
		Queue<Integer> temp;

		for (int w = 0; w < W; ++w) {
			temp = new LinkedList<>();

			for (int h = H - 1; h >= 0; --h) {
				if (copy[h][w] > 0)
					temp.offer(copy[h][w]);
			}

			for (int h = H - 1; h >= 0; --h) {
				if (!temp.isEmpty()) {
					copy[h][w] = temp.poll();
				} else {
					copy[h][w] = 0;
				}
			}
		}
	}

	static void print() {

	}
}
