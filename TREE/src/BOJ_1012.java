//import java.util.Scanner;
//
//public class BOJ_1012 {
//	static int M,N,k;
//	static int[] dx = {-1,1,0,0};
//	static int[] dy = {0,0,-1,1};
//	
//	static int arr[][];
//	static boolean visited[][];
//	
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		int TC = sc.nextInt();
//		
//		for(int t =0; t< TC; t++ ) {
//			M = sc.nextInt();
//			N = sc.nextInt();
//			k =sc.nextInt();
//			
//			arr = new int[M][N];
//			visited = new boolean[M][N];
//			
//			for( int i = 0; i < k; i++) {
//				arr[sc.nextInt()][sc.nextInt()] = 1;
//				
//			}
//			
//			int cnt =0;
//			
//			
//			for (int i = 0; i < M; i++) {
//				for (int j = 0; j < N; j++) {
//					if(arr[i][j] ==1 && ! visited[i][j]) {
//						dfs(i,j);
//						cnt ++;
//					}
//				}
//				
//			}
//					System.out.println(cnt);
//					
//		}
//	}
//	
//	
//	public static void dfs(int x, int y) {
//		visited[x][y] = true;
//		
//		for (int i = 0; i < 4; i++) {
//			int nx = x + dx[i];
//			int ny = y + dy[i];
//			
//			
//			if(nx >= 0&& ny >=0 && nx<M && ny < N) {
//				if(arr[nx][ny] ==1 && !visited[nx][ny]) {
//					dfs(nx,ny);
//				}
//			}
//			
//		}
//	}
//}
