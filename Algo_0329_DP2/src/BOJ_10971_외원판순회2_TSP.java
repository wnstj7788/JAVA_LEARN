import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10971_외원판순회2_TSP {

	static int N;
	static boolean visited[];
	static int map[][];
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			//System.out.println("한바퀴 돌아왔다 이긋아 현재 사이클 : " + i);
//			result = Math.min(bfs(i),result);
			visited = new boolean[N];
			visited[i] = true;
			dfs(i, i, 0);
		}
		System.out.println(result);

	}

	public static void dfs(int start, int now, int cost) {
		if (allVisited()) {
			if (map[now][start] != 0) {
			//	System.out.println(map[now][start] + "map[now][start]");
				result = Math.min(result, cost + map[now][0]);
			}
			return;
		}

		for (int i = 1; i < N; i++) {
			if (!visited[i] && map[now][i] != 0) {
				visited[i] = true;
				dfs(start, i, cost + map[now][i]);
				visited[i] = false;
			}
		}
	}

	public static boolean allVisited() {
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				return false;
			}
		}
		return true;
	}

	private static int bfs(int i) {
		int index = Integer.MAX_VALUE;
		int sum = 0;
		visited = new boolean[N];
		Queue<Integer> q = new LinkedList<>();

		q.add(i);
		while (!q.isEmpty()) {
			int nowI = q.poll();
			System.out.println("나 왜 돌고있어> nowI" + nowI);
			for (int j = 0; j < N; j++) {
				if (!visited[j] && map[nowI][j] != 0) {
					int temp = map[nowI][j];
					index = Math.min(temp, index);
				}
			}
			for (int j = 0; j < N; j++) {
				if (index == map[nowI][j]) {
					q.add(j);
				}
			}
			sum += index;
			visited[nowI] = true;

		}
		return sum;

	}

}
