

import java.util.Scanner;

public class Solution_D3_2805_농작물_수확하기 {

	static int N;
	static int T;
	static int[][] map;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		T=scann.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N=scann.nextInt();
			map=new int[N][N];
			for (int i = 0; i < N; i++) {
				String s=scann.next();
				char[] c=s.toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j]=c[j]-'0';
				}
			}
			int r=sum(N,0,0);
			System.out.println("#"+t+" "+r);
		}

	}
	public static int sum(int n, int y, int x){
		int tot=0;
		for (int i = 0; i < n; i++) {
			int tt=Math.abs(i-n/2);
			for (int j = tt; j < n-tt; j++) {
				tot+=map[i+x][j+y];
				//System.out.printf("(%d,%d)",i,j);
			}
			//System.out.println();
		}
		return tot;
	}
}
