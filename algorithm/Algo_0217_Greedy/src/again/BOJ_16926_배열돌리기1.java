package again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16926_배열돌리기1 {
	// 배열 부분을 나눠서 반시계 방향으로 돌리기
	// 첫 줄에는 입력이 나누어져서 들어옴
	// N M R

	static List<Integer> resut_list = new ArrayList<>();
	static int N, M, R;
	static int map[][];
	static int result[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		result = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int min = Math.min(N, M);
		rotate(0, N, 0, M, min/2);
//		print();
		
		//System.out.println(Arrays.deepToString(result));
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(result[i][j] + " ");	
			}
			System.out.println();
		}

	}

	static void rotate(int start_n, int end_n, int start_m, int end_m, int cnt) {
		Queue<Integer> q = new ArrayDeque<>();
		if (cnt == 0) {
//			int size = q.size();

//			System.out.println(q.size());
//			for (int i = 0; i < size; i++) {
//				System.out.print(q.poll() + " ");
//			}

			return;
		}

		// 부분별로 넣어주고 첫번째 값을 다시 큐에 넣어줌
		// 첫번째 부분
		int i = start_n, j = 0;
		for (j = start_n; j < end_m; j++) {
			q.offer(map[i][j]);
		}

		// 2번째 부분
		j = end_m - 1;
		for (i = start_n + 1; i < end_n; i++) {
			q.offer(map[i][j]);
		}

		// 3 번째 부분
		i = end_n - 1;
		for (j = end_m - 2; j >= start_m; j--) {
			q.offer(map[i][j]);
		}

		// 4 번째 부분
		j = start_m;
		for (i = end_n - 2; i >= start_n + 1; i--) {
			q.offer(map[i][j]);
		}

		// 화전수만큼 받아서 큐에 빼고 넣기
		for (i = 0; i < R; i++) {
			int temp = q.poll();
			q.offer(temp);
		}

//		for (int x : q) {
//			System.out.print(x + " ");
//		}
//		System.out.println();

//		int q_size = q.size();
//		
//		for (i = 0; i < q_size; i++) {
//			resut_list.add(q.poll());
//		}
		

		 i = start_n; j = 0;
		for (j = start_n; j < end_m; j++) {
			result[i][j] = q.poll();
		}

		// 2번째 부분
		j = end_m - 1;
		for (i = start_n + 1; i < end_n; i++) {
			result[i][j] = q.poll();
		}

		// 3 번째 부분
		i = end_n - 1;
		for (j = end_m - 2; j >= start_m; j--) {
			result[i][j] = q.poll();
		}

		// 4 번째 부분
		j = start_m;
		for (i = end_n - 2; i >= start_n + 1; i--) {
			result[i][j] = q.poll();
		}


		

		rotate(start_n + 1, end_n - 1, start_m + 1, end_m - 1, cnt - 1);

	}



}
