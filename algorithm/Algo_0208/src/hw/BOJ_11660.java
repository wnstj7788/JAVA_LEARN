package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 4 3
1 2 3 4
2 3 4 5
3 4 5 6
4 5 6 7
----4 * 4 2차원배열 

2 2 3 4
3 4 3 4
1 1 4 4

2,2 -> 3,4 까지의 구간합 구하기 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class BOJ_11660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 배열의 크기
		int M = Integer.parseInt(st.nextToken()); // 테케

		int arr[][] = new int[N + 1][N + 1];

		for (int i = 0; i < N; i++) {

		}
		for (int i = 1; i <= N; i++) { // 그래프 그리기
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				if (j > N) {
					arr[i][j] = arr[i][j - 1] + Integer.parseInt(st1.nextToken()); // n-1 까지 진행
				} else { // n번쨰에서는 다음줄 첫 번째에 값 넣어주기
					arr[i][j] = arr[i][j - 1] + Integer.parseInt(st1.nextToken());
					if (i + 1 <= N)
						arr[i + 1][0] = arr[i][j];
				}
			}
		} // 그래프 그리기 끝
		System.out.println(Arrays.deepToString(arr));

		for (int i = 0; i < M; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st3.nextToken());
			int y1 = Integer.parseInt(st3.nextToken());
			int x2 = Integer.parseInt(st3.nextToken());
			int y2 = Integer.parseInt(st3.nextToken());
			System.out.println(arr[x2][y2] - arr[x1][y1]);
		}

	}

}
