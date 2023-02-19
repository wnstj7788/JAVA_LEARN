import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class SWEA_4021 {
	static int arr[][];
	static int N;
	static int min;
	static boolean visited[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			min = Integer.MAX_VALUE;
			visited = new boolean[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());

				}
			}
			sb.append("#" + t + " ");
			comb(0, 0);
			sb.append(min + "\n");


		}
		System.out.println(sb.toString());
	}

	public static void comb(int cnt, int start) {
		if (cnt == N / 2) {
			check();
			return;
		}

		for (int i = start; i < N; i++) {
			visited[i] = true;
			comb(cnt + 1, i + 1);
			visited[i] = false;
		}
	}

	public static void check() {
		int A = 0, B = 0, result = 0;

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (visited[i] && visited[j]) {
					A += arr[i][j] + arr[j][i];
				} else if (!visited[i] && !visited[j]) {
					B += arr[i][j] + arr[j][i];
				}
			}
		}
		result = Math.abs(A - B);
		min = Math.min(result, min);
	}
}
