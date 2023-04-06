
import java.util.Scanner;

public class Solution_2117_홈방범서비스dfs {

	static int T;
	static int N, M;
	static int [][] map;
	static int profit;
	static int tHouse;
	static int hMax;
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		T=scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N=scann.nextInt();
			M=scann.nextInt();
			map=new int[N][N];
			tHouse=0;   // 집의 총개수
			for (int i = 0; i <N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j]=scann.nextInt();
					if(map[i][j]==1){
						tHouse++;
					}
				}
			}
			hMax=Integer.MIN_VALUE;
			for (int k = 1; k <= 2*N; k++) {
				dfs(0,0,k);
			}
			System.out.println("#"+t+" "+hMax);
		}
	}
	
	private static void dfs(int index, int cnt,  int k) {
		if(M*cnt-f(k)>=0){
			hMax=Math.max(hMax, cnt);
		}
		//1~n*n 까지 조사
		if(index+1==N*N){ 
			return ;
		}
		int nr=index/N;
		int nc=index%N;
		int tot=dia(2*k-1,nr-(k+1)/2,nc-(k+1)/2);
		dfs(index+1,tot,k);
	}
	//2805 농장물 수확하기 공식이용
	public static int dia(int n, int y, int x){
		int tot=0;
		for (int i = 0; i < n; i++) {
			int tt=Math.abs(i-n/2);
			for (int j = tt; j < n-tt; j++) {
				if(!check(i+y,j+x)){continue;}
				if(map[i+y][j+x]==1){
					tot++;
				}
			}
		}
		return tot;
	}
	public static boolean check(int r, int c){
		if(r>=0 && r<N && c>=0 && c<N){
			return true;
		}else return false;
	}
	public static int f(int k){
		return k*k+(k-1)*(k-1);
	}
}
