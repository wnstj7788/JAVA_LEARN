package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_BFS와_DFS{

	static boolean[] visited; // 방문 배열
	static int arr[][]; // 2차원 배열 선언
	static int N, M, start;
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());
		start = Integer.parseInt(st1.nextToken());

		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		// 간선 입력 받기
		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());

			arr[a][b] = arr[b][a] = 1; // 양뱡향 그래프
		}

		dfs(start);

		visited = new boolean[N + 1]; // 배열 초기화
		sb.append("\n");
		bfs(start);

		System.out.println(sb);

	}

	public static void dfs(int start) { // 깊이 우선 탐색
		visited[start] = true;
		sb.append(start + " ");

		for (int i = 0; i <= N; i++) {
			if (arr[start][i] == 1 && !visited[i]) // 시작점에서 갈 수 있는 경로 중 방문을 안했다
				dfs(i); // 재귀적 호출
		}

	}

	public static void bfs(int start) { // 넓이 우선 탐색
		q.add(start);
		visited[start] = true;

		while (!q.isEmpty()) {// 큐가 빌때 까지
			start = q.poll();
			sb.append(start + " ");

			for (int i = 1; i <= N; i++) {
				if (arr[start][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}

}