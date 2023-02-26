import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026_적록색약 {
	public static class RGB {
		int color;
		int x;
		int y;

		public RGB(int color, int x, int y) {
			super();
			this.color = color;
			this.x = x;
			this.y = y;
		}

	}
	static boolean[][] vistied;
	static int N;
	static int map[][];
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		vistied = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp.charAt(j) - 'A';
			}
		} // end input

		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {				
				if(!vistied[i][j])
					cnt++;
					bfs(new RGB(map[i][j], i, j));

			}
		}

		System.out.println(cnt);
		
		
		// 적록 색약인 경우 다시 G-> R로 만들고 실행하자
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 6) {
					map[i][j] = 17;
				}
				
			}
		}
		// 방문배열 초기화 
		vistied = new boolean[N][N];
		int cnt_false = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {				
				if(!vistied[i][j])
					cnt_false++;
					bfs(new RGB(map[i][j], i, j));

			}
		}
		System.out.println(cnt_false);
		
		
		
		
		
		
		

	}// end main

	private static void bfs(RGB rgb) {
		// TODO Auto-generated method stub
	
		Queue<RGB> q = new LinkedList<>();
		q.add(new RGB(rgb.color, rgb.x, rgb.y));
		int target = rgb.color;

		
		vistied[rgb.x][rgb.y] = true;

	//	map[rgb.x][rgb.y] = 0;
			
		
		while (!q.isEmpty()) {
			RGB now = q.poll();

			if (now.color != target) {
				return;
			}
			
			for (int d = 0; d < 4; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !vistied[nx][ny] && map[nx][ny] == target) {
					
					q.add(new RGB(target, nx, ny));
					vistied[nx][ny] = true;
					//map[nx][ny] = 0;
					//print(map);
					
				}
			}

		}

	}

	private static void print(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------------------");
	}

}
