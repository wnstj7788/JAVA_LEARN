import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1463_1로만들기_BFS1 {

	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		System.out.println(bfs(n));

//		for (int i = 2; i <= n; i++) {
//			dp[i] = dp[i - 1] + 1; // 1로 뻬기
//
//			if (i % 3 == 0) // 3으로 나누어 떨어진다면
//				dp[i] = Math.min(dp[i], dp[i / 3] + 1) ;
//			if (i % 2 == 0) //2로 나누어 떨어진다면 
//				dp[i] = Math.min(dp[i], dp[i / 2] + 1) ;
//			
//
//		}
//		
////		System.out.println(Arrays.toString(dp));
//		System.out.println(dp[n]);
	}

	private static int bfs(int n) {
		Queue<Point> q = new LinkedList<>();
		boolean visited[] = new boolean[1000001];
		q.add(new Point(n, 0));

		while (!q.isEmpty()) {
			Point now = q.poll();
			int nx = now.x;
			if (nx < 1) {
				break;
			}
			if (!visited[nx]) {
				visited[nx] = true;
				if (nx % 3 == 0) {
					q.add(new Point(nx / 3, now.y + 1));
				
				}
				if (nx % 2 == 0) {
					q.add(new Point(nx / 2, now.y + 1));
			
				}
				q.add(new Point(nx - 1, now.y + 1));
			

//				System.out.println("나 여기 들어옴 n:" + nx + "conunt" + now.y);
				if (nx == 1) {
					result = Math.min(result, now.y);
				}
			}
		}

		return result;
	}

	public static class Point {
		int x;
		int y;

		public Point(int x, int y) {

			this.x = x;
			this.y = y;
		}

	}

}
