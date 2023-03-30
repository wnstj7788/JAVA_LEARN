import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1767_프로세서연결하기 {
	private static class process {
		int x, y, len;

		public process(int x, int y, int len) {
			super();
			this.x = x;
			this.y = y;
			this.len = len;
		}
	}

	static int[][] map;
	static boolean subsetIsSelected[];
	static int[] subsetInput[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			ArrayList<process> pro = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int temp = Integer.parseInt(st.nextToken());
					if (temp == 1) {
						if (i == 0 || i == N || j == 0 || j == N) {
							map[i][j] = 2;
						} else {
							pro.add(new process(i, j, 0)); // 좌표랑 길이 넣어서 출발

						}
					}else
						map[i][j] = temp;

				}
			}// input end
			int size = pro.size();
			subsetIsSelected = new boolean[size];
			subset(0, pro.size());
		}//tc end 

	}

	private static void subset(int start, int end) {
		if(start == end) {
			for (int i = 0; i <end; i++) {
				if(subsetIsSelected[i]) {
					System.out.print(i + " ");
				} 
			}
			System.out.println();
			// 활성화 시킬 모든 경우로 comb  실행 
			
			return;
			
		}
		subsetIsSelected[start] = true;
		subset(start +1, end);
		subsetIsSelected[start] = false;
		subset(start +1, end);
		

	}

	private static void comb() {

	}

	private static void bfs() {

	}

	private static int[][] deepCopy() {
		return null;

	}
}
