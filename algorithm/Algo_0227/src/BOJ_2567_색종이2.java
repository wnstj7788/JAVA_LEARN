import java.util.Scanner;

public class BOJ_2567_색종이2 {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		
		int TC = sc.nextInt();
		
		int arr[][] = new int [101][101];
		
		for(int i=0; i<TC; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int j=x; j<x+10; j++) {
				for(int k=y; k<y+10; k++)
					arr[j][k] = 1;
			}
		}
		
		int cnt = 0;
		
		int dx[] = {-1,1,0,0};
		int dy[] = {0,0,1,-1};
		
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(arr[i][j] == 1) {
					for (int d = 0; d < dy.length; d++) {
						int  nx = i + dx[d];
						int  ny = j +dy[d];
						
						if(nx>=1&&nx<=100&&ny>=1&&ny<=100 && arr[nx][ny] == 0)
							cnt++;
						// 완전 벽인 경우 
						else if(nx<1 || nx>100 || ny<1 || ny>100)
							cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}
	
	

}
