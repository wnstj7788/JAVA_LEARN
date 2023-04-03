import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {

	static class Virus {
		int x, y;

		public Virus(int x, int y) {
			super();
			this.x = x;
			this.y = y;

		}

	}

	static int map[][];
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	static int N, M;
	static boolean isSelected[];
	static ArrayList<Point> wall = new ArrayList<>();
	static int combSize;
	static int result = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 0) {
					combSize++; // 조합할 수 있는 사이즈 증가
					wall.add(new Point(i, j));
				}
				map[i][j] = temp;
			}

		} // input end
		
		
//		for(int[] temp : map) {
//			System.out.println(Arrays.toString(temp));
//		}
//		
		isSelected = new boolean[combSize];
		comb(0, 0);
		
		
		System.out.println(result);

	}

	private static void comb(int idx, int start) {
		if (idx == 3) {
			int[] resultWall = new int[3];
			int cnt = 0;
			for (int i = 0; i < combSize; i++) {
				if (isSelected[i]) {
					resultWall[cnt++] = i;
				}

			}
//			System.out.println("나 조합된 수" + Arrays.toString(resultWall));
			// 인덱스를 가지고 이동
			boolean[][] visitd = new boolean[N][M];
			int[][]copymap = deepcopy(map);
			for (int i = 0; i < 3; i++) {
				copymap[wall.get(resultWall[i]).x][wall.get(resultWall[i]).y] = 1;
			}
			
//			for(int[] temp : copymap) {
//				System.out.println(Arrays.toString(temp));
//			}
//			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			
			bfs(visitd,copymap);
			result = Math.max(result, bfs(visitd,copymap));
			return;

		}

		for (int i = start; i < combSize; i++) {
			isSelected[i] = true;
			comb(idx + 1, i + 1);
			isSelected[i] = false;
		}


	}

	private static int[][] deepcopy(int[][] map) {
		int[][] copymap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copymap[i][j] = map[i][j];
				
			}
		}
		return copymap;
	}

	private static int bfs(boolean[][] visitd, int[][] copymap) {
		Queue<Virus> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(copymap[i][j] == 2) {
					q.add(new Virus(i,j));
				}
			}
		}
		
//		for(int[] temp : copymap) {
//		System.out.println(Arrays.toString(temp));
//	}
//	System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//		
		
		while(!q.isEmpty()) {
			Virus now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visitd[nx][ny] && copymap[nx][ny] == 0) {
					q.add(new Virus(nx, ny));
					visitd[nx][ny] = true;
					copymap[nx][ny] = 2;
				}
			}
		} // 큐가 비면 
	
	
		
		
		return safeZone(copymap);

	}

	private static int safeZone(int[][] copymap) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(copymap[i][j] == 0) {
					cnt++;
				}
			}
		}
		
//		for(int[] temp : copymap) {
//		System.out.println(Arrays.toString(temp));
//	}
//	System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//		System.out.println("0을 확인해볼까?" + cnt);
		return cnt;
		// TODO Auto-generated method stub

	}

}
