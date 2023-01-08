import java.util.Scanner;

public class SWEA_1979 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			int n = sc.nextInt(); int k = sc.nextInt();
			
			int [][] arr = new int [n + 3][n + 3];
			for(int i = 0 ; i < n; i++) {
				for(int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
					}
			}
			int cnt = 0;
			for(int i = 0 ; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(j <= n && arr[i][j] == 1 && arr[i][j + 1] == 1 && arr[i][j + 2] ==1 && arr[i][j + 3] != 1) {
						cnt += 1;
						System.out.println("나 행 "+ cnt + " " + i + " "+j);
					}
					if(i <= n && arr[j][i] == 1 && arr[j][i + 1] == 1 && arr[j][i + 2] ==1 && arr[j][i + 3] != 1) {
						cnt += 1;
						System.out.println("나열 "+ cnt + " " + j + " "+i);
					}
					
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
			

	}

}