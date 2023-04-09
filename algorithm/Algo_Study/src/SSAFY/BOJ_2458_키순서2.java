package SSAFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2458_키순서2 {

	static int N, M;
	static int[][] adj;
	static int[][] radj;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adj = new int[N + 1][N + 1];
		radj = new int[N + 1][N + 1];
		int a, b;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			radj[b][a] = adj[a][b] = 1; // a보다 b가 크다

		}

		int ans = 0;
		for (int i = 0; i <= N; i++) {
			cnt = 0;
			dfs(i,adj, new boolean[N + 1]);
			dfs(i,radj, new boolean[N + 1]);
//			ltDFS(i, new boolean[N + 1]);
			if (cnt == N - 1) {
				ans++;
			}
		}
		System.out.println(ans);
	}

	static void dfs(int cur, int[][] adj, boolean[] visited) {
		// cur정점 기준으로 자신보다 큰 정점 탐색
		visited[cur] = true;
		for (int i = 1; i <= N; i++) {
			if (adj[cur][i] == 1 && !visited[i]) {
				cnt++;
				dfs(i, adj, visited);

			}
		}
	}

	static void ltDFS(int cur, boolean[] visited) {
		// cur정점 기준으로 자신보다 작은 정점 탐색
		visited[cur] = true;
		for (int i = 1; i <= N; i++) {
			if (adj[i][cur] == 1 && !visited[i]) {
				cnt++;
				ltDFS(i, visited);
			}
		}
	}
}