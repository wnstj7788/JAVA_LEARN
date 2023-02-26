import java.util.Scanner;

public class BOJ_14503_로봇청소기 {
	static int N, M, D;
	// 동서남북
	static int dx[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 동서남북

	static int map[][];

	static int move_cnt = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 사각형 크기
		M = sc.nextInt();

		map = new int[N][M];
		int robot_i = sc.nextInt(); // 로봇의 좌표
		int robot_j = sc.nextInt();

		D = sc.nextInt(); // 방향

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// 0 이 청소가 되지 않은 빈칸, 1은 벽
		// 방문배열 없이 이 자체로 가능할 듯
		clean(robot_i, robot_j, D);
		// print(map);
		System.out.println(move_cnt);

	}

	static void clean(int r, int c, int d) {

		//print(map);
		// 구현되어야할 구현체
		// 0. 현재칸 청소 확인
		// 1. 4방탐색
		// 2. 4방향 모두 청소되어있다면 보고있는 방향을 기준으로 후퇴 -> 0ß번으로
		// 3. 4칸중 청소가 안되어있는 부분이 있다면 반시계 회전, 청소 실행 -> 0번으로
		map[r][c] = 3; // 로봇이 지나간 구역 표시

		for (int i = 0; i < 4; i++) {
			d = (d + 3) %4;
			int nr = r + dx[d][0];
			int nc = c + dx[d][1];
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
				move_cnt++;

				clean(nr, nc, d); // 직진~!

				return;

			}
		}

		// 후진 연산
		int moveBack = (d + 2) % 4; // 후진 연산
		int br = r + dx[moveBack][0];
		int bc = c + dx[moveBack][1];

		if (br >= 0 && br < N && bc >= 0 && bc < M && map[br][bc] != 1) {
			//System.out.println("나 실행중");
			clean(br, bc, d);
		}
	}

	static void print(int[][] origin) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(origin[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------------------------");
	}

}