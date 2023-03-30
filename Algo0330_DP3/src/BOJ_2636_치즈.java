import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2636_치즈 {
	static int[][] map;
	static ArrayList<Integer> cheesCnt = new ArrayList<>();
	static int totalChees;
	static int X, Y;
	static LinkedList<Point> chess;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		map = new int[X][Y];

		for (int i = 0; i < X; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < Y; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 1) {
					totalChees++;
				}
				map[i][j] = temp;
			}
		} // input end

		while (totalChees != 0) {
//		System.out.println("현재 totalChees: " + totalChees);
//		for(int[] temp : map) {
//			System.out.println(Arrays.toString(temp));
//		}
			bfs(0, 0);
			killingChess();
		}

		int result = cheesCnt.size();
		System.out.println(result);
		System.out.println(cheesCnt.get(result - 1));
	}

	private static void killingChess() {
		int size = chess.size();
		for (int i = 0; i < size; i++) {
			int x = chess.get(i).x;
			int y = chess.get(i).y;
			map[x][y] = 0;
		}
		cheesCnt.add(size);
		totalChees -= size;

	}

	private static void bfs(int x, int y) {
		boolean visited[][] = new boolean[X][Y];
		chess = new LinkedList<>();
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		visited[x][y] = true;
		while (!q.isEmpty()) {
			Point now = q.poll();
			for (int j = 0; j < 4; j++) {
				int nx = now.x + dx[j];
				int ny = now.y + dy[j];
				if (nx >= 0 && nx < X && ny >= 0 && ny < Y && !visited[nx][ny]) {
					if (map[nx][ny] == 1) {
						chess.add(new Point(nx, ny));
					} else {
						q.add(new Point(nx, ny));
					}
					visited[nx][ny] = true;

				}

			}

		}

	}

}
