package hw;

import java.util.*;
import java.io.*;

public class BOJ_11660_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				arr[i][j] = arr[i][j - 1] + Integer.parseInt(st.nextToken());
			}
		}
		for (int k = 1; k <= m; k++) {
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for (int i = x1; i <= x2; i++) {
				sum = sum + (arr[i][y2] - arr[i][y1 - 1]);
			}
			sb.append(sum + "\n");
		}
		System.out.print(sb);
	}
}