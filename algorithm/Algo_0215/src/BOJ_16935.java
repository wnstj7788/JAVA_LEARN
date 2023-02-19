import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16935 {
	static int n;
	static int m;
	static int r;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {//input
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<r; i++) {
			int num = Integer.parseInt(st.nextToken());
			solve(num);
			
		}
		
		
		for (int i = 0; i < map.length; i++) {//input
			for (int j = 0; j < map[0].length; j++) {
				sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	public static void solve(int num) {
		switch(num) {
		case 1 :
			button1();
			break;
		case 2:
			button2();
			break;
		case 3:
			button3();
			int temp = n;
			n = m;
			m = temp;
			break;
		case 4:
			button4();
			int temp1 = n;
			n = m;
			m = temp1;
			break;
		case 5:
			button5();
			break;
		case 6:
			button6();
			break;
		}
	}
	
	public static void button1() {//상하 반전
		int idx = n-1;
		int[][] temp = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				temp[i][j] = map[idx][j];
			}
			idx--;
		}
		map = temp;
	}
	
	public static void button2() {//좌우 반전
		int idx = m-1;
		int[][] temp = new int[n][m];
		
		for(int j=0; j<m; j++) {
			for(int i=0; i<n; i++) {
				temp[i][j] = map[i][idx];
			}
			idx--;
		}
		map = temp;
	}
	
	public static void button3() {//오른쪽으로 90도 회전
		int idx = n-1;
		int[][] temp = new int[m][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				temp[j][idx] = map[i][j];
			}
			idx--;
		}
		map = temp;
	}
	
	public static void button4() {
		int[][] temp1 = new int[m][n];
		Queue<Integer> temp = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				temp.add(map[i][j]);
			}
		}
		for(int i=0; i<n; i++) {
			for(int j= m-1; j>=0; j--) {
				temp1[j][i] = temp.poll();
			}
		}
		map = temp1;
	}
	
	public static void button5() {
		int[][] temp = new int[n][m];
		int x = n/2;
		int y = m/2;
		
		for(int i = 0; i<x; i++) {
			for(int j=0; j<y; j++) {
				temp[i][j+y] = map[i][j];
				temp[i+x][j+y] = map[i][j+y];
				temp[i+x][j] = map[i+x][j+y];
				temp[i][j] = map[i+x][j];
			}
		}

		map = temp;
	}
	
	public static void button6() {
		int[][] temp = new int[n][m];
		int x = n/2;
		int y = m/2;
		
		for(int i = 0; i<x; i++) {
			for(int j=0; j<y; j++) {
				temp[i+x][j+y] = map[i+x][j];
				temp[i][j+y] = map[i+x][j+y];
				temp[i+x][j] = map[i][j];
				temp[i][j] = map[i][j+y];
			}
		}
		map = temp;
	}

}