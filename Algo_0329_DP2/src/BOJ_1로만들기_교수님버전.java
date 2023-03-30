import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1로만들기_교수님버전 {

	static int visit[];
	static int maxCnt, maxX;
	static int ans;
	static int X;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		visit = new int[X + 1];
		Arrays.fill(visit, Integer.MAX_VALUE);
		ans = Integer.MAX_VALUE;
//		dfs(X, 0);
		dp();
		System.out.println(ans);
//		System.out.println(bfs());

	}

	private static void dfs(int num, int cnt) {
		if (cnt >= ans)
			return; // 가지치기
		if (num == 1) {
			ans = Math.min(ans, cnt);
			return;
		}

		if (num % 3 == 0) {
			dfs(num / 3, cnt + 1);
		}

		if (num % 2 == 0) {
			dfs(num / 2, cnt + 1);
		}

		dfs(num - 1, cnt + 1);

	}

	private static int bfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[X + 1];

		q.add(X);
		visited[X] = true;
		int cnt = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int now = q.poll();
				if (now == 1) {
					return cnt;
				}
				if (now % 3 == 0 && !visited[now / 3]) {
					q.add(now / 3);
					visited[now / 3] = true;
				}
				if (now % 2 == 0 && !visited[now / 2]) {
					q.add(now / 2);
					visited[now / 2] = true;
				}
				if (visited[now / 3]) {
					q.add(now - 1);
					visited[now - 1] = true;
				}

			}
			cnt++;
		}
		return -1;

	}

	static void dp() {
		int[] memo = new int[X + 1];

		for (int i = 2; i <= X; i++) {
			memo[i] = memo[i - 1] + 1;
			if (i % 3 == 0) {
				memo[i] = Math.min(memo[i], memo[i / 3] + 1);
			}
			if (i % 2 == 0) {
				memo[i] = Math.min(memo[i], memo[i / 2] + 1);
			}
		}
		ans = memo[X];
	}

}
