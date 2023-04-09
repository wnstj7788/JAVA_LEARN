package SSAFY;

import java.io.*;
import java.util.*;
public class BOJ_17144_미세먼지안녕 {

	// guswo ahrvy
	static int map[][];
	static boolean[][] visited;
	static int R, C, T;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for(int i = 0 ; i < R ; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		
		
	}

}
