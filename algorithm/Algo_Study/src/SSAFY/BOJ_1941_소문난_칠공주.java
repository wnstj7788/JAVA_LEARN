package SSAFY;

import java.util.*;
import java.io.*;


public class BOJ_1941_소문난_칠공주 {
	// Y = 24
	// S = 18
	private static class type {
		int x, y, type;

		public type(int x, int y, int type) {
			super();
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}

	static int N = 5;
	static int result;
	static int[][] map;
	static boolean visited[][];
//	static int combS[];
//	static boolean combSisSelected[];
//	static int combY[];
//	static boolean combYisSelected[];

	static int combArr[];
	static boolean totoalSelected[]; //
	static ArrayList<type> list;

	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[N][N];
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				int num = temp[j] - 65;
				list.add(new type(i, j, num));

			}
		} // input end
		totoalSelected = new boolean[N * N];
		combArr = new int[7];
		comb(0, 0);
		System.out.println(result);

	}

	private static void comb(int idx, int start) {
		if (idx == 7) {
//			System.out.println(Arrays.toString(combArr));

			if (cheak(combArr)) {
				bfs(combArr);
			}
			return;
		}

		for (int j = start; j < 25; j++) {
			totoalSelected[j] = true;
			combArr[idx] = j;
			comb(idx + 1, j + 1);
			totoalSelected[j] = false;

		}

	}

	private static boolean cheak(int[] combArr) {
		int temp = 0;
		for (int i = 0; i < combArr.length; i++) {
			if (list.get(combArr[i]).type == 18) {
				temp++;
			}
		}
		if (temp >= 4) {
			return true;
		}
		return false;
	}

	private static void bfs(int[] combArr) {
//		System.out.println(Arrays.toString(combArr));
		Queue<Point> q = new LinkedList<>();
		map = new int[N][N];
		for (int i = 0; i < combArr.length; i++) {
			int x = list.get(combArr[i]).x;
			int y = list.get(combArr[i]).y;
			map[x][y] = 1;
		}

//		for(int temp[] : map) {
//		System.out.println(Arrays.toString(temp));
//	}
//	System.out.println("=====================================");
//		
//		
//		visited= new boolean[N][N];

		q.add(new Point(list.get(combArr[0]).x, list.get(combArr[0]).y));
//		visited[list.get(combArr[0]).x][list.get(combArr[0]).y] = true;
		map[list.get(combArr[0]).x][list.get(combArr[0]).y] = 9;

//		
//		for(int temp[] : map) {
//			System.out.println(Arrays.toString(temp));
//		}
//		System.out.println("=====================================");

		while (!q.isEmpty()) {
			Point now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 1) {
//					System.out.println("여기 드러오아 ");
					map[nx][ny] = 9;
//					for(int temp[] : map) {
//					System.out.println(Arrays.toString(temp));
//				}
//				System.out.println("=====================================");
					q.add(new Point(nx, ny));

				}
			}

		}

		if (resultCheak(map)) {
//		for(int temp[] : map) {
//		System.out.println(Arrays.toString(temp));
//	}
//	System.out.println("=====================================");

			result += 1;
		}

	}

	private static boolean resultCheak(int map[][]) {

		int temp = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {

					return false;
				}

			}
		}

		return true;
	}

}
