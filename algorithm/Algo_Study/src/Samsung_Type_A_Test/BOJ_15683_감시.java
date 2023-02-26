package Samsung_Type_A_Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class cctv { // cctv 클래스 생성
	int num;
	int x;
	int y;

	cctv(int num, int x, int y) {
		this.num = num;
		this.x = x;
		this.y = y;
	}

}



public class BOJ_15683_감시{
	// 1번 cctv 한쪽만
	// 2번 cctv 양쪽 -> 상하 or 좌우
	// 3번 cctv 직각
	// 4번 3방향
	// 5번 4방향 감시 가능
	// 감시 할 수 있는 방향의 전체 칸을 감시할 수 있음
	// 벽을 통과할 수는 없음 , CCTV는 통과할 수 있음
	// cctv 회전 가능 -> 90도
	// 0은 빈 간, 5은 벽 , 1~5는 cctv 번호
	// 적절히 회전 시켜서 사각지대 최소화
	// CCTV최대 8개
	// 탐색을 위한 BFS만들기 -> 그냥 for문으로 돌려?

	static int map[][];
	static int map_temp[][];
	static int N, M;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int result = Integer.MAX_VALUE;
	static ArrayList<cctv> cctvType;
	static int permArr[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		cctvType = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();

				if (map[i][j] != 0 && map[i][j] != 6) {
					cctvType.add(new cctv(map[i][j], i, j));
				}
			}
		}

		permArr = new int[cctvType.size()]; // 순열 돌려서 나올 경우의 수 저
		perm(0, cctvType.size());

		System.out.println(result);

	}

	public static void perm(int cnt, int R) {
		if (cnt == R) {
			map_temp = new int[N][M];
			// 반복문 +Arraycopy를 이용하면 2차원배열도 복사 가능
			for (int i = 0; i < map.length; i++) {
				// 배열 복사
				System.arraycopy(map[i], 0, map_temp[i], 0, map[i].length);
			}

			// cctv 별 경우에 대해 계산

			for (int j = 0; j < cctvType.size(); j++) {
				direction(cctvType.get(j), permArr[j]);
			}

			cornerscheck();

			return;

		}

		for (int i = 0; i < 4; i++) {
			permArr[cnt] = i;
			perm(cnt + 1, R);
		}

	}

	static void direction(cctv cctv, int d) {
		// 모든 경우를 전부 체크해보며 실행하기
		int cctvNum = cctv.num;
		
		if (cctvNum == 1) {
			if (d == 0)
				bfs(cctv, 0); // 상
			else if (d == 1)
				bfs(cctv, 1); // 우
			else if (d == 2)
				bfs(cctv, 2); // 하
			else if (d == 3)
				bfs(cctv, 3); // 좌
		} else if (cctvNum == 2) {
			if (d == 0 || d == 2) {
				bfs(cctv, 0);
				bfs(cctv, 2); // 상하
			} else {
				bfs(cctv, 1);
				bfs(cctv, 3); // 좌우
			}
		} else if (cctvNum == 3) {
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
		} else if (cctvNum == 4) {
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
		} else if (cctvNum == 5) { // 상우하좌
			bfs(cctv, 0);
			bfs(cctv, 1);
			bfs(cctv, 2);
			bfs(cctv, 3);
		}
	}

	static void bfs(cctv cctv, int d) {
		Queue<cctv> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];

		q.add(cctv);

		visited[cctv.x][cctv.y] = true;

		while (!q.isEmpty()) {
			int nx = q.peek().x + dx[d];
			int ny = q.poll().y + dy[d];

			// 범위를 벗어나거나 벽을 만나면 끝
			if (nx < 0 || nx >= N || ny < 0 || ny >= M || map_temp[nx][ny] == 6) {
				break;
			}

			if (map_temp[nx][ny] == 0) {
				map_temp[nx][ny] = -1; // 방문 할 수 는 곳이라 감시할 수 있다는 의미로 -1
				q.add(new cctv(cctv.num, nx, ny));
			} else { // 방문 할 수 없는 경우 체크
				q.add(new cctv(cctv.num, nx, ny));
			}
		}

	}

	static void cornerscheck() { // 4각 지대 전부 체크
		int k = 0;
//		System.out.println(Arrays.deepToString(map_temp));
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map_temp[i][j] == 0) {
					k++;
				}

			}
		}
//		System.out.println(k);
		result = Math.min(result, k);

	}
}
