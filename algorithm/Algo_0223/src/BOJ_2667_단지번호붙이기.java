
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2667_단지번호붙이기 {
	static int N;
	static int map[][];
	static ArrayList<Integer> myhome = new ArrayList<>();
	static boolean visited[][];
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,-1,0,1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		} // input end
		
		int cnt = 0; // 단지의 개수 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					bfs(i,j);
					cnt += 1;
				}
			}
		} // serch end
		
		System.out.println(cnt);
		Collections.sort(myhome);
		for (int num : myhome) {
			System.out.println(num);
			
		}

	}// main end

	static void bfs(int si, int sj) {
		// 4방 탐색을 위한 4방 탐색 조건 명시

		Queue<Point> q = new LinkedList<>();
		q.add(new Point(si,sj));
		
		visited[si][sj] = true;
		int homeCnt = 0;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			homeCnt ++;
			for(int d = 0; d < 4 ; d++) {
				int nextI = now.x + dx[d];
				int nextJ = now.y + dy[d];
				if(nextI >= 0 && nextI < N && nextJ >=0 && nextJ <N && map[nextI][nextJ] == 1 &&!visited[nextI][nextJ]) {
					q.add(new Point(nextI, nextJ));
					visited[nextI][nextJ] = true;
				}
		
			}
		}
		myhome.add(homeCnt);

	}

}
