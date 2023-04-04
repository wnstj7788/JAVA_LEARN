import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1767_프로세서연결하기 {
	static class pro {
		int x, y, cnt;

		public pro(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

	}

	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	static int map[][];
	static boolean[][] visited;
	static int N;
	static int combArr[];
	static int processCnt;
	static boolean isSelected[];
	static int min = Integer.MAX_VALUE;
	static ArrayList<pro> xinos;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < TC; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			StringTokenizer st;
			xinos = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int temp = Integer.parseInt(st.nextToken());
					if (temp == 1) {
						// 어떤 프로세서인지가 중요함
						// 벽면 프로세서면 무시할 예정
						if (i == 0 || i == N || j == 0 || j == N) {
							continue;

						}
						xinos.add(new pro(i, j, 0));
						processCnt++;

					}
					map[i][j] = temp;
				}
			} // input end
			min = Integer.MAX_VALUE;
			for (int i = processCnt; i >= 0; i--) {
				combArr = new int[i];
				isSelected = new boolean[processCnt];
				comb(0, 0, i);
			}

			System.out.println(min);

		} // TC end

	}

	private static void comb(int idx, int start, int i) {
		if (idx == i) {
			// System.out.println(Arrays.toString(combArr));
			visited = new boolean[N][N];
			if(min != Integer.MAX_VALUE) return;
			dfs(0, 0);
			return;
		}

		for (int j = start; j < processCnt; j++) {
			isSelected[j] = true;
			combArr[idx] = j;
			comb(idx + 1, start + 1, i);
			isSelected[j] = false;
		}

	}

	private static void dfs(int idx, int cnt) {
		if (idx == combArr.length) {
//			System.out.println("여기까지옴" + cnt);
			min = Math.min(min, cnt); // 배열 끝까지 돌렸으면 이때의 최솟값 갱신
			return;
		}

		for (int d = 0; d < 4; d++) {
			int x = xinos.get(idx).x;
			int y = xinos.get(idx).y;
			int temp = 0;
			boolean success = false;
			while (true) {
				x += dx[d];
				y += dy[d];
				if (x < 0 || x >= N || y < 0 || y >= N) { // 범위 끝까지 갔으면 성공
					success = true;
					break;
				}
				if (map[x][y] != 0)
					break; // 전선이나 코어를 만나면 실패
				map[x][y] = 2; // 전선 표시
				temp++; // 전선 길이 합
			}
			if (success) {
				
				dfs(idx + 1, cnt + temp);
			}
			while (true) { // 원 상태로 돌려놓기
				x -= dx[d];
				y -= dy[d];
				if (x == xinos.get(idx).x && y == xinos.get(idx).y)
					break;
				map[x][y] = 0;
				
			}
		}
	}

}
