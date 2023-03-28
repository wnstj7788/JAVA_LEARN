import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1463_1로만들기_DFS {

	static int result = Integer.MAX_VALUE;
	static boolean visited[] = new boolean[1000001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Point point = new Point(n, 0);
		dfs(point);
		System.out.println(result);

	}

	private static void dfs(Point Point) {

		if (!visited[Point.x] && Point.x > 0 && result > Point.y) {
//			visited[Point.x] = true;
			if(Point.x == 1) {
				visited[Point.x] = false;
			}
			if (Point.x % 3 == 0) {
				dfs(new Point(Point.x / 3, Point.y + 1));

			}
			if (Point.x % 2 == 0) {
				dfs(new Point(Point.x / 2, Point.y + 1));

			}
			dfs(new Point(Point.x - 1, Point.y + 1));
			
			//System.out.println("나 여기 들어옴 n:" + Point.x + "conunt" + Point.y);
			if (Point.x == 1) {
				result = Math.min(result, Point.y);
			}

		}

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
