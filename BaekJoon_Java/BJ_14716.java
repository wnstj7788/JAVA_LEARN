import java.util.Scanner;

//문제 접근 아이디어 
//1. 배열 입력 후 1을 만나면 탐색 시작 방문한 요소는 방문처리
//2. 상,하,좌,우, 대각선을 모두 확인하기 위해서 8방 탐색 실행 8방이 모두 0이라면 +1을 한 뒤 1번을 반
//

public class BJ_14716 {
	static boolean vistied[][];
	static int m, n;
	static int map[][];
	static int cnt;
	static int di[] = { 0, 0, -1, -1, -1, 1, 1, 1 }; // 8방 탐색을 위한 상하좌우 대각선표시
	static int dj[] = { -1, 1, 0, -1, 1, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		m = sc.nextInt();
		n = sc.nextInt();
		cnt = 0;
		map = new int[m][n];
		vistied = new boolean[m][n];

		// 그래프 입력 받기
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// 현재 자표가 1이면서 방문하지 않았다면 dfs 실행
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1 && !vistied[i][j]) {
					dfs(i, j);
					cnt += 1;
				}
			}
		}

		System.out.println(cnt);

	}

	public static void dfs(int i, int j) {
		vistied[i][j] = true;// 방문처리를 한다
		// 8방 탐색 실행
		for (int k = 0; k < 8; k++) {
			int dx = i + di[k];
			int dy = j + dj[k];
			// 해당 수가 범위 안이면서 미방문이면서 1인경우
			if ((dx >= 0 && dy >= 0 && dx < m && dy < n) && !vistied[dx][dy] && map[dx][dy] == 1) {
				vistied[dx][dy] = true; // 방문처리해주고
				dfs(dx, dy); // 다음 1로 이동해서 8방탐색 실행
			}
		}

	}

}
